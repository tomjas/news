package pl.mobilet.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.entity.Article;
import pl.mobilet.news.repository.ArticleRepository;
import pl.mobilet.news.util.ArticleMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final HttpService httpService;
    private final ArticleRepository repository;

    @Transactional
    public void synchronize() {
        try {
            List<ArticleDto> dtos = httpService.getArticles();
            List<Article> article = ArticleMapper.map(dtos);
            repository.saveAll(article);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Article> findAll() {
        return repository.findAll();
    }
}
