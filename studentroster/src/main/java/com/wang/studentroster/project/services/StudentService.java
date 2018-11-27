package com.wang.studentroster.project.services;

import com.wang.studentroster.project.models.Dormitory;
import com.wang.studentroster.project.models.Student;
import com.wang.studentroster.project.repositories.DormitoryRepository;
import com.wang.studentroster.project.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;


    public StudentService (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student s) {
        String first = s.getFirstName();
        String last = s.getLastName();
        s.setFullName(first,last);
        return studentRepository.save(s);
    }

    public Student addDorm(Student s, Dormitory dorm) {
        Student studentToUpdate = findStudent(s.getId());
        studentToUpdate.setDormitory(dorm);
        return studentRepository.save(studentToUpdate);
    }

    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    public List<Student> findByDorm(Dormitory dorm) {
        return studentRepository.findAllByDormitoryOrderByCreatedAt(dorm);
    }

}
