package com.wang.waterbnb.project.services;

import com.wang.waterbnb.project.models.Pool;
import com.wang.waterbnb.project.models.Review;
import com.wang.waterbnb.project.models.User;
import com.wang.waterbnb.project.repositories.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoolService {
    private final PoolRepository poolRepository;

    PoolService (PoolRepository poolRepository) {
        this.poolRepository = poolRepository;
    }

    public Pool createPool(Pool pool, User user) {
        pool.setHost(user);
        return poolRepository.save(pool);
    }

    public Pool findById(Long id) {
        Optional<Pool> optionalPool = poolRepository.findById(id);
        if(optionalPool.isPresent()) {
            return optionalPool.get();
        } else {
            return null;
        }    }

    public Pool editPool(Pool p, Long id) {
        Pool poolToBeUpdated = findById(id);
        poolToBeUpdated.setSize(p.getSize());
        poolToBeUpdated.setCost(p.getCost());
        poolToBeUpdated.setDescription(p.getDescription());
        return poolRepository.save(poolToBeUpdated);
    }

    public List<Pool> findAllPools() {
        return poolRepository.findAll();
    }

    public List<Pool> findPoolsBySearch(String search) {
        return poolRepository.findAllByAddressContains(search);
    }

    public Pool updateRating(Long pId, Review r) {
        Pool p = findById(pId);
        if (p.getRating() == null) {
            p.setRating(Double.valueOf(r.getRating()));
        }
        else {
            Double newRating = (p.getRating() + r.getRating()) / 2;
            p.setRating(newRating);
        }
        poolRepository.save(p);
        return p;
    }

    public Pool updatePool(Long pId, Pool p) {
        Pool poolToBeUpdated = findById(pId);
        poolToBeUpdated.setDescription(p.getDescription());
        poolToBeUpdated.setSize(p.getSize());
        poolToBeUpdated.setCost(p.getCost());
        poolRepository.save(poolToBeUpdated);
        return poolToBeUpdated;
    }
}
