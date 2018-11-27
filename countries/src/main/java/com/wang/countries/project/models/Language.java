package com.wang.countries.project.models;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public String country_code;
    public String getCountry_code() {
        return country_code;
    }
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
    public String language;
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Enum is_official;
    public Enum getIs_official() {
        return is_official;
    }
    public void setIs_official(Enum is_official) {
        this.is_official = is_official;
    }
    public Double percentage;
    public Double getPercentage() {
        return percentage;
    }
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }


}