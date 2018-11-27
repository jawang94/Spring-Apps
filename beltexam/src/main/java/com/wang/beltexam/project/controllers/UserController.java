package com.wang.beltexam.project.controllers;

import com.wang.beltexam.project.models.Role;
import com.wang.beltexam.project.models.Task;
import com.wang.beltexam.project.models.User;
import com.wang.beltexam.project.services.TaskService;
import com.wang.beltexam.project.services.UserService;
import com.wang.beltexam.project.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private UserValidator userValidator;
    private TaskService taskService;

    public UserController(UserService userService, UserValidator userValidator, TaskService taskService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.taskService = taskService;
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        List<Task> tasks = taskService.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "/views/dashboard.jsp";
    }

    @RequestMapping(value = "/home/desc")
    public String sortDesc(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        List<Task> tasks = taskService.findByDescPriority();
        model.addAttribute("tasks", tasks);
        return "/views/dashboard.jsp";
    }

    @RequestMapping(value = "/home/asc")
    public String sortAsc(Principal principal, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        List<Task> tasks = taskService.findByAscPriority();
        model.addAttribute("tasks", tasks);
        return "/views/dashboard.jsp";
    }


    @RequestMapping(value = {"/registration", "/login"})
    public String registerForm(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "/views/loginRegistration.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/views/loginRegistration.jsp";
        }
        else {
            userService.saveUser(user);
        }
        return "redirect:/home";
    }

}
