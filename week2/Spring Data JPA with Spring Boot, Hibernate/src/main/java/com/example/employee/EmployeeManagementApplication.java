package com.example.employee;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.HibernateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HibernateEmployeeService hibernateEmployeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n====================================================");
        System.out.println("   Testing Hibernate vs Spring Data JPA Setup       ");
        System.out.println("====================================================\n");

        System.out.println("--- 1. Testing Boilerplate Native Hibernate ---");
        Employee emp1 = new Employee("Alice Smith", "Engineering", 75000.0);
        Integer hibernateId = hibernateEmployeeService.addEmployee(emp1);
        System.out.println("Successfully added via Native Hibernate Session!");
        System.out.println("Generated ID: " + hibernateId);
        System.out.println("Employee Details: " + emp1);

        System.out.println("\n--- 2. Testing Declarative Spring Data JPA ---");
        Employee emp2 = new Employee("Bob Jones", "Marketing", 62000.0);
        Employee savedEmp2 = employeeService.addEmployee(emp2);
        System.out.println("Successfully added via JpaRepository!");
        System.out.println("Generated ID: " + savedEmp2.getId());
        System.out.println("Employee Details: " + savedEmp2);

        System.out.println("\n--- 3. Verifying All Employees Saved in Database ---");
        employeeService.getAllEmployees().forEach(System.out::println);

        System.out.println("\n====================================================");
    }
}
