package com.wang.dojosandninjas.project.repositories;

import com.wang.dojosandninjas.project.models.Dojo;
import com.wang.dojosandninjas.project.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    public List<Ninja> findAll();
    public List<Ninja> findAllByDojoOrderByCreatedAt(Dojo dojo);
}
