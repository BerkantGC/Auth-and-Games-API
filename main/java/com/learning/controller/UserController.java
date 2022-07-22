package com.learning.controller;

import com.learning.model.User;
import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("Login Request: " + user);
        User loggedUser = userService.authenticate(user.getLogin(), user.getPassword());

        if(loggedUser == null){
            return "error_page";
        } else {
            model.addAttribute("userLogin", loggedUser.getLogin());
            return "redirect:/main/" + loggedUser.getLogin();
        }
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("Register request: " + user);
        User registeredUser = userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @GetMapping("/main/{login}")
    public String getMainPage(@PathVariable(name = "login") String login, Model model){
        model.addAttribute("userId", login);
        return "main_page";
    }
}
