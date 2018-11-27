package com.wang.relationships.project.repositories;

import com.wang.relationships.project.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    public List<Person> findAll();
    public Person findByFirstNameAndLastName(String first, String last);
}

