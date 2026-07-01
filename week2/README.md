# Week 2: Spring Core and Maven

This directory contains the solutions for the Week 2 exercises on **Spring Core and Maven**. The projects are organized systematically to help you understand the concepts step-by-step.

---

## Folder Structure

```text
week2/
├── README.md                          # This instruction and overview guide
└── Spring Core and Maven/
    ├── Exercise 1/                    # Basic Spring application config
    │   └── LibraryManagement/
    │       ├── pom.xml
    │       └── src/
    │           └── main/
    │               ├── java/com/library/
    │               │   ├── App.java   # App runner loading independent beans
    │               │   ├── repository/BookRepository.java
    │               │   └── service/BookService.java
    │               └── resources/
    │                   └── applicationContext.xml
    │
    ├── Exercise 2/                    # Setter-based Dependency Injection (DI)
    │   └── LibraryManagement/
    │       ├── pom.xml
    │       └── src/
    │           └── main/
    │               ├── java/com/library/
    │               │   ├── LibraryManagementApplication.java # Runner verifying DI
    │               │   ├── repository/BookRepository.java
    │               │   └── service/BookService.java          # Service with Setter Injection
    │               └── resources/
    │                   └── applicationContext.xml            # Beans wired together
    │
    └── Exercise 4/                    # Maven configuration and dependencies
        └── LibraryManagement/
            ├── pom.xml                # Configured for Java 1.8 & Context, AOP, WebMVC dependencies
            └── src/
                └── main/
                    └── java/com/library/
                        └── App.java   # Verification runner for AOP and WebMVC classes
```

---

## Exercises Description & Run Guide

### Exercise 1: Configuring a Basic Spring Application
*   **Focus**: Setting up a Maven project, including Spring Core context dependencies, declaring Spring Beans in an XML application context, and bootstrapping them.
*   **Wired State**: Beans (`BookService` and `BookRepository`) are configured independently and fetched from the Spring container.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 1/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.App"
    ```

### Exercise 2: Implementing Dependency Injection
*   **Focus**: Achieving Loose Coupling using Spring's IoC container by wiring dependencies.
*   **Wired State**: `BookRepository` is injected into `BookService` using **Setter Injection** configured in `applicationContext.xml`.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 2/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
    ```

### Exercise 4: Creating and Configuring a Maven Project
*   **Focus**: Configuring Maven Project dependencies (`spring-context`, `spring-aop`, `spring-webmvc`, and the compiler plugin targeting Java version `1.8`).
*   **Wired State**: Demonstrates compilation and verification that AOP and WebMVC classes are loaded onto the classpath successfully.
*   **How to Run**:
    ```bash
    cd "week2/Spring Core and Maven/Exercise 4/LibraryManagement"
    mvn compile exec:java -Dexec.mainClass="com.library.App"
    ```
