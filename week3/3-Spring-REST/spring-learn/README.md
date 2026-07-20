# Spring Web Project Walkthrough: spring-learn

This project has been created using Maven and Spring Boot based on the Cognizant training guidelines.

---

## 1. Project Directory Structure

*   **`src/main/java`**: 
    - This is the source folder containing all the Java application code (controllers, services, entities, configurations).
    - In this project, it houses the main package `com.cognizant.springlearn` containing [SpringLearnApplication.java](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week2/spring-learn/src/main/java/com/cognizant/springlearn/SpringLearnApplication.java).
*   **`src/main/resources`**:
    - This folder houses the application configurations, static assets, templates, and property files.
    - It contains [application.properties](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week2/spring-learn/src/main/resources/application.properties) which configures environment attributes such as `server.port` and logging levels.
*   **`src/test/java`**:
    - Contains the test suites and source code for testing application logic.
    - Includes unit and integration test frameworks (like JUnit 5 and Mockito).

---

## 2. SpringLearnApplication.java Walkthrough

The [SpringLearnApplication.java](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week2/spring-learn/src/main/java/com/cognizant/springlearn/SpringLearnApplication.java) class serves as the entry point:

```java
package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Entering main() method of SpringLearnApplication");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication started successfully and running!");
    }
}
```

### The `main()` Method Explained:
- When you execute `SpringLearnApplication`, Java calls the standard `public static void main(String[] args)` method.
- The logger records the execution of the main method.
- `SpringApplication.run(SpringLearnApplication.class, args)` is called:
  - This initializes the Spring Application Context.
  - Automatically starts an embedded web server (Tomcat by default) on port `8086`.
  - Performs package scans to instantiate and wire bean dependencies.

---

## 3. Purpose of the `@SpringBootApplication` Annotation

The `@SpringBootApplication` is a convenience annotation that combines three core Spring annotations:

1.  **`@SpringBootConfiguration`**: 
    - Behaves similarly to `@Configuration`. Marks the class as a source of bean definitions for the application context.
2.  **`@EnableAutoConfiguration`**:
    - Directs Spring Boot to automatically configure beans based on the libraries present on your Maven classpath (e.g., configuring Spring Web MVC beans because `spring-boot-starter-web` is declared in `pom.xml`).
3.  **`@ComponentScan`**:
    - Configures component scanning to automatically discover and register Spring components (like `@Component`, `@Service`, `@Repository`, `@RestController`) within the current package (`com.cognizant.springlearn`) and all its subpackages.

---

## 4. `pom.xml` Walkthrough

The [pom.xml](file:///Users/ishaankapoor/Desktop/Cognizant-DeepSkilling/week2/spring-learn/pom.xml) defines the project coordinates and dependencies:

- **`spring-boot-starter-parent`**: Configures the default build properties, plugin versions, and dependency versions.
- **`spring-boot-starter-web`**: Imports libraries needed to build web applications, including RESTful endpoints, Spring MVC, and the embedded Tomcat container.
- **`spring-boot-devtools`**: Provides development utilities such as automatic class path reload, hot restarts, and disabled caching for templates.

### Dependency Tree (Hierarchy)
Running the `mvn dependency:tree` command on this project produces the following hierarchy:

```text
com.cognizant:spring-learn:jar:0.0.1-SNAPSHOT
+- org.springframework.boot:spring-boot-starter-web:jar:3.3.1:compile
|  +- org.springframework.boot:spring-boot-starter:jar:3.3.1:compile
|  |  +- org.springframework.boot:spring-boot:jar:3.3.1:compile
|  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:3.3.1:compile
|  |  +- org.springframework.boot:spring-boot-starter-logging:jar:3.3.1:compile
|  |  |  +- ch.qos.logback:logback-classic:jar:1.5.6:compile
|  |  |  +- ch.qos.logback:logback-core:jar:1.5.6:compile
|  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.23.1:compile
|  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.23.1:compile
|  |  |  \- org.slf4j:jul-to-slf4j:jar:2.0.13:compile
|  |  +- jakarta.annotation:jakarta.annotation-api:jar:2.1.1:compile
|  |  \- org.yaml:snakeyaml:jar:2.2:compile
|  +- org.springframework.boot:spring-boot-starter-json:jar:3.3.1:compile
|  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.17.1:compile
|  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.17.1:compile
|  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.17.1:compile
|  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.17.1:compile
|  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.17.1:compile
|  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.17.1:compile
|  +- org.springframework.boot:spring-boot-starter-tomcat:jar:3.3.1:compile
|  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.25:compile
|  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.25:compile
|  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.25:compile
|  +- org.springframework:spring-web:jar:6.1.10:compile
|  |  +- org.springframework:spring-beans:jar:6.1.10:compile
|  |  \- io.micrometer:micrometer-observation:jar:1.13.1:compile
|  |     \- io.micrometer:micrometer-commons:jar:1.13.1:compile
|  \- org.springframework:spring-webmvc:jar:6.1.10:compile
|     +- org.springframework:spring-aop:jar:6.1.10:compile
|     +- org.springframework:spring-context:jar:6.1.10:compile
|     \- org.springframework:spring-expression:jar:6.1.10:compile
+- org.springframework.boot:spring-boot-devtools:jar:3.3.1:compile (optional)
\- org.springframework.boot:spring-boot-starter-test:jar:3.3.1:test
   +- org.springframework.boot:spring-boot-test:jar:3.3.1:test
   +- org.springframework.boot:spring-boot-test-autoconfigure:jar:3.3.1:test
   ...
```
