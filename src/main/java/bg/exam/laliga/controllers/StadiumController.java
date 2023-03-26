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
        modelAndView.setViewName("stadiums");

        return modelAndView;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StadiumEntity>> allStadiums() {
        return ResponseEntity.ok(this.stadiumRepository.findAll());
    }

    @GetMapping("/{name}")
    public ModelAndView stadiumById(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stadiumInfo");
        modelAndView.addObject("stadium", this.stadiumRepository.findByName(name).orElseThrow());

        return modelAndView;
    }

}
