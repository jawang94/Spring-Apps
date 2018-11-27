package com.wang.employeesandmanagers.project.services;

import com.wang.employeesandmanagers.project.models.Employee;
import com.wang.employeesandmanagers.project.models.Manager;
import com.wang.employeesandmanagers.project.repositories.EmployeeRepository;
import com.wang.employeesandmanagers.project.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class APIService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;


    public APIService(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
    }

    public Manager findManager(Long id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if(optionalManager.isPresent()) {
            return optionalManager.get();
        } else {
            return null;
        }
    }

    public List<Employee> findEmployees(Long id) {
        Manager manager = findManager(id);
        return manager.getEmployees();
    }

    public Manager findManager(Employee employee) {
        return employee.getManager();
    }
}
