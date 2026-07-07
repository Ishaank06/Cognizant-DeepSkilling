package com.example.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private double salary;
    private boolean permanent;
    private LocalDate dateOfBirth;
    private DepartmentDTO department;
    private List<SkillDTO> skills;
}
