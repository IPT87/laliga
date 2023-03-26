package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public ModelAndView toPlayers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("players");

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView allPlayers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("players");
        modelAndView.addObject("players", this.playerRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/{name}")
    public ModelAndView playerByName(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("playerInfo");
        modelAndView.addObject("player", this.playerRepository.findByName(name).orElseThrow());

        return modelAndView;
    }



}
