package pl.mobilet.news.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.entity.Article;
import pl.mobilet.news.repository.ArticleRepository;
import pl.mobilet.news.util.ArticleMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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
            log.error(e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }

    }

    public List<Article> findAll() {
        List<Article> articles = repository.findAll();
        articles.sort(Comparator.comparing(Article::getPublishedAt).reversed());
        return articles;
    }
}
