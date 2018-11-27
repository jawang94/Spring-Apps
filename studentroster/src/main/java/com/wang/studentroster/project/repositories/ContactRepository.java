package com.wang.studentroster.project.repositories;

import com.wang.studentroster.project.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    public List<Contact> findAll();
}

