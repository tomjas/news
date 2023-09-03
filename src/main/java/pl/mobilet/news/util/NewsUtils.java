package pl.mobilet.news.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NewsUtils {

    public static Instant stringToInstant(String stringDate) {
        return StringUtils.isNotBlank(stringDate) ? Instant.parse(stringDate) : null;
    }

}
