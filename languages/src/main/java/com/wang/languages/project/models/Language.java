package com.wang.languages.project.models;

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
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() { return this.id ; }
    @Size(min = 2, max = 20)
    private String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    @Size(min = 2, max = 20)
    private String creator;
    public String getCreator() { return this.creator; }
    public void setCreator(String creator) { this.creator = creator; }
    @Min(1)
    private Double currentVersion;
    public Double getCurrentVersion() { return this.currentVersion; }
    public void setCurrentVersion(Double currentVersion) { this.currentVersion = currentVersion; }
    public Language() {
    }

    public Language(String name, String creator, double currentVersion) {
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }

}