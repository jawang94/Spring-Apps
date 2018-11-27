package com.wang.employeesandmanagers.project.repositories;

import com.wang.employeesandmanagers.project.models.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    public List<Manager> findAll();
}
