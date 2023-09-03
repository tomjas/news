package pl.mobilet.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.dto.RequestParams;
import pl.mobilet.news.entity.Article;
import pl.mobilet.news.repository.ArticleRepository;
import pl.mobilet.news.util.ArticleMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {

    private final HttpService httpService;
    private final ArticleRepository repository;

    private static final int DEFAULT_LIMIT = 100;
    private static final int DEFAULT_OFFSET = 0;

    @Transactional(rollbackFor = {URISyntaxException.class, IOException.class, InterruptedException.class})
    public void synchronize() {
        try {
            List<ArticleDto> dtos = httpService.getArticles();
            List<Article> articles = ArticleMapper.map(dtos);
            repository.saveAll(articles);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.error(e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }

    }

    public List<Article> findAll(RequestParams params) {
        validateInput(params);
        return repository.findAll(params.getLimit(), params.getOffset());
    }

    void validateInput(RequestParams params) {
        Integer limit = params.getLimit();
        if (limit != null) {
            if (limit < 1) {
                throw new IllegalArgumentException("Limit cannot be lower than 1");
            }
        } else {
            params.setLimit(DEFAULT_LIMIT);
        }

        Integer offset = params.getOffset();
        if (offset != null) {
            if (offset < 0) {
                throw new IllegalArgumentException("Offset cannot be lower than 0");
            }
        } else {
            params.setOffset(DEFAULT_OFFSET);
        }
    }
}
