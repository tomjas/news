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
                //TODO check for null?
                .sourceId(dto.getSource().getId())
                //TODO check for null?
                .sourceName(dto.getSource().getName())
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .urlToImage(dto.getUrlToImage())
                //TODO convert String to Timestamp UTC
//                .publishedAt(dto.getPublishedAt())
                .content(dto.getContent())
                .build();
    }
}
