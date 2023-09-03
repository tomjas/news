package pl.mobilet.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mobilet.news.entity.Article;
import pl.mobilet.news.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping(value = "/synchronize")
    public void synchronize()  {
        articleService.synchronize();
    }

    @GetMapping(value = "/messages")
    public List<Article> getMessages() {
        return articleService.findAll();
    }
}
