package com.atos.selecaoarthur.controllers;

import com.atos.selecaoarthur.model.Employee;
import com.atos.selecaoarthur.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeesController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return employeesService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void updateEmployees(@RequestBody @Valid List<Employee> employees) {

        employeesService.updateEmployees(employees);
    }
}
