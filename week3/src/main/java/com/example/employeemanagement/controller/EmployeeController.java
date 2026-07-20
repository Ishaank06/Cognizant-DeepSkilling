package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * GET /employees
     * Retrieve all employees.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * GET /employees/permanent
     * Retrieve all permanent employees (optimized fetch).
     */
    @GetMapping("/permanent")
    public ResponseEntity<List<EmployeeDTO>> getAllPermanentEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllPermanentEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * GET /employees/native
     * Retrieve all employees using raw SQL native query.
     */
    @GetMapping("/native")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesNative() {
        List<EmployeeDTO> employees = employeeService.getAllEmployeesNative();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * GET /employees/average/{departmentId}
     * Retrieve the average salary of employees in a specific department.
     */
    @GetMapping("/average/{departmentId}")
    public ResponseEntity<Double> getAverageSalary(@PathVariable int departmentId) {
        double averageSalary = employeeService.getAverageSalary(departmentId);
        return new ResponseEntity<>(averageSalary, HttpStatus.OK);
    }

    /**
     * GET /employees/search
     * Dynamic dynamic search using JPA Criteria API.
     */
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDTO>> searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            @RequestParam(required = false) Integer departmentId,
            @RequestParam(required = false) Boolean permanent) {

        List<EmployeeDTO> employees = employeeService.searchEmployeesUsingCriteria(
                name, minSalary, maxSalary, departmentId, permanent
        );
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
