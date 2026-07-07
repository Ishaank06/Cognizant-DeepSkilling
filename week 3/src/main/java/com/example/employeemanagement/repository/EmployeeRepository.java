package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * HQL / JPQL (Java Persistence Query Language) Query:
     * --------------------------------------------------
     * - Uses class and field names of Java Entities rather than database table/column names.
     * - Uses "LEFT JOIN FETCH" to retrieve the associated Department and Skill list in a single 
     *   database round-trip (eager fetching).
     * - This optimizes data retrieval and solves the N+1 SELECT query problem, which occurs 
     *   when accessing lazy-loaded associations on child records.
     */
    @Query("SELECT DISTINCT e FROM Employee e " +
           "LEFT JOIN FETCH e.department " +
           "LEFT JOIN FETCH e.skills " +
           "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    /**
     * JPQL Aggregate Function Query:
     * -----------------------------
     * - Calculates the average salary of employees in a given department using AVG().
     * - Uses the @Param annotation to bind the "deptId" method parameter to the query variable.
     */
    @Query("SELECT COALESCE(AVG(e.salary), 0.0) FROM Employee e WHERE e.department.id = :deptId")
    double getAverageSalary(@Param("deptId") int departmentId);

    /**
     * Native Query:
     * -------------
     * - Uses standard MySQL syntax and queries physical database tables and columns directly.
     * - Configured by setting "nativeQuery = true".
     */
    @Query(value = "SELECT * FROM employees", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
