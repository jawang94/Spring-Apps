package com.wang.countries.project.repositories;

import com.wang.countries.project.models.Country;
import com.wang.countries.project.models.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends CrudRepository<Country, Long> {
    public List<Country> findAll();

    @Query(value = "SELECT name,language,percentage FROM languages JOIN countries ON languages.country_id = countries.id WHERE language = 'Slovene' ORDER BY percentage desc", nativeQuery = true)
    List<Object[]> findCountryByLanguageSlovene();

    @Query(value = "SELECT countries.name FROM countries WHERE surface_area < 501 AND  population > 100000", nativeQuery = true)
    List<Object[]> findCountriesBySurfaceAreaAndPopulation();

    @Query(value = "SELECT countries.name FROM countries WHERE government_form = 'Constitutional Monarchy' AND surface_area > 200 AND life_expectancy > 75.0", nativeQuery = true)
    List<Object[]> findConstitutionalMonarchySurfaceArea200PlusLifeExpectancy75Plus();

    @Query(value = "SELECT region,count(countries.name) as countries FROM countries GROUP BY region ORDER BY countries desc", nativeQuery = true)
    List<Object[]> findCountriesPerRegion();
}

