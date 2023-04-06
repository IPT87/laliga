package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.TeamStandingsDto;
import bg.exam.laliga.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ModelAndView toLeaderBoard() {
        return new ModelAndView("standingsTable");
    }

    @GetMapping("/standings")
    public ResponseEntity<List<TeamStandingsDto>> standings() {
        return ResponseEntity.ok(this.teamService.getTeamsStandings());
    }

    @GetMapping("/info/{name}")
    public ModelAndView teamInfo(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        modelAndView.addObject("team", this.teamService.getTeamByName(name));

        return modelAndView;
    }

}
