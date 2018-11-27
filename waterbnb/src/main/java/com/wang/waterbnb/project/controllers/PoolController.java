package com.wang.waterbnb.project.controllers;

import com.wang.waterbnb.project.models.Pool;
import com.wang.waterbnb.project.models.Review;
import com.wang.waterbnb.project.models.User;
import com.wang.waterbnb.project.services.PoolService;
import com.wang.waterbnb.project.services.ReviewService;
import com.wang.waterbnb.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class PoolController {
    private final PoolService poolService;
    private final UserService userService;
    private final ReviewService reviewService;

    public PoolController (PoolService poolService, UserService userService, ReviewService reviewService) {
        this.poolService = poolService;
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public String createPool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "/views/dashboard.jsp";
        } else {
            User u = userService.findById(id);
            Pool newPool = poolService.createPool(pool, u);
            return "redirect:/host";
        }
    }

    @RequestMapping("/search")
    public String search(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            User currentUser = userService.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
        }
        else {
            User currentUser = null;
            model.addAttribute("currentUser", currentUser);
        }
        return "/views/search.jsp";
    }

    @RequestMapping(value = "/search/{search}", method = RequestMethod.GET)
    public String searchResults(Principal principal, @PathVariable(value = "search") String search, Model model) {
        if (principal != null) {
            String username = principal.getName();
            User currentUser = userService.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
        }
        else {
            User currentUser = null;
            model.addAttribute("currentUser", currentUser);
        }
        List<Pool> searchResult = poolService.findPoolsBySearch(search);
        model.addAttribute("searchResult", searchResult);
        return "/views/searchResult.jsp";
    }

    @RequestMapping(value = "/show/{pId}", method = RequestMethod.GET)
    public String showPool(Principal principal, @PathVariable(value = "pId") Long pId, Model model) {
        if (principal != null) {
            String username = principal.getName();
            User currentUser = userService.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
        }
        else {
            User currentUser = null;
            model.addAttribute("currentUser", currentUser);
        }
        Pool pool = poolService.findById(pId);
        model.addAttribute("pool", pool);
        List<Review> reviews = reviewService.findAllByPoolId(pId);
        model.addAttribute("reviews", reviews);
        return "/views/showPool.jsp";
    }

    @RequestMapping(value = "/edit/{pId}", method = RequestMethod.GET)
    public String editPool(Model model, Principal principal, @ModelAttribute(value = "pool") Pool pool, @PathVariable(value = "pId") Long pId) {
        if (principal != null) {
            String username = principal.getName();
            User currentUser = userService.findByUsername(username);
            model.addAttribute("currentUser", currentUser);
        }
        else {
            User currentUser = null;
            model.addAttribute("currentUser", currentUser);
        }
        Pool p = poolService.findById(pId);
        model.addAttribute("p", p);
        List<Review> reviews = reviewService.findAllByPoolId(pId);
        model.addAttribute("reviews", reviews);
        List<String> size = Arrays.asList("Small", "Medium", "Large");
        model.addAttribute("size", size);
        List<Double> cost = Arrays.asList(100.0, 200.0, 300.0);
        model.addAttribute("cost", cost);
        return "/views/editPool.jsp";
    }

    @RequestMapping(value = "/edit/{pId}", method = RequestMethod.POST)
    public String processEdit(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, @PathVariable(value = "pId") Long pId) {
        if (result.hasErrors()) {
            return "redirect:/edit" + pId;
        } else {
            Pool updatedPool = poolService.updatePool(pId, pool);
            return "redirect:/host";
        }
    }
}
