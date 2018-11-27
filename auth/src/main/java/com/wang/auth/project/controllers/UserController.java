package com.wang.auth.project.controllers;

import com.wang.auth.project.models.Role;
import com.wang.auth.project.models.User;
import com.wang.auth.project.services.UserService;
import com.wang.auth.project.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        List<User> allAdmins = userService.findAdmins();
        if (allAdmins.contains(currentUser)) {
            return "redirect:/admin";
        }
        else {
            return "/views/homePage.jsp";
        }
    }

    @RequestMapping("/myHome")
    public String redirectHome(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        return "/views/homePage.jsp";
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "/views/registrationPage.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/views/registrationPage.jsp";
        }
        if (userService.findNumberOfAdmins() > 0) {
            userService.saveWithUserRole(user);
        }
        else if (userService.findNumberOfAdmins() == 0) {
           userService.saveUserWithAdminRole(user);
        }
        return "redirect:/login";
    }

    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        Role admin = userService.findAdminRole();
        model.addAttribute("admin", admin);
        return "/views/adminPage.jsp";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "/views/loginPage.jsp";
    }

    @RequestMapping("/makeAdmin/{id}")
    public String makeAdmin(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id);
        userService.makeAdmin(user);
        return "redirect:/admin";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}