package ru.kata.spring.rest.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.kata.spring.rest.api.model.User;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.rest.api.service.UserService;
import java.security.Principal;

@Controller
//@RequestMapping("/")
@RequestMapping
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return "redirect:/login";
    }
    @GetMapping("/admin")
    public String showUsers(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "admin-user";
    }
    @GetMapping("/user")
    public String showUserDetails(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "userdetails";
    }
}
