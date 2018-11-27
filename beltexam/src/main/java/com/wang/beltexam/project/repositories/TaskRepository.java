package com.wang.beltexam.project.repositories;

import com.wang.beltexam.project.models.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();

    @Query(value = "SELECT * FROM tasks ORDER BY priority='High' desc, priority='Medium' desc, priority='Low' desc", nativeQuery = true)
    List<Task> findAllByPriorityDescending();

    @Query(value = "SELECT * FROM tasks ORDER BY priority='Low' desc, priority='Medium' desc, priority='High' desc", nativeQuery = true)
    List<Task> findAllByPriorityAscending();
}
