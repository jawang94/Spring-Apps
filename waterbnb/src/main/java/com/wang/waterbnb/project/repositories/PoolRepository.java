package com.wang.waterbnb.project.repositories;

import com.wang.waterbnb.project.models.Pool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoolRepository extends CrudRepository<Pool, Long> {
    List<Pool> findAll();

    List<Pool> findAllByAddressContains(String location);

}
