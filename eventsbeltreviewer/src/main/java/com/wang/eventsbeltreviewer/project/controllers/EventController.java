package com.wang.eventsbeltreviewer.project.controllers;

import com.wang.eventsbeltreviewer.project.models.Event;
import com.wang.eventsbeltreviewer.project.models.Message;
import com.wang.eventsbeltreviewer.project.models.User;
import com.wang.eventsbeltreviewer.project.services.EventService;
import com.wang.eventsbeltreviewer.project.services.MessageService;
import com.wang.eventsbeltreviewer.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {
    @Autowired
    private final EventService eventService;
    private final UserService userService;
    private final MessageService messageService;

    public EventController(EventService eventService, UserService userService, MessageService messageService) {
        this.eventService = eventService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/dashboard";
        } else {
            Event newEvent = eventService.createEvent(event);
            User u = userService.findUserById(id);
            eventService.addHost(newEvent, u);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping(value = "/cancel/{id}")
    public String cancelEvent(@PathVariable(value = "id") Long id) {
        eventService.cancelEvent(id);
        return "redirect:/dashboard";
    }


    @RequestMapping(value = "/event/{eId}/{uId}")
    public String showEvent(Model model, @PathVariable(value = "eId") Long eId, @PathVariable(value = "uId") Long uId, HttpSession session, @ModelAttribute("message") Message message){
        Event event = eventService.findById(eId);
        model.addAttribute(event);
        Integer numberOfAttendees = userService.findNumberOfAttendees(eId);
        model.addAttribute("numberOfAttendees", numberOfAttendees);
        User user = userService.findUserById(uId);
        model.addAttribute("user", user);
        List<Message> messages = messageService.findMessagesByEventId(eId);
        model.addAttribute("messages", messages);
        return "/views/showEvent.jsp";
    }

    @RequestMapping(value = "/join/{eId}/{uId}")
    public String joinEvent(@PathVariable(value = "eId") Long eId, @PathVariable(value = "uId") Long uId) {
        User u = userService.findUserById(uId);
        Event e = eventService.findById(eId);
        List<User> attendeeList = eventService.addAttendee(e,u);
        return "redirect:/dashboard";
    }

    @RequestMapping("/edit/{eId}")
    public String editEvent(Model model, @PathVariable(value = "eId") Long eId, @ModelAttribute("event") Event event) {
        Event e = eventService.findById(eId);
        model.addAttribute("e", e);
        Map<String, String> states = new HashMap<String, String>();
        states.put("Alabama","AL");
        states.put("Alaska","AK");
        states.put("Alberta","AB");
        states.put("American Samoa","AS");
        states.put("Arizona","AZ");
        states.put("Arkansas","AR");
        states.put("Armed Forces (AE)","AE");
        states.put("Armed Forces Americas","AA");
        states.put("Armed Forces Pacific","AP");
        states.put("British Columbia","BC");
        states.put("California","CA");
        states.put("Colorado","CO");
        states.put("Connecticut","CT");
        states.put("Delaware","DE");
        states.put("District Of Columbia","DC");
        states.put("Florida","FL");
        states.put("Georgia","GA");
        states.put("Guam","GU");
        states.put("Hawaii","HI");
        states.put("Idaho","ID");
        states.put("Illinois","IL");
        states.put("Indiana","IN");
        states.put("Iowa","IA");
        states.put("Kansas","KS");
        states.put("Kentucky","KY");
        states.put("Louisiana","LA");
        states.put("Maine","ME");
        states.put("Manitoba","MB");
        states.put("Maryland","MD");
        states.put("Massachusetts","MA");
        states.put("Michigan","MI");
        states.put("Minnesota","MN");
        states.put("Mississippi","MS");
        states.put("Missouri","MO");
        states.put("Montana","MT");
        states.put("Nebraska","NE");
        states.put("Nevada","NV");
        states.put("New Brunswick","NB");
        states.put("New Hampshire","NH");
        states.put("New Jersey","NJ");
        states.put("New Mexico","NM");
        states.put("New York","NY");
        states.put("Newfoundland","NF");
        states.put("North Carolina","NC");
        states.put("North Dakota","ND");
        states.put("Northwest Territories","NT");
        states.put("Nova Scotia","NS");
        states.put("Nunavut","NU");
        states.put("Ohio","OH");
        states.put("Oklahoma","OK");
        states.put("Ontario","ON");
        states.put("Oregon","OR");
        states.put("Pennsylvania","PA");
        states.put("Prince Edward Island","PE");
        states.put("Puerto Rico","PR");
        states.put("Quebec","QC");
        states.put("Rhode Island","RI");
        states.put("Saskatchewan","SK");
        states.put("South Carolina","SC");
        states.put("South Dakota","SD");
        states.put("Tennessee","TN");
        states.put("Texas","TX");
        states.put("Utah","UT");
        states.put("Vermont","VT");
        states.put("Virgin Islands","VI");
        states.put("Virginia","VA");
        states.put("Washington","WA");
        states.put("West Virginia","WV");
        states.put("Wisconsin","WI");
        states.put("Wyoming","WY");
        states.put("Yukon Territory","YT");
        model.addAttribute("states", states);
        return "/views/editEvent.jsp";
    }

    @RequestMapping(value = "/edit/{eId}", method = RequestMethod.POST)
    public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, @PathVariable(value = "eId") Long eId) {
        if (result.hasErrors()) {
            return "redirect:/dashboard";
        } else {
            Event updated = eventService.editEvent(event, eId);
            return "redirect:/dashboard";
        }
    }
}
