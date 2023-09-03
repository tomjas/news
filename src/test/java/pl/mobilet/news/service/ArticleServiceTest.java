package pl.mobilet.news.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.mobilet.news.dto.RequestParams;
import pl.mobilet.news.repository.ArticleRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    private HttpService httpService;

    @Mock
    private ArticleRepository repository;

    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        articleService = new ArticleService(httpService, repository);
    }

    @Test
    void shouldSetDefaultParams() {
        //given
        RequestParams params = new RequestParams(null, null);

        //when
        articleService.validateInput(params);

        //then
        assertEquals(params.getLimit(), 100);
        assertEquals(params.getOffset(), 0);
    }

    @Test
    void shouldThrowExceptionOnLimit() {

        //given
        RequestParams params = new RequestParams(0, -1);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> articleService.validateInput(params));

        //then
        assertEquals("Limit cannot be lower than 1", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionOnOffset() {

        //given
        RequestParams params = new RequestParams(10, -1);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> articleService.validateInput(params));

        //then
        assertEquals("Offset cannot be lower than 0", exception.getMessage());
    }
}