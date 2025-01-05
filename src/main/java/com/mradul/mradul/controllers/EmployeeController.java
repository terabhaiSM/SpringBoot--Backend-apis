package com.mradul.mradul.controllers;

import com.mradul.mradul.dto.EmployeeDTO;
import com.mradul.mradul.services.EmployeeService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.bind.annotation.GetMapping;


// goal is to build apis to register an employee, get an employee by id,
// get all employees and delete an employee along with updating it with id.
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    final EmployeeService employeeService;
    private final View error;

    public EmployeeController(EmployeeService employeeService, View error) {
        this.employeeService = employeeService;
        this.error = error;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {

    }
    

    @PostMapping(produces = "application/json", consumes = "application/json")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            return employeeService.createEmployee(employeeDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating employee: " + error, e);
        }
    }
}
