package com.wang.eventsbeltreviewer.project.services;

import com.wang.eventsbeltreviewer.project.models.Event;
import com.wang.eventsbeltreviewer.project.models.Message;
import com.wang.eventsbeltreviewer.project.models.User;
import com.wang.eventsbeltreviewer.project.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final EventService eventService;
    private final UserService userService;

    MessageService(MessageRepository messageRepository, EventService eventService, UserService userService) {
        this.messageRepository = messageRepository;
        this.eventService = eventService;
        this.userService = userService;
    }

    public Message createMessage(Message m, Long eId, Long uId) {
        Event e = eventService.findById(eId);
        User u = userService.findUserById(uId);
        m.setEvent(e);
        m.setUser(u);
        return messageRepository.save(m);
    }

    public List<Message> findMessagesByEventId(Long id) {
        return messageRepository.findAllByEventId(id);
    }
}
