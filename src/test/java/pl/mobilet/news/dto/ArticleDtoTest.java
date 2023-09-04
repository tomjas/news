package pl.mobilet.news.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ArticleDtoTest {

    private ArticleDto dto;

    @BeforeEach
    void setUp() {
        dto = new ArticleDto();
    }

    @Test
    void getSourceIdNull() {
        assertNull(dto.getSourceId());
    }

    @Test
    void getSourceIdNotNull() {
        ArticleDto.SourceDto sourceDto = new ArticleDto.SourceDto();
        sourceDto.setId("id");
        dto.setSource(sourceDto);
        assertEquals("id", dto.getSourceId());
    }

    @Test
    void getSourceNameNull() {
        assertNull(dto.getSourceId());
    }

    @Test
    void getSourceNameNotNull() {
        ArticleDto.SourceDto sourceDto = new ArticleDto.SourceDto();
        sourceDto.setName("name");
        dto.setSource(sourceDto);
        assertEquals("name", dto.getSourceName());
    }
}