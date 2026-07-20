# Hands-On 4.1.1: Core Microservices (Account, Loan, Eureka, API Gateway)

- **Objective:** Understand the core architecture of Microservices by splitting a monolith into independent components and registering them via a central discovery server.
- **Implemented:**
  - **Account Microservice:** Bootstrapped via Spring Web, running on port `8080`, returning mock JSON.
  - **Loan Microservice:** Bootstrapped via Spring Web, running on port `8081`, returning mock JSON.
  - **Eureka Discovery Server:** Created via Spring Cloud Netflix Eureka Server (`@EnableEurekaServer`), running on port `8761`. Configured not to register with itself (`eureka.client.register-with-eureka=false`).
  - **Eureka Clients:** Updated both Account and Loan services with `@EnableDiscoveryClient` and the Eureka client dependency so they auto-register.
  - **Greet Service:** Bootstrapped running on port `8082` with a simple "Hello World" `/greet` endpoint, also registered with Eureka.
  - **API Gateway:** Created via Spring Cloud Gateway, running on port `9090`. We enabled `spring.cloud.gateway.discovery.locator.enabled=true` so it dynamically routes requests based on the Eureka registry. We also implemented a `LogFilter` (`GlobalFilter`) that prints the request URI to the console on every incoming request.
- **Verification:**
  - Started all services concurrently.
  - Successfully fetched mock data directly from Account and Loan.
  - Successfully verified all services appeared in the Eureka Server dashboard.
  - Successfully routed a request through the API Gateway (`localhost:9090/greet-service/greet`) and witnessed the `LogFilter` log the URI in the gateway's console output.
