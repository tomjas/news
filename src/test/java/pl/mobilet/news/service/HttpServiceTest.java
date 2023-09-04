package pl.mobilet.news.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mobilet.news.dto.ResponseDto;
import pl.mobilet.news.exception.DownloadArticlesException;

import static org.junit.jupiter.api.Assertions.*;

class HttpServiceTest {

    private HttpService httpService;

    @BeforeEach
    void setUp() {
        httpService = new HttpService();
    }

    @Test
    void shouldThrowExceptionValidateResponse() {
        //when
        ResponseDto dto = new ResponseDto();
        dto.setStatus("error");
        dto.setMessage("Test message");

        //when
        DownloadArticlesException exception = assertThrows(DownloadArticlesException.class,
                ()-> httpService.validateResponse(dto));

        //then
        assertEquals("Test message", exception.getMessage());
    }

    @Test
    void shouldNotThrowExceptionValidateResponse() {
        //given
        ResponseDto dto = new ResponseDto();
        dto.setStatus("success");

        //then
        assertDoesNotThrow(()-> httpService.validateResponse(dto));
    }
}