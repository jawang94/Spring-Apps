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
public class ReviewController {
    private final ReviewService reviewService;
    private final PoolService poolService;
    private final UserService userService;

    ReviewController (ReviewService reviewService, PoolService poolService, UserService userService) {
        this.reviewService = reviewService;
        this.poolService = poolService;
        this.userService = userService;
    }

    @RequestMapping(value = "/review/{pId}", method = RequestMethod.GET)
    public String leaveReview(Principal principal,@ModelAttribute(value = "review") Review review, @PathVariable(value = "pId") Long pId, Model model) {
        String username = principal.getName();
        if (username == null) {
            return "redirect:/registration";
        }
        User currentUser = userService.findByUsername(username);
        model.addAttribute("currentUser", currentUser);
        Pool pool = poolService.findById(pId);
        model.addAttribute("pool", pool);
        List<Integer> rating = Arrays.asList(1, 2,3,4,5);
        model.addAttribute("rating", rating);
        return "/views/leaveReview.jsp";
    }

    @RequestMapping(value = "/post/{pId}/{uId}", method = RequestMethod.POST)
    public String postReview(@Valid @ModelAttribute("review") Review review, BindingResult result, @PathVariable(value = "pId") Long pId, @PathVariable(value = "uId") Long uId) {
        Review newReview = reviewService.postReview(review, pId, uId);
        Pool updatedPool = poolService.updateRating(pId, newReview);
        return "redirect:/show/" + pId;
    }
}
