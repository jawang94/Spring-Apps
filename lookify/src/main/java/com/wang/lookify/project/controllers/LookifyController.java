package com.wang.lookify.project.controllers;

import com.wang.lookify.project.models.Song;
import com.wang.lookify.project.services.LookifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LookifyController {
    @Autowired
    private final LookifyService lookifyService;

    public LookifyController (LookifyService lookifyService) {
        this.lookifyService = lookifyService;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "/views/welcome.jsp";
    }

    @RequestMapping("/dashboard")
    public String index(Model model, @ModelAttribute("language") Song song) {
        List<Song> songs = lookifyService.findAll();
        model.addAttribute("songs", songs);
        return "/views/index.jsp";
    }

    @RequestMapping("/dashboard/new")
    public String newSong(Model model, @ModelAttribute("song") Song song) {
        Map<String,Integer> rating = new LinkedHashMap<String,Integer>();
        rating.put("1", 1);
        rating.put("2", 2);
        rating.put("3", 3);
        rating.put("4", 4);
        rating.put("5", 5);
        rating.put("6", 6);
        rating.put("7", 7);
        rating.put("8", 8);
        rating.put("9", 9);
        rating.put("10", 10);
        model.addAttribute("rating", rating);
        return "/views/new.jsp";
    }

    @RequestMapping("/dashboard/topTen")
    public String topTen(Model model) {
        List<Song> topTenList = lookifyService.findTopTen();
        model.addAttribute("topTen", topTenList);
        return "/views/topTen.jsp";
    }

    @RequestMapping(value="/dashboard", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/dashboard/new";
        } else {
            lookifyService.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "id") Long id) {
        Song song = lookifyService.findSong(id);
        model.addAttribute("song", song);
        return "/views/show.jsp";
    }

    @RequestMapping(value = "/search/{artist}", method = RequestMethod.GET)
    public String search(Model model, @PathVariable(value = "artist") String artist) {
        List<Song> songs = lookifyService.searchByArtist(artist);
        model.addAttribute("songs", songs);
        model.addAttribute("artist", artist);
        return "/views/search.jsp";
    }

    @RequestMapping(value="/dashboard/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookifyService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
