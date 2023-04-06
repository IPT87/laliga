package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.entities.CoachEntity;
import bg.exam.laliga.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coach")
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<CoachEntity> getCoach(@PathVariable("name") String name) {
        System.out.println();
        String[] data = name.split(" ");
        String coachFirstName = data[0];
        String coachLastName = data[1];

        CoachEntity coach = this.coachService.findCoachByNameAndLastName(coachFirstName, coachLastName);

        return ResponseEntity.ok(coach);

    }

}
