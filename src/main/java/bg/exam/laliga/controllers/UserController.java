package bg.exam.laliga.controllers;

import bg.exam.laliga.domain.dto.UserToModifyDto;
import bg.exam.laliga.domain.entities.UserEntity;
import bg.exam.laliga.domain.enums.UserRoleEnum;
import bg.exam.laliga.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{username}")
    public ModelAndView getUserById(@PathVariable("username") String username) {

        UserEntity userEntity = this.userService.getUser(username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modifyUser");
        modelAndView.addObject("allRoles", UserRoleEnum.values());
        modelAndView.addObject("currentRoles", userEntity.getRoles().stream().toList());
        modelAndView.addObject("userToModify", userEntity);

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("allUsers", this.userService.getAllUsers());

        return modelAndView;
    }

    @PostMapping("/userModify")
    public ModelAndView modifyUser(@ModelAttribute(name = "userModified") UserToModifyDto userModified) {

        this.userService.changeUserRole(userModified);

        return allUsers();
    }

    @GetMapping("/delete/{username}")
    public ModelAndView deleteUser(@PathVariable("username") String username) {
        this.userService.deleteUser(username);

        return allUsers();
    }

}
