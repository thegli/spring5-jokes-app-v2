package ch.thegli.example.springboot.jokes.controller;

import ch.thegli.example.springboot.jokes.service.JokesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JokesController.class)
class JokesControllerTest {

    @MockBean
    private JokesServiceImpl jokesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getJoke() throws Exception {
        when(jokesService.getRandomChuckNorrisQuote()).thenReturn("Test test test");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

        verify(jokesService).getRandomChuckNorrisQuote();
    }
}
