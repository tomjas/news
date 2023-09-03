package pl.mobilet.news.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "article")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "source_id", length = 1000)
    private String sourceId;

    @Column(name = "source_name", length = 1000)
    private String sourceName;

    @Column(name = "author", length = 1000)
    private String author;

    @Column(name = "title", length = 1000)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "url", length = 1000)
    private String url;

    @Column(name = "url_to_image", length = 1000)
    private String urlToImage;

    @Column(name = "published_at", length = 1000)
    private Instant publishedAt;

    @Column(name = "content", length = 1000)
    private String content;

}
