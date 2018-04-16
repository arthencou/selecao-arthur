package com.atos.selecaoarthur.controllers;

import com.atos.selecaoarthur.model.Employee;
import com.atos.selecaoarthur.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Employee> getEmployees(@RequestParam(required = false) List<String> skills) {


        if (skills == null) {
            return employeesService.getAllEmployees();
        } else
            return employeesService.getEmployeesFiltering(skills);
    }

    @PostMapping("/employees")
    public void updateEmployees(@RequestBody @Valid List<Employee> employees) {

        employeesService.updateEmployees(employees);
    }
}
