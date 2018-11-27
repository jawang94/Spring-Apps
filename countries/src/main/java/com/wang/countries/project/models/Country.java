package com.wang.countries.project.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    private String code;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String region;
    public String getRegion() { return region; }
    public void setRegion(String region) {
        this.region = region;
    }
    private Double surface_area;
    public Double getSurface_area() {
        return surface_area;
    }
    public void setSurface_area(Double surface_area) {
        this.surface_area = surface_area;
    }
    private Short indep_year;
    public Short getIndep_year() {
        return indep_year;
    }
    public void setIndep_year(Short indep_year) {
        this.indep_year = indep_year;
    }
    private Integer population;
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }
    private Double life_expectancy;
    public Double getLife_expectancy() {
        return life_expectancy;
    }
    public void setLife_expectancy(Double life_expectancy) {
        this.life_expectancy = life_expectancy;
    }
    private Double gnp;
    public Double getGnp() {
        return gnp;
    }
    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }
    private Double gnp_old;
    public Double getGnp_old() {
        return gnp_old;
    }
    public void setGnp_old(Double gnp_old) {
        this.gnp_old = gnp_old;
    }
    private String local_name;
    public String getLocal_name() {
        return local_name;
    }
    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }
    private String government_form;
    public String getGovernment_form() {
        return government_form;
    }
    public void setGovernment_form(String government_form) {
        this.government_form = government_form;
    }
    private String head_of_state;
    public String getHead_of_state() {
        return head_of_state;
    }
    public void setHead_of_state(String head_of_state) {
        this.head_of_state = head_of_state;
    }
    private Integer capital;
    public Integer getCapital() {
        return capital;
    }
    public void setCapital(Integer capital) {
        this.capital = capital;
    }
    private String code2;
    public String getCode2() {
        return code2;
    }
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> city;
    public List<City> getCity() {
        return city;
    }
    public void setCity(List<City> city) {
        this.city = city;
    }

    @OneToMany(mappedBy="language", fetch = FetchType.LAZY)
    private List<Language> language;
    public List<Language> getLanguage() {
        return language;
    }
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public Country() {

    }

}