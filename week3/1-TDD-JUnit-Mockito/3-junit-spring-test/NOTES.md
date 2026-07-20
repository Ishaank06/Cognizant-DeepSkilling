# Hands-On 3: JUnit + Spring Testing

- **Objective:** Test Spring components using `@SpringBootTest` and `@DataJpaTest`.
- **Implemented:**
  - Scaffolding of Spring Boot project with Web, Data JPA, and H2 dependencies.
  - Creation of `GreetingService` with an `@SpringBootTest` asserting its dependency injection and logic.
  - Creation of `Product` entity and `ProductRepository`.
  - Implementation of `ProductRepositoryTest` using `@DataJpaTest` to verify saving and finding an entity via an in-memory database.
- **Verification:** Ran `mvn test` which successfully booted the context and executed both tests.
