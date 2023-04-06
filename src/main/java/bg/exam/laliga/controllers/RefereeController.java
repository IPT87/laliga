package bg.exam.laliga.controllers;

import bg.exam.laliga.services.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/referees")
public class RefereeController {

    private final RefereeService refereeService;

    @Autowired
    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    public ModelAndView toReferees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("referees");

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView allReferees() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("referees");
        modelAndView.addObject("referees", this.refereeService.allReferees());

        return modelAndView;
    }

    @GetMapping("/{name}")
    public ModelAndView refereeByName(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("refereeInfo");
        modelAndView.addObject("referee", this.refereeService.getRefereeByName(name).orElseThrow());

        return modelAndView;
    }

}
