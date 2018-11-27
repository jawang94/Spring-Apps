package com.wang.studentroster.project.repositories;

import com.wang.studentroster.project.models.Dormitory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Long> {
    public List<Dormitory> findAll();
}

