package com.wang.mvc.demo.models;

import java.util.Date;
import java.util.HashMap;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 200)
    private String title;
    @Size(min = 5, max = 200)
    private String description;
    @Size(min = 3, max = 40)
    private String language;
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    public Book() {
    }

    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    public void update(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    public HashMap<String, String> showBook() {
        HashMap<String, String> bookMap = new HashMap<String, String>();
        bookMap.put("title", this.title);
        bookMap.put("description", this.description);
        bookMap.put("language", this.language);
        bookMap.put("pages", this.numberOfPages.toString());
        return bookMap;
    }

    public String returnTitle() {
        return this.title;
    }
    public String returnDesc() {
        return this.description;
    }
    public String returnLang() {
        return this.language;
    }
    public Integer returnPages() {
        return this.numberOfPages;
    }


    public Long returnId() {
        return this.id;
    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}