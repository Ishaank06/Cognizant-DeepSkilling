# Hands-On 4.1.2 (Ex 2): Inventory System with Config Server

- **Objective:** Understand how to externalize and centralize configuration for multiple microservices using Spring Cloud Config.
- **Implemented:**
  - **Config Server:** Bootstrapped via `@EnableConfigServer`, running on port `8888`. We configured the native profile (`spring.profiles.active=native`) to read configuration files directly from the classpath (`classpath:/config-repo`).
  - Created `config-repo/product-service.properties` with a dummy property `dummy.config.message`.
  - **Product Service:** Configured to pull configuration from the Config Server on startup using `spring.config.import=optional:configserver:http://localhost:8888`. Exposed a `/products/config` endpoint that injects `@Value("${dummy.config.message}")`.
  - **Inventory Service:** Scaffolded as part of the architecture, ready to join the Eureka registry alongside the Product service.
- **Verification:**
  - Started the Config Server and Product Service concurrently.
  - Curled `GET /products/config` and verified that the Product Service successfully fetched its externalized configuration from the Config Server without having the property defined in its own `application.properties`.
