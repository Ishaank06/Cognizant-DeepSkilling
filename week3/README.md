# Week 3: Employee Management Web Application

A complete Spring Boot Web REST API application built with Maven, Spring Data JPA, Hibernate, and MySQL. It demonstrates advanced querying techniques:
1. **HQL & JPQL** with optimization using `JOIN FETCH` (to prevent the N+1 SELECT problem).
2. **Native SQL Queries**.
3. **Dynamic search** using the **JPA Criteria API**.

---

## Folder Structure

```text
week 3/
├── spring-learn/                              # Spring Web Learn Project
│   ├── pom.xml                                # spring-learn Dependencies
│   ├── README.md                              # Detailed spring-learn documentation
│   └── src/                                   # Source files (com.cognizant.springlearn)
│
├── pom.xml                                    # Employee Management pom.xml
├── schema.sql                                 # MySQL database table definitions
├── data.sql                                   # MySQL sample records insert statements
├── README.md                                  # This documentation
└── src/
    └── main/
        ├── java/com/example/employeemanagement/
        │   ├── EmployeeManagementApplication.java # Spring Boot main application class
        │   │
        │   ├── config/
        │   │   └── DataInitializer.java       # Database seeder class populating sample entities
        │   │
        │   ├── controller/
        │   │   └── EmployeeController.java    # REST API endpoints controller
        │   │
        │   ├── service/
        │   │   └── EmployeeService.java       # Service layer implementing Criteria API search
        │   │
        │   ├── repository/
        │   │   ├── EmployeeRepository.java    # Repository layer holding HQL and Native query methods
        │   │   ├── DepartmentRepository.java  # Department entity repository
        │   │   └── SkillRepository.java       # Skill catalog repository
        │   │
        │   ├── entity/
        │   │   ├── Employee.java              # Employee entity class (JPA Annotations)
        │   │   ├── Department.java            # Department entity class (OneToMany relationship)
        │   │   └── Skill.java                 # Skill catalog entity class (ManyToMany relationship)
        │   │
        │   ├── dto/
        │   │   ├── EmployeeDTO.java           # DTO preventing infinite JSON recursion
        │   │   ├── DepartmentDTO.java         # DTO formatting department properties
        │   │   └── SkillDTO.java              # DTO formatting skill properties
        │   │
        │   └── exception/
        │       ├── ResourceNotFoundException.java # Custom 404 Exception mapping
        │       └── GlobalExceptionHandler.java # REST global exception interceptor
        │
        └── resources/
            └── application.properties         # Environment properties (MySQL & H2 database)
```

---

## Core Classes & Architecture

### 1. Model / Entities (`entity`)
- **`Employee`**: Maps to the database table `employees`. Has a `@ManyToOne` relationship with `Department` and a `@ManyToMany` relationship with `Skill` using `employee_skill` join table.
- **`Department`**: Maps to the database table `departments`. Houses a `@OneToMany` list of employees.
- **`Skill`**: Maps to the database table `skills`. Represents an independent catalog of developer skills.

### 2. Data Transfer Objects (`dto`)
- **`EmployeeDTO` / `DepartmentDTO` / `SkillDTO`**: Used to map entity layers to API response formats. They decouple persistence models from Jackson JSON serialization, resolving the Infinite Recursion loop that arises from bidirectional relational mappings (`Employee <-> Department`).

### 3. Repositories (`repository`)
- **`EmployeeRepository`**: Contains the query implementation objectives:
  - **HQL/JPQL with Eager Fetch**: Uses `LEFT JOIN FETCH e.department LEFT JOIN FETCH e.skills` to load related models in a single query, preventing the common N+1 query issue.
  - **HQL Aggregate**: Calculates average salary using JPQL's `AVG()` and binds parameter using `@Param`.
  - **Native SQL**: Direct query execution using `nativeQuery = true` targeting raw SQL (`SELECT * FROM employees`).

### 4. Service Layer (`service`)
- **`EmployeeService`**: Implements the transactional wrapper. It also implements the **Criteria Query** search (`searchEmployeesUsingCriteria` method) leveraging:
  - **`CriteriaBuilder`**: Builds SQL conditions (`cb.like`, `cb.ge`, `cb.le`, `cb.equal`).
  - **`CriteriaQuery`**: Sets up select targets and aggregates predicates.
  - **`Root`**: Represents the base query entity table (`Employee`).
  - **`Predicate`**: Chains search filters together (AND query logic).
  - **`TypedQuery`**: Binds the criteria query to a typed execution result.

### 5. Controller Layer (`controller`)
- **`EmployeeController`**: Exposes standard rest resources:
  - `GET /employees`: List all employees.
  - `GET /employees/permanent`: List permanent employees (usesoptimized HQL JOIN FETCH query).
  - `GET /employees/native`: List all employees running native query.
  - `GET /employees/average/{departmentId}`: Retrieves average salary of target department.
  - `GET /employees/search`: Dynamic query filter. Supports parameters like `name`, `minSalary`, `maxSalary`, `departmentId`, and `permanent`.

---

## How to Run the Project

### Prerequisites
1. **Java Runtime**: JDK 17 or JDK 21 installed.
2. **Database (MySQL)**: 
   - A running MySQL instance on `localhost:3306`.
   - A database created called `employeedb`.
   - MySQL credentials should match `username=root` and `password=root` (or edit [application.properties](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week%203/src/main/resources/application.properties)).

*(Note: If you do not have MySQL running locally, you can uncomment the **H2 In-Memory Database** configurations in `application.properties` to run it immediately without external databases.)*

---

### Run in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Go to **File -> Open** and select the `week 3` folder containing the `pom.xml`.
3. Allow Maven to import and download all dependencies.
4. Open [EmployeeManagementApplication.java](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week%203/src/main/java/com/example/employeemanagement/EmployeeManagementApplication.java) and click the **Run** button (green play icon next to the `main` method).
5. The application will start on `http://localhost:8080`.

---

### Run in VS Code
1. Open VS Code.
2. Click **File -> Open Folder** and select the `week 3` folder.
3. Ensure the **Extension Pack for Java** and **Spring Boot Extension Pack** are installed.
4. Wait for dependencies to download.
5. Go to the "Spring Boot Dashboard" in the side panel and click "Start" next to `employee-management`, or open [EmployeeManagementApplication.java](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week%203/src/main/java/com/example/employeemanagement/EmployeeManagementApplication.java) and click "Run" from the editor overlay.

---

### Run using Command Line
Open a terminal in the `week 3/` folder and run:
```bash
mvn spring-boot:run
```
*(For restricted network environments bypassing SSL checks)*:
```bash
mvn -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true spring-boot:run
```

---

## `spring-learn` Project

This subfolder contains the `com.cognizant:spring-learn` Maven project built to learn Spring Web and DevTools startup logging.

- **Path**: [spring-learn/](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week%203/spring-learn)
- **Log verification**: Prints starting logs inside its `main` method using SLF4J.
- **Run command**:
  ```bash
  cd "week 3/spring-learn"
  mvn spring-boot:run
  ```
