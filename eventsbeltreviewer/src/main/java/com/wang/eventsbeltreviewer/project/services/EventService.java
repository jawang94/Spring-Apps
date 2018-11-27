package com.wang.eventsbeltreviewer.project.services;

import com.wang.eventsbeltreviewer.project.models.Event;
import com.wang.eventsbeltreviewer.project.models.User;
import com.wang.eventsbeltreviewer.project.repositories.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    EventService (EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event findById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }

    public Event addHost(Event e, User u) {
        e.setHostName(u.getFirstName() + " " + u.getLastName());
        e.setHostId(u.getId());
        eventRepository.save(e);
        return e;
    }

    public List<Event> findInStateEvents(String state) {
        return eventRepository.findAllByStateOrderByCreatedAtDesc(state);
    }

    public List<Event> findOutOfStateEvents(String state) {
        return eventRepository.findAllByStateIsNotContainingOrderByCreatedAtDesc(state);
    }

    public List<User> addAttendee(Event e, User u) {
        List<User> list = e.getUsers();
        list.add(u);
        e.setUsers(list);
        eventRepository.save(e);
        return e.getUsers();
    }

    public void cancelEvent(Long id) {
        Event e = findById(id);
        eventRepository.delete(e);
    }

    public Event editEvent(Event e, Long id) {
        Event eventToBeUpdated = findById(id);
        eventToBeUpdated.setName(e.getName());
        eventToBeUpdated.setLocation(e.getLocation());
        eventToBeUpdated.setState(e.getState());
        return eventRepository.save(eventToBeUpdated);
    }
}
