package ch.thegli.example.springboot.jokes.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JokesServiceImpl.class)
class JokesServiceImplTest {

    @MockBean
    private ChuckNorrisQuotes chuckNorrisQuotes;

    @Autowired
    private JokesServiceImpl jokesService;

    @Test
    void getRandomChuckNorrisQuote() {
        // arrange
        String expectedQuote = "Chuck Norris does no testing";
        when(chuckNorrisQuotes.getRandomQuote()).thenReturn(expectedQuote);

        // act
        String quote = jokesService.getRandomChuckNorrisQuote();

        // assert
        assertEquals(expectedQuote, quote);
    }
}
