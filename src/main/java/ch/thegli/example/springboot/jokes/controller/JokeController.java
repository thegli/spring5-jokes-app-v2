package ch.thegli.example.springboot.jokes.controller;

import ch.thegli.example.springboot.jokes.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/")
    String getJoke(Model model) {
        model.addAttribute("joke", jokeService.getRandomChuckNorrisQuote());
        return "index";
    }
}
