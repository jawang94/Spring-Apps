package com.wang.countries.project.repositories;

import com.wang.countries.project.models.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguagesRepository extends CrudRepository<Language, Long> {
    public List<Language> findAll();

    @Query(value = "SELECT countries.name as country, languages.language, languages.percentage FROM countries JOIN languages ON languages.country_id = countries.id WHERE languages.percentage > 89.0 ORDER BY languages.percentage desc", nativeQuery = true)
    List<Object[]> find89PercentageLanguages();


}

