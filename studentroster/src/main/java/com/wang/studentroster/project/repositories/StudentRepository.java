package com.wang.studentroster.project.repositories;

import com.wang.studentroster.project.models.Dormitory;
import com.wang.studentroster.project.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    public List<Student> findAll();
    public List<Student> findAllByDormitoryOrderByCreatedAt(Dormitory dorm);
}

