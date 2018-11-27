package com.wang.eventsbeltreviewer.project.controllers;

import com.wang.eventsbeltreviewer.project.models.Message;
import com.wang.eventsbeltreviewer.project.services.EventService;
import com.wang.eventsbeltreviewer.project.services.MessageService;
import com.wang.eventsbeltreviewer.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MessageController {
    @Autowired
    private final EventService eventService;
    private final UserService userService;
    private final MessageService messageService;

    public MessageController(EventService eventService, UserService userService, MessageService messageService) {
        this.eventService = eventService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/post/{eId}/{uId}", method = RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable(value = "eId") Long eId, @PathVariable(value = "uId") Long uId) {
        Message newMessage = messageService.createMessage(message, eId, uId);
        return "redirect:/event/" + eId + "/" + uId;
    }
}
