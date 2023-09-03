package pl.mobilet.news.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class NewsUtilsTest {

    @Test
    void shouldParseStringToInstant() {
        //given
        String stringDate = "2023-09-03T17:28:06Z";
        Instant expected = Instant.parse(stringDate);

        //when
        Instant result = NewsUtils.stringToInstant(stringDate);

        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldParseStringToInstantWhenNull() {
        //given
        String stringDate = null;
        Instant expected = null;

        //when
        Instant result = NewsUtils.stringToInstant(stringDate);

        //then
        assertEquals(expected, result);
    }
}