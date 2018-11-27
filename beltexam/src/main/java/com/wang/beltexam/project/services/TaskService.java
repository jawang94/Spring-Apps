package com.wang.beltexam.project.services;

import com.wang.beltexam.project.models.Task;
import com.wang.beltexam.project.models.User;
import com.wang.beltexam.project.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task, User user) {
        task.setCreator(user);
        return taskRepository.save(task);
    }

    public Task findById(Long id) {
        Optional<Task> optionalPool = taskRepository.findById(id);
        if(optionalPool.isPresent()) {
            return optionalPool.get();
        } else {
            return null;
        }    }

    public Task editTask(Task t, Long id) {
        Task taskToBeUpdated= findById(id);
        taskToBeUpdated.setDescription(t.getDescription());
        taskToBeUpdated.setAssignee(t.getAssignee());
        taskToBeUpdated.setPriority(t.getPriority());
        return taskRepository.save(taskToBeUpdated);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        Task t = findById(id);
        taskRepository.delete(t);
    }

    public List<Task> findByDescPriority() {
        return taskRepository.findAllByPriorityDescending();
    }

    public List<Task> findByAscPriority() {
        return taskRepository.findAllByPriorityAscending();
    }

}