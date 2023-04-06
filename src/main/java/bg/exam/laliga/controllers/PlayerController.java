package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.PlayerGoalsAndPassesDto;
import bg.exam.laliga.domain.entities.PlayerEntity;
import bg.exam.laliga.repositories.PlayerRepository;
import bg.exam.laliga.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
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

    @GetMapping("stats")
    public ResponseEntity<List<PlayerGoalsAndPassesDto>> playerGoalsAndPasses() {
        return ResponseEntity.ok(this.playerService.playerGoalsAndPassesDtoList());
    }

    @GetMapping("byTeam/{teamName}")
    public ResponseEntity<List<PlayerEntity>> allPlayersByTeam(@PathVariable("teamName") String teamName) {
        return ResponseEntity.ok(this.playerService.allPlayersByTeam(teamName));
    }

}
