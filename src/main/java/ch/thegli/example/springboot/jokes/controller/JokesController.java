package ch.thegli.example.springboot.jokes.controller;

import ch.thegli.example.springboot.jokes.service.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokesController {

    private final JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @GetMapping("/")
    String getJoke(Model model) {
        model.addAttribute("joke", jokesService.getRandomChuckNorrisQuote());
        return "index";
    }
}
