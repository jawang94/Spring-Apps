package com.wang.lookify.project.repositories;

import com.wang.lookify.project.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {
    public List<Song> findAll();
    public List<Song> findSongsByArtist(String artist);
    public List<Song> findTop10ByOrderByRatingDesc();
//    public Long countByTitleContaining(String search);
//    public Long deleteByTitleStartingWith(String search);
}
