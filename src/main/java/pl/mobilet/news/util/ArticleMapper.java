package pl.mobilet.news.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.entity.Article;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArticleMapper {

    public static List<Article> map(List<ArticleDto> dtos) {
        return dtos.stream().map(ArticleMapper::map).collect(Collectors.toList());
    }

    public static Article map(ArticleDto dto) {
        return Article.builder()
                .sourceId(dto.getSourceId())
                .sourceName(dto.getSourceName())
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .urlToImage(dto.getUrlToImage())
                .publishedAt(NewsUtils.stringToInstant(dto.getPublishedAt()))
                .content(dto.getContent())
                .build();
    }
}
