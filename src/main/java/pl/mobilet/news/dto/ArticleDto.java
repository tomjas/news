package pl.mobilet.news.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleDto {

    private SourceDto source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    @JsonIgnore
    public String getSourceId() {
        return getSource() != null ? getSource().getId() : null;
    }

    @JsonIgnore
    public String getSourceName() {
        return getSource() != null ? getSource().getName() : null;
    }

    @Getter
    @Setter
    public static class SourceDto {
        private String id;
        private String name;
    }
}
