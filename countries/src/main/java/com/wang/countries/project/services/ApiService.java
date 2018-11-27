package com.wang.countries.project.services;

import com.wang.countries.project.models.Language;
import com.wang.countries.project.repositories.CitiesRepository;
import com.wang.countries.project.repositories.CountriesRepository;
import com.wang.countries.project.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
    @Autowired
    private final CitiesRepository citiesRepository;
    private final CountriesRepository countriesRepository;
    private final LanguagesRepository languagesRepository;


    public ApiService(CitiesRepository citiesRepository, CountriesRepository countriesRepository, LanguagesRepository languagesRepository) {
        this.citiesRepository = citiesRepository;
        this.countriesRepository = countriesRepository;
        this.languagesRepository = languagesRepository;
    }

    public List<Object[]> findCountriesSpeakingSlovene() {
        return countriesRepository.findCountryByLanguageSlovene();
    }
}
