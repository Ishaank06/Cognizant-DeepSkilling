# Hands-On 1 to 4: Spring REST & Exception Handling

- **Objective:** Build REST endpoints, use custom responses, handle exceptions globally, and add bean validations.
- **Implemented:**
  - Added `spring-boot-starter-validation`.
  - Created `Country` POJO annotated with `@NotNull` and `@Size`.
  - Created `CountryNotFoundException` with `@ResponseStatus(HttpStatus.NOT_FOUND)`.
  - Created `GlobalExceptionHandler` with `@RestControllerAdvice` to catch `MethodArgumentNotValidException` and extract a structured custom JSON response containing a timestamp, status 400, and a list of field error messages.
  - Implemented `CountryController` providing GET endpoints for listing all or by code, and a POST endpoint using `@Valid`.
- **Verification:** Ran application and curled endpoints. Verified normal data returns (200), not found returns (404), and bad request custom validation errors (400).
