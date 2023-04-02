package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.*;
import bg.exam.laliga.domain.enums.PositionEnum;
import bg.exam.laliga.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("administrationPanel")
public class AdminController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final PlayerService playerService;
    private final StadiumService stadiumService;
    private final RefereeService refereeService;
    private final CoachService coachService;
    private final TeamService teamService;

    @Autowired
    public AdminController(PlayerService playerService, StadiumService stadiumService, RefereeService refereeService, CoachService coachService, TeamService teamService) {
        this.playerService = playerService;
        this.stadiumService = stadiumService;
        this.refereeService = refereeService;
        this.coachService = coachService;
        this.teamService = teamService;
    }

    @GetMapping
    public String toAdminPanel() {
        return "administrationPanel";
    }

    @GetMapping("/addPlayer")
    public ModelAndView toAddPlayer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPlayer");
        modelAndView.addObject("allPositions", PositionEnum.values());

        return modelAndView;
    }

    @GetMapping("/addTeam")
    public ModelAndView toAddTeam() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTeam");
        modelAndView.addObject("allPlayers", this.playerService.allPlayersNames());

        return modelAndView;
    }

    @GetMapping("/addStadium")
    public String toAddStadium() {
        return "addStadium";
    }

    @GetMapping("/addCoach")
    public String toAdCoach() {
        return "addCoach";
    }

    @GetMapping("/addReferee")
    public String toAddReferee() {
        return "addReferee";
    }

    @GetMapping("/modifyUser")
    public String toModifyUser() {
        return "modifyUser";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@Valid @ModelAttribute(name = "addPlayerForm") AddPlayerFormDto addNewPlayer,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("playerForm", addNewPlayer)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addPlayerForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addPlayer";
        }

        this.playerService.addNewPlayer(addNewPlayer);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:addPlayer";
    }

    @PostMapping("/addStadium")
    public String addStadium(@Valid @ModelAttribute(name = "addStadiumForm") AddStadiumFormDto addNewStadium,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("stadiumForm", addNewStadium)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addStadiumForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addStadium";
        }

        this.stadiumService.addNewStadium(addNewStadium);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:addStadium";
    }

    @PostMapping("/addReferee")
    public String addReferee(@Valid @ModelAttribute(name = "addRefereeForm") AddRefereeFormDto addNewReferee,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("refereeForm", addNewReferee)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addRefereeForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addReferee";
        }

        this.refereeService.addNewReferee(addNewReferee);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:addReferee";
    }

    @PostMapping("/addCoach")
    public String addCoach(@Valid @ModelAttribute(name = "addCoachForm") AddCoachFormDto addNewCoach,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("coachForm", addNewCoach)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addCoachForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addCoach";
        }

        this.coachService.addNewCoach(addNewCoach);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:addCoach";
    }

    @PostMapping("/addTeam")
    public String addTeam(@Valid @ModelAttribute(name = "addTeamForm") AddTeamFormDto addNewTeam,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("teamForm", addNewTeam)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addTeamForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addTeam";
        }

        this.teamService.addNewTeam(addNewTeam);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:addTeam";
    }

}
