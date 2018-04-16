package com.atos.selecaoarthur.services;

import com.atos.selecaoarthur.model.Employee;
import com.atos.selecaoarthur.repositories.EmployeeRepository;
import com.atos.selecaoarthur.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public EmployeesService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void updateEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}
