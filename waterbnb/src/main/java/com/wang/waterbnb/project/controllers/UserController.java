package com.wang.waterbnb.project.controllers;

import com.wang.waterbnb.project.models.Pool;
import com.wang.waterbnb.project.models.Role;
import com.wang.waterbnb.project.models.User;
import com.wang.waterbnb.project.services.PoolService;
import com.wang.waterbnb.project.services.UserService;
import com.wang.waterbnb.project.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private UserValidator userValidator;
    private PoolService poolService;

    public UserController(UserService userService, UserValidator userValidator, PoolService poolService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.poolService = poolService;
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        List<User> allHosts = userService.findHosts();
        if (allHosts.contains(currentUser)) {
            return "redirect:/host";
        }
        else {
            return "redirect:/search";
        }
    }

    @RequestMapping(value = {"/registration", "/login"})
    public String registerForm(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        List<Role> roles = userService.findAllRoles();
        model.addAttribute("roles", roles);
        return "/views/loginRegistration.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            List<Role> roles = userService.findAllRoles();
            model.addAttribute("roles", roles);
            return "/views/loginRegistration.jsp";
        }
        else {
            userService.saveUser(user);
        }
        return "redirect:/login";
    }

    @RequestMapping("/host")
    public String adminPage(Principal principal, Model model, @Valid @ModelAttribute("pool") Pool pool) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        List<String> size = Arrays.asList("Small", "Medium", "Large");
        model.addAttribute("size", size);
        List<Double> cost = Arrays.asList(100.0, 200.0, 300.0);
        model.addAttribute("cost", cost);
        List<Pool> pools = poolService.findAllPools();
        model.addAttribute("pools", pools);
        return "/views/dashboard.jsp";
    }
}