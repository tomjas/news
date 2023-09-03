package pl.mobilet.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mobilet.news.dto.RequestParams;
import pl.mobilet.news.entity.Article;
import pl.mobilet.news.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    public static final String LIMIT = "LIMIT";
    public static final String OFFSET = "OFFSET";

    private final ArticleService articleService;

    @GetMapping(value = "/synchronize")
    public void synchronize() {
        articleService.synchronize();
    }

    @GetMapping(value = "/messages")
    public List<Article> getMessages(@RequestParam(value = LIMIT, required = false) Integer limit,
                                     @RequestParam(value = OFFSET, required = false) Integer offset) {
        return articleService.findAll(new RequestParams(limit, offset));
    }
}
