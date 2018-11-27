package com.wang.waterbnb.project.repositories;

import com.wang.waterbnb.project.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();
    List<Review> findAllByPoolId(Long id);
}
