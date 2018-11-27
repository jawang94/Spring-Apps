package com.wang.countries.project.repositories;


import com.wang.countries.project.models.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends CrudRepository<City, Long> {
    public List<City> findAll();

    @Query(value = "SELECT countries.name,count(cities.id) as cities FROM countries JOIN cities ON cities.country_id = countries.id GROUP BY countries.name ORDER BY cities desc", nativeQuery = true)
    List<Object[]> findTotalCities();

    @Query(value = "SELECT cities.name, cities.population FROM countries JOIN cities ON cities.country_id = countries.id WHERE countries.name = 'Mexico'  AND cities.population > 500000 ORDER BY cities.population desc", nativeQuery = true)
    List<Object[]> find500PlusCitiesInMexico();

    @Query(value = "SELECT countries.name, cities.name, cities.district,cities.population FROM cities JOIN countries ON cities.country_id = countries.id  WHERE cities.district = 'Buenos Aires' AND  cities.population > 500000", nativeQuery = true)
    List<Object[]> findArgentinaCitiesBuenosAiresPopulation50000Plus();


}
