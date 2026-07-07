package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.dto.SkillDTO;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get all employees (Using standard JpaRepository findAll, mapping to DTOs).
     */
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get all permanent employees (Optimized using JPQL JOIN FETCH).
     */
    public List<EmployeeDTO> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get all employees using native query.
     */
    public List<EmployeeDTO> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get average salary in a department.
     */
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    /**
     * Dynamic search using Criteria API:
     * ---------------------------------
     * Demonstrates CriteriaBuilder, CriteriaQuery, Root, Predicate, and TypedQuery.
     * Uses JOIN FETCH optimization to prevent N+1 select queries during result rendering.
     */
    @SuppressWarnings("unchecked")
    public List<EmployeeDTO> searchEmployeesUsingCriteria(
            String name, 
            Double minSalary, 
            Double maxSalary, 
            Integer departmentId, 
            Boolean permanent) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);

        // Fetch joins to prevent N+1 queries. We cast Fetch to Join to reuse for predicates.
        Join<Employee, Department> departmentJoin = (Join<Employee, Department>) (Join) employee.fetch("department", JoinType.LEFT);
        employee.fetch("skills", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        // Name match (Case-insensitive partial matching)
        if (name != null && !name.trim().isEmpty()) {
            predicates.add(cb.like(cb.lower(employee.get("name")), "%" + name.toLowerCase() + "%"));
        }

        // Salary range boundaries
        if (minSalary != null) {
            predicates.add(cb.ge(employee.get("salary"), minSalary));
        }
        if (maxSalary != null) {
            predicates.add(cb.le(employee.get("salary"), maxSalary));
        }

        // Department ID criteria
        if (departmentId != null) {
            predicates.add(cb.equal(departmentJoin.get("id"), departmentId));
        }

        // Permanent status criteria
        if (permanent != null) {
            predicates.add(cb.equal(employee.get("permanent"), permanent));
        }

        // Compose and execute distinct select query
        cq.select(employee).distinct(true).where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Employee> query = entityManager.createQuery(cq);
        List<Employee> results = query.getResultList();

        return results.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Helper conversion method Entity -> DTO.
     * Prevents infinite Jackson JSON serialization loop caused by circular model relationships.
     */
    private EmployeeDTO convertToDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setSalary(employee.getSalary());
        dto.setPermanent(employee.isPermanent());
        dto.setDateOfBirth(employee.getDateOfBirth());

        if (employee.getDepartment() != null) {
            dto.setDepartment(new DepartmentDTO(
                    employee.getDepartment().getId(),
                    employee.getDepartment().getName()
            ));
        }

        if (employee.getSkills() != null) {
            dto.setSkills(employee.getSkills().stream()
                    .map(skill -> new SkillDTO(skill.getId(), skill.getName()))
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}
