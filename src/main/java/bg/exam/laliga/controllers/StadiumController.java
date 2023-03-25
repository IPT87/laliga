package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.entities.StadiumEntity;
import bg.exam.laliga.repositories.StadiumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumRepository stadiumRepository;

    public StadiumController(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    @GetMapping
    public ModelAndView toStadium() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stadiumInfo");

        return modelAndView;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StadiumEntity>> allStadiums() {
        return ResponseEntity.ok(this.stadiumRepository.findAll());
    }

}
