package pl.mobilet.news.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto extends ResponseDto {

    private SourceDto source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    @Getter
    @Setter
    public static class SourceDto {
        private String id;
        private String name;
    }
}
