package com.wang.studentroster.project.services;


import com.wang.studentroster.project.models.Contact;
import com.wang.studentroster.project.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactService (ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact c) {
        return contactRepository.save(c);
    }

    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }

}
