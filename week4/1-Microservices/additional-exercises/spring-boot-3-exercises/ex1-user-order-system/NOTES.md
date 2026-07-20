# Hands-On 4.1.2 (Ex 1): User & Order Management System

- **Objective:** Understand how independent microservices communicate synchronously.
- **Implemented:**
  - **User Service:** Bootstrapped via Spring Web, running on port `8080`, exposing a mock `GET /users/{id}` endpoint.
  - **Order Service:** Bootstrapped via Spring Web and OpenFeign (`@EnableFeignClients`), running on port `8081`. 
  - Created a `UserClient` interface in the Order Service that declaratively maps to the User Service's REST API using `@FeignClient(name = "user-service", url = "http://localhost:8080")`.
  - In the `OrderController`, the Order Service retrieves its mock order data, but then makes a synchronous HTTP call to the User Service via the Feign Client to fetch the user details, merging the results before returning them to the client.
- **Verification:**
  - Started both services concurrently.
  - Curled the `GET /orders/1234` endpoint on the Order Service and verified that the response contained the enriched user data sourced from the User Service.
