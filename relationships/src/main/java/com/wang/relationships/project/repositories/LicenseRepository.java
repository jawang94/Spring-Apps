package com.wang.relationships.project.repositories;

import com.wang.relationships.project.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    public List<License> findAll();
}

