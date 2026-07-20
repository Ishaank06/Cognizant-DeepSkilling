package com.example.employeemanagement.config;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.Skill;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.count() == 0) {
            // Create departments
            Department it = new Department();
            it.setName("Information Technology");
            
            Department hr = new Department();
            hr.setName("Human Resources");
            
            Department sales = new Department();
            sales.setName("Sales");
            
            departmentRepository.saveAll(Arrays.asList(it, hr, sales));

            // Create skills
            Skill java = new Skill();
            java.setName("Java");
            
            Skill spring = new Skill();
            spring.setName("Spring Boot");
            
            Skill sql = new Skill();
            sql.setName("SQL");
            
            Skill communication = new Skill();
            communication.setName("Communication");
            
            skillRepository.saveAll(Arrays.asList(java, spring, sql, communication));

            // Create employees
            Employee emp1 = new Employee(
                    null, 
                    "Alice Cooper", 
                    85000.0, 
                    true, 
                    LocalDate.of(1990, 5, 12), 
                    it, 
                    Arrays.asList(java, spring, sql)
            );
            Employee emp2 = new Employee(
                    null, 
                    "Bob Marley", 
                    75000.0, 
                    true, 
                    LocalDate.of(1985, 8, 20), 
                    it, 
                    Arrays.asList(java, sql)
            );
            Employee emp3 = new Employee(
                    null, 
                    "Charlie Brown", 
                    55000.0, 
                    false, 
                    LocalDate.of(1995, 12, 1), 
                    hr, 
                    Arrays.asList(communication)
            );
            Employee emp4 = new Employee(
                    null, 
                    "Diana Ross", 
                    95000.0, 
                    true, 
                    LocalDate.of(1988, 3, 15), 
                    sales, 
                    Arrays.asList(communication, sql)
            );

            employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));

            System.out.println(">>> Database Initialized with Sample Employees, Departments, and Skills.");
        }
    }
}
