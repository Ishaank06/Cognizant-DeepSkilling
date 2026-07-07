-- DML Script - Sample Data Inserts

-- 1. Insert Departments
INSERT INTO departments (name) VALUES ('Information Technology');
INSERT INTO departments (name) VALUES ('Human Resources');
INSERT INTO departments (name) VALUES ('Sales');

-- 2. Insert Skills
INSERT INTO skills (name) VALUES ('Java');
INSERT INTO skills (name) VALUES ('Spring Boot');
INSERT INTO skills (name) VALUES ('SQL');
INSERT INTO skills (name) VALUES ('Communication');

-- 3. Insert Employees
-- Department IDs: 1 (IT), 2 (HR), 3 (Sales)
INSERT INTO employees (name, salary, permanent, date_of_birth, department_id) VALUES 
('Alice Cooper', 85000.0, true, '1990-05-12', 1),
('Bob Marley', 75000.0, true, '1985-08-20', 1),
('Charlie Brown', 55000.0, false, '1995-12-01', 2),
('Diana Ross', 95000.0, true, '1988-03-15', 3);

-- 4. Insert Employee-Skill mapping
-- Skill IDs: 1 (Java), 2 (Spring Boot), 3 (SQL), 4 (Communication)
-- Alice Cooper (Employee 1) -> Java, Spring Boot, SQL
INSERT INTO employee_skill (employee_id, skill_id) VALUES (1, 1);
INSERT INTO employee_skill (employee_id, skill_id) VALUES (1, 2);
INSERT INTO employee_skill (employee_id, skill_id) VALUES (1, 3);

-- Bob Marley (Employee 2) -> Java, SQL
INSERT INTO employee_skill (employee_id, skill_id) VALUES (2, 1);
INSERT INTO employee_skill (employee_id, skill_id) VALUES (2, 3);

-- Charlie Brown (Employee 3) -> Communication
INSERT INTO employee_skill (employee_id, skill_id) VALUES (3, 4);

-- Diana Ross (Employee 4) -> Communication, SQL
INSERT INTO employee_skill (employee_id, skill_id) VALUES (4, 4);
INSERT INTO employee_skill (employee_id, skill_id) VALUES (4, 3);
