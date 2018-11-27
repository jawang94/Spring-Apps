package com.wang.dojosandninjas.project.services;

import com.wang.dojosandninjas.project.models.Dojo;
import com.wang.dojosandninjas.project.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    @Autowired
    private final DojoRepository dojoRepository;

    public DojoService (DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> findAll() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

}
