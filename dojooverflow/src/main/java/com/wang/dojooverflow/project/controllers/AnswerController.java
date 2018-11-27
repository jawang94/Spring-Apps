package com.wang.dojooverflow.project.controllers;

import com.wang.dojooverflow.project.models.Answer;
import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.services.AnswerService;
import com.wang.dojooverflow.project.services.QuestionService;
import com.wang.dojooverflow.project.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AnswerController {
    @Autowired
    private final AnswerService answerService;
    private final TagService tagService;
    private final QuestionService questionService;

    public AnswerController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @RequestMapping(value="/questions/{id}/add", method= RequestMethod.POST)
    public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/questions/" + id;
        } else {
            Answer a = answerService.createAnswer(answer);
            Question q = questionService.findQuestion(id);
            answerService.addQuestion(a, q);
            return "redirect:/questions/" + id;
        }
    }
}
