package com.wang.dojosandninjas.project.services;

import com.wang.dojosandninjas.project.models.Dojo;
import com.wang.dojosandninjas.project.models.Ninja;
import com.wang.dojosandninjas.project.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    @Autowired
    private final NinjaRepository ninjaRepository;

    public NinjaService (NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> findAll() {
        List<Ninja> ninjaList = ninjaRepository.findAll();
        return ninjaList;
    }

    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }

    public List<Ninja> findByDojo(Dojo dojo) {
        return ninjaRepository.findAllByDojoOrderByCreatedAt(dojo);
    }

}
