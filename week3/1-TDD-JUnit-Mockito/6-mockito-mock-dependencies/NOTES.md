# Hands-On 6: Mockito Mocking Dependencies

- **Objective:** Mock multiple interconnected dependencies that interact with collections.
- **Implemented:**
  - `User` and `Order` POJOs.
  - `UserService` (returns lists of users) and `OrderService` (returns lists of orders for a user).
  - `OrderManager` which depends on both services and iterates over all users to aggregate their orders into a single list.
  - `OrderManagerTest` which mocks both services, stubs them to return predefined mock collections, and asserts that exactly 4 orders are collected.
  - Verified method invocations to ensure both services were called the expected number of times using `verify(..., times(1))`.
- **Verification:** Ran `mvn test` successfully.
