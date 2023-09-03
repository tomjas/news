package pl.mobilet.news.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.dto.ResponseDto;
import pl.mobilet.news.exception.DownloadArticlesException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class HttpService {

    public static final int CONNECTION_TIMEOUT = 20;
    @Value("${x.api.key}")
    private String xApiKey;

    @Value("${newsapi.url}")
    private String url;

    private static final String ERROR = "error";
    private static final int NUMBER_OF_PAGES = 5;
    public static final String PAGE = "&page=";
    public static final String X_API_KEY = "X-Api-Key";

    public List<ArticleDto> getArticles() throws URISyntaxException, IOException, InterruptedException {

        List<ArticleDto> dtos = new ArrayList<>();
        HttpClient client = getHttpClient();

        HttpResponse<String> response;
        HttpRequest request;
        for (int i = 1; i <= NUMBER_OF_PAGES; i++) {
            request = getHttpRequest(i);
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            ResponseDto responseDto = mapper.readValue(response.body(), ResponseDto.class);
            validateResponse(responseDto);
            dtos.addAll(responseDto.getArticles());
        }
        log.debug("Number of downloaded articles {}", dtos.size());
        return dtos;

    }

    private HttpRequest getHttpRequest(int PAGE_NUMBER) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(url + PAGE + PAGE_NUMBER))
                .header(X_API_KEY, xApiKey)
                .GET()
                .build();
    }

    private static HttpClient getHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT))
                .build();
    }

    private void validateResponse(ResponseDto responseDto) {
        if (StringUtils.equals(ERROR, responseDto.getStatus())) {
            log.error("{}->{}", responseDto.getCode(), responseDto.getMessage());
            throw new DownloadArticlesException(responseDto.getMessage());
        }
    }

}
