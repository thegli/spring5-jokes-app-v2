package ch.thegli.example.springboot.jokes.controller;

import ch.thegli.example.springboot.jokes.service.JokeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JokeController.class)
class JokeControllerTest {

    @MockBean
    private JokeServiceImpl jokesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getJoke() throws Exception {
        String expectedJoke = "Test test test";
        when(jokesService.getRandomChuckNorrisQuote()).thenReturn(expectedJoke);

        String responseString = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertTrue(responseString.contains(expectedJoke));
        verify(jokesService).getRandomChuckNorrisQuote();
    }
}
