package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.AddPlayerFormDto;
import bg.exam.laliga.domain.dto.AddStadiumFormDto;
import bg.exam.laliga.services.PlayerService;
import bg.exam.laliga.services.StadiumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("administrationPanel")
public class AdminController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final PlayerService playerService;
    private final StadiumService stadiumService;

    @Autowired
    public AdminController(PlayerService playerService, StadiumService stadiumService) {
        this.playerService = playerService;
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public String toAdminPanel() {
        return "administrationPanel";
    }

    @GetMapping("/addPlayer")
    public String toAddPlayer() {
        return "addPlayer";
    }

    @GetMapping("/addTeam")
    public String toAddTeam() {
        return "addTeam";
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

        return "redirect:addPlayer";
    }

    @PostMapping("/addStadium")
    public String addStadium(@Valid @ModelAttribute(name = "addStadiumForm") AddStadiumFormDto addNewStadium,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()));

            redirectAttributes.addFlashAttribute("playerForm", addNewStadium)
                    .addFlashAttribute(BINDING_RESULT_PATH + "addStadiumForm", bindingResult)
                    .addFlashAttribute("errorFields", errors);

            return "redirect:addStadium";
        }

        this.stadiumService.addNewStadium(addNewStadium);

        return "redirect:addStadium";
    }

}
