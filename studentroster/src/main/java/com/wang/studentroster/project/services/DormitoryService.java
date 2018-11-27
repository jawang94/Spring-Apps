package com.wang.studentroster.project.services;

import com.wang.studentroster.project.models.Dormitory;
import com.wang.studentroster.project.models.Student;
import com.wang.studentroster.project.repositories.DormitoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class DormitoryService {

    @Autowired
    private final DormitoryRepository dormitoryRepository;

    public DormitoryService (DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Dormitory> findAll() {
        return dormitoryRepository.findAll();
    }

    public Dormitory createDorm(Dormitory d) {
        return dormitoryRepository.save(d);
    }

    public Dormitory findDorm(Long id) {
        Optional<Dormitory> optionalDormitory = dormitoryRepository.findById(id);
        if(optionalDormitory.isPresent()) {
            return optionalDormitory.get();
        } else {
            return null;
        }
    }

}
