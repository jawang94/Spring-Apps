package com.wang.lookify.project.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return this.id ; }
    @Size(min = 5)
    private String title;
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    @Size(min = 5)
    private String artist;
    public String getArtist() { return this.artist; }
    public void setArtist(String artist) { this.artist = artist; }
    @Min(1)
    @Max(10)
    private Integer rating;
    public Integer getRating() { return this.rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public Song() {
    }

    public Song(String title, String artist, int rating) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }

}