# Week 2: Spring Core, Maven, and Unit Testing

This directory contains the solutions for the Week 2 exercises on **Spring Core and Maven** and **Unit Testing / TDD**.

---

## Folder Structure

```text
week2/
├── README.md                          # This week 2 instruction and overview guide
│
├── Spring Core and Maven/
│   ├── Exercise 1/                    # Basic Spring application config
│   │   └── LibraryManagement/
│   │       ├── pom.xml
│   │       └── src/
│   │           └── main/
│   │               ├── java/com/library/
│   │               │   ├── App.java   # App runner loading independent beans
│   │               │   ├── repository/BookRepository.java
│   │               │   └── service/BookService.java
│   │               └── resources/
│   │                   └── applicationContext.xml
│   │
│   ├── Exercise 2/                    # Setter-based Dependency Injection (DI)
│   │   └── LibraryManagement/
│   │       ├── pom.xml
│   │       └── src/
│   │           └── main/
│   │               ├── java/com/library/
│   │               │   ├── LibraryManagementApplication.java # Runner verifying DI
│   │               │   ├── repository/BookRepository.java
│   │               │   └── service/BookService.java          # Service with Setter Injection
│   │               └── resources/
│   │                   └── applicationContext.xml            # Beans wired together
│   │
│   └── Exercise 4/                    # Maven configuration and dependencies
│       └── LibraryManagement/
│           ├── pom.xml                # Configured for Java 1.8 & Context, AOP, WebMVC dependencies
│           └── src/
│               └── main/
│                   └── java/com/library/
│                       └── App.java   # Verification runner for AOP and WebMVC classes
│
└── exercise 1/                        # TDD using JUnit5 and Mockito
    ├── 1. JUnit_Basic Testing Exercises.md # Detailed exercise documentation
    ├── pom.xml                        # Maven configuration with JUnit 5 & Mockito
    └── src/
        ├── main/java/com/example/bookstore/
        │   ├── model/Book.java        # Book Entity
        │   ├── repository/BookRepository.java # BookRepository Interface
        │   └── service/BookService.java       # BookService logic
        └── test/java/com/example/bookstore/
            └── service/BookServiceTest.java   # Unit tests using JUnit 5 & Mockito
    
├── Spring Data JPA with Spring Boot, Hibernate/  # JPA vs Hibernate comparison
    ├── 1. spring-data-jpa-handson.md  # Detailed exercise documentation
    ├── pom.xml                        # Spring Boot + JPA configuration
    └── src/
        └── main/
            ├── java/com/example/employee/
            │   ├── EmployeeManagementApplication.java # Spring Boot Runner
            │   ├── model/Employee.java                # JPA Entity
            │   ├── repository/EmployeeRepository.java # JpaRepository
            │   └── service/
            │       ├── EmployeeService.java           # Spring Data JPA service
            │       └── HibernateEmployeeService.java  # Boilerplate Hibernate Service
            └── resources/
                └── application.properties             # Database properties
```

---

## Exercises Description & Run Guide

### 1. Spring Core and Maven

#### Exercise 1: Configuring a Basic Spring Application
*   **Focus**: Setting up a Maven project, including Spring Core context dependencies, declaring Spring Beans in an XML application context, and bootstrapping them.
*   **Wired State**: Beans (`BookService` and `BookRepository`) are configured independently and fetched from the Spring container.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 1/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.App"
    ```

#### Exercise 2: Implementing Dependency Injection
*   **Focus**: Achieving Loose Coupling using Spring's IoC container by wiring dependencies.
*   **Wired State**: `BookRepository` is injected into `BookService` using **Setter Injection** configured in `applicationContext.xml`.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 2/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
    ```

#### Exercise 4: Creating and Configuring a Maven Project
*   **Focus**: Configuring Maven Project dependencies (`spring-context`, `spring-aop`, `spring-webmvc`, and the compiler plugin targeting Java version `1.8`).
*   **Wired State**: Demonstrates compilation and verification that AOP and WebMVC classes are loaded onto the classpath successfully.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 4/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.App"
    ```

---

### 2. Unit Testing & TDD (JUnit 5 & Mockito)

#### Exercise 1: Setting Up JUnit and Mockito
*   **Focus**: Setting up a Maven project, configuring JUnit 5 (Jupiter) and Mockito dependencies in `pom.xml`, and writing unit tests with mocked repositories.
*   **TDD Implementation**: Test-driven development is demonstrated via unit tests in `BookServiceTest` verifying standard CRUD service methods and exception handling.
*   **How to Run**:
    ```bash
    cd "week2/exercise 1"
    mvn clean test
    ```
    *(For restricted network environments bypassing SSL checks)*:
    ```bash
    mvn -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true clean test
    ```

---

### 3. Spring Data JPA with Spring Boot, Hibernate

#### Hands-on: Comparing Hibernate and Spring Data JPA
*   **Focus**: Understanding the differences between JPA (specification), Hibernate (ORM implementation), and Spring Data JPA (repository abstraction layer).
*   **Wired State**: Demonstrates native Hibernate session/transaction boilerplate compared side-by-side with Spring Data JPA declarative repositories.
*   **How to Run**:
    ```bash
    cd "week2/Spring Data JPA with Spring Boot, Hibernate"
    mvn compile spring-boot:run
    ```
    *(For restricted network environments bypassing SSL checks)*:
    ```bash
    mvn -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true compile spring-boot:run
    ```

