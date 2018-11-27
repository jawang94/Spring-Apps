package com.wang.relationships.project.services;

import com.wang.relationships.project.models.Person;
import com.wang.relationships.project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public Person createPerson(Person p) {
        String first = p.getFirstName();
        String last = p.getLastName();
        p.setFullName(first,last);
        return personRepository.save(p);
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public Person findByName(String first, String last) {
        return personRepository.findByFirstNameAndLastName(first,last);
    }

}
