package com.wang.waterbnb.project.services;

import com.wang.waterbnb.project.models.Pool;
import com.wang.waterbnb.project.models.Review;
import com.wang.waterbnb.project.models.User;
import com.wang.waterbnb.project.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final PoolService poolService;
    private final UserService userService;

    ReviewService (ReviewRepository reviewRepository, PoolService poolService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.poolService = poolService;
        this.userService = userService;
    }

    public List<Review> findAllByPoolId(Long id) {
        return reviewRepository.findAllByPoolId(id);
    }

    public Review postReview(Review r, Long pId, Long uId) {
        Pool p = poolService.findById(pId);
        User u = userService.findById(uId);
        r.setPool(p);
        r.setUser(u);
        return reviewRepository.save(r);
    }
}
