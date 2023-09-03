package pl.mobilet.news.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
public class DownloadArticlesException extends RuntimeException {

    public DownloadArticlesException(String message) {
        super(message);
    }
}
