package pl.mobilet.news.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NewsUtils {

    public static final String NEWSAPI_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static Instant stringToInstant(String stringDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(NEWSAPI_DATE_FORMAT);
        LocalDateTime localDateTime = LocalDateTime.parse(stringDate, dateTimeFormatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.UTC);
        return zonedDateTime.toInstant();
    }

}
