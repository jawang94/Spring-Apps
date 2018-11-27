package com.wang.authentication.project.controllers;


import com.wang.authentication.project.models.User;
import com.wang.authentication.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/views/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "/views/loginPage.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/registration";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        if (!userService.authenticateUser(email,password)) {
            String error = "Invalid Email or Password";
            model.addAttribute("error", error);
            return "/redirect:/login";
        } else {
            User u = userService.findByEmail(email);
            Long id = u.getId();
            session.setAttribute("userId", id);
            return "redirect:/home";
        }
    }


    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        Long id = Long.parseLong(session.getAttribute("userId").toString());
        User u = userService.findUserById(id);
        model.addAttribute("user", u);
        return "/views/homePage.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}