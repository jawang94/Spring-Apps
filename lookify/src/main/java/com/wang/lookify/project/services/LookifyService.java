package com.wang.lookify.project.services;

import com.wang.lookify.project.models.Song;
import com.wang.lookify.project.repositories.LookifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LookifyService {
    @Autowired
    private final LookifyRepository lookifyRepository;

    public LookifyService (LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }

    public List<Song> findAll() {
        List<Song> Song = lookifyRepository.findAll();
        return Song;
    }

    public Song createSong(Song l) {
        return lookifyRepository.save(l);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = lookifyRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public List<Song> searchByArtist(String artist) {
        return lookifyRepository.findSongsByArtist(artist);
    }

    public List<Song> findTopTen() {
        return lookifyRepository.findTop10ByOrderByRatingDesc();
    }

    public void deleteSong(Long id) {
        lookifyRepository.deleteById(id);
    }
}