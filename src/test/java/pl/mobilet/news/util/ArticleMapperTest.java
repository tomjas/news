package pl.mobilet.news.util;

import org.junit.jupiter.api.Test;
import pl.mobilet.news.dto.ArticleDto;
import pl.mobilet.news.entity.Article;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleMapperTest {

    @Test
    void shouldMapCollection() {
        //given
        ArticleDto dto1 = new ArticleDto();
        ArticleDto.SourceDto sourceDto1 = new ArticleDto.SourceDto();
        dto1.setSource(sourceDto1);

        dto1.getSource().setId("source id1");
        dto1.getSource().setName("source name1");
        dto1.setAuthor("author1");
        dto1.setTitle("title1");
        dto1.setDescription("description1");
        dto1.setUrl("url1");
        dto1.setUrlToImage("url to image1");
        dto1.setPublishedAt("2023-09-03T17:28:06Z");
        dto1.setContent("content1");

        Article article1 = Article.builder()
                .sourceId("source id1")
                .sourceName("source name1")
                .author("author1")
                .title("title1")
                .description("description1")
                .url("url1")
                .urlToImage("url to image1")
                .publishedAt(Instant.parse("2023-09-03T17:28:06Z"))
                .content("content1")
                .build();

        ArticleDto dto2 = new ArticleDto();
        ArticleDto.SourceDto sourceDto2 = new ArticleDto.SourceDto();
        dto2.setSource(sourceDto2);

        dto2.getSource().setId("source id2");
        dto2.getSource().setName("source name2");
        dto2.setAuthor("author2");
        dto2.setTitle("title2");
        dto2.setDescription("description2");
        dto2.setUrl("url2");
        dto2.setUrlToImage("url to image2");
        dto2.setPublishedAt("2023-09-03T17:28:06Z");
        dto2.setContent("content2");

        Article article2 = Article.builder()
                .sourceId("source id2")
                .sourceName("source name2")
                .author("author2")
                .title("title2")
                .description("description2")
                .url("url2")
                .urlToImage("url to image2")
                .publishedAt(Instant.parse("2023-09-03T17:28:06Z"))
                .content("content2")
                .build();

        List<ArticleDto> dtos = new ArrayList<>(){{
            add(dto1);
            add(dto2);
        }};

        List<Article> expected = new ArrayList<>(){{
            add(article1);
            add(article2);
        }};

        //when
        List<Article> result = ArticleMapper.map(dtos);

        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldMapSingle() {
        //given
        ArticleDto dto = new ArticleDto();
        ArticleDto.SourceDto sourceDto = new ArticleDto.SourceDto();
        dto.setSource(sourceDto);

        dto.getSource().setId("source id");
        dto.getSource().setName("source name");
        dto.setAuthor("author");
        dto.setTitle("title");
        dto.setDescription("description");
        dto.setUrl("url");
        dto.setUrlToImage("url to image");
        dto.setPublishedAt("2023-09-03T17:28:06Z");
        dto.setContent("content");

        Article expected = Article.builder()
                .sourceId("source id")
                .sourceName("source name")
                .author("author")
                .title("title")
                .description("description")
                .url("url")
                .urlToImage("url to image")
                .publishedAt(Instant.parse("2023-09-03T17:28:06Z"))
                .content("content")
                .build();

        //when
        Article resutl = ArticleMapper.map(dto);

        //then
        assertEquals(expected, resutl);
    }
}