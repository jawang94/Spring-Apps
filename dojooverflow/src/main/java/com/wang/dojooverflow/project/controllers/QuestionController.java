package com.wang.dojooverflow.project.controllers;

import com.wang.dojooverflow.project.models.Answer;
import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import com.wang.dojooverflow.project.services.AnswerService;
import com.wang.dojooverflow.project.services.QuestionService;
import com.wang.dojooverflow.project.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @RequestMapping("/questions")
    public String index(Model model) {
        List<Question> questions= questionService.findAll();
        model.addAttribute("questions", questions);
        return "/views/dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(Model model, @ModelAttribute("question") Question question) {
        return "/views/newQuestion.jsp";
    }

    @RequestMapping(value = "/questions/new", method = RequestMethod.POST)
    public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, @RequestParam("myTags") String myTags) {
        if (result.hasErrors()) {
            return "redirect:/questions/new";
        } else {
            List<String> stringTags = Arrays.asList(myTags.split(","));
            List<Tag> setTags = tagService.createTag(stringTags);
            question.setTags(setTags);
            Question newQ = questionService.createQuestion(question);
            return "redirect:/questions";
        }
    }

    @RequestMapping(value = "/questions/{id}")
    public String showQuestion(Model model, @ModelAttribute("answer") Answer answer, @PathVariable(value="id") Long id) {
        Question q = questionService.findQuestion(id);
        List<Answer> thisAnswers = answerService.findByQuestion(q);
        model.addAttribute("q", q);
        model.addAttribute("thisAnswers", thisAnswers);
        return "/views/showQuestion.jsp";
    }

}

