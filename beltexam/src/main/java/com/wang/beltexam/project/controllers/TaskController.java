package com.wang.beltexam.project.controllers;

import com.wang.beltexam.project.models.Task;
import com.wang.beltexam.project.models.User;
import com.wang.beltexam.project.services.TaskService;
import com.wang.beltexam.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @RequestMapping("/tasks/new")
    public String newTask(Principal principal, Model model, @ModelAttribute("task") Task task, @ModelAttribute("error") String error ) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        List<String> priority = Arrays.asList("Low", "Medium", "High");
        model.addAttribute("priority", priority);
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "/views/createTask.jsp";
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public String createTask(Model model, RedirectAttributes ra, Principal principal, @Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            String username = principal.getName();
            User currentUser = userService.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
            List<String> priority = Arrays.asList("Low", "Medium", "High");
            model.addAttribute("priority", priority);
            List<User> users = userService.findAllUsers();
            model.addAttribute("users", users);
            return "/views/createTask.jsp";
        } else {
            User u = userService.findById(id);
            List<User> assignee = task.getAssignee();
            for (User user : assignee) {
                if (user.getAssignedTasks().size() >= 3) {
                    ra.addFlashAttribute("error", "This user already has 3 assigned tasks");
                    return "redirect:/tasks/new";
                }
            }
            Task newTask = taskService.createTask(task, u);
            return "redirect:/home";
        }
    }


    @RequestMapping(value = "/task/{tId}", method = RequestMethod.GET)
    public String showTask(Principal principal, @PathVariable(value = "tId") Long tId, Model model) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        Task task = taskService.findById(tId);
        model.addAttribute("task", task);
        return "/views/showTask.jsp";
    }

    @RequestMapping(value = "/edit/{tId}", method = RequestMethod.GET)
    public String editTask(Model model, Principal principal, @ModelAttribute(value = "task") Task task, @PathVariable(value = "tId") Long tId) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        Task t = taskService.findById(tId);
        model.addAttribute("t", t);
        List<String> priority = Arrays.asList("Low", "Medium", "High");
        model.addAttribute("priority", priority);
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        User creator = t.getCreator();
        if (currentUser.getId() != creator.getId()) {
            return "redirect:/task/" + tId;
        }
        return "/views/editTask.jsp";
    }

    @RequestMapping(value = "/edit/{tId}", method = RequestMethod.POST)
    public String processEdit(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable(value = "tId") Long tId) {
        if (result.hasErrors()) {
            return "redirect:/edit/" + tId;
        } else {
            Task editedTask = taskService.editTask(task, tId);
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/delete/{tId}")
    public String deleteTask(@PathVariable(value = "tId") Long tId) {
        taskService.deleteTask(tId);
        return "redirect:/home";
    }}
