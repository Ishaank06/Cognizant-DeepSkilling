# Hands-On 5: Mockito Advanced

- **Objective:** Master Argument Matchers and Spying in Mockito.
- **Implemented:**
  - `CalculatorService` class with actual implementations for `add`, `subtract`, and `multiply` so they can be Spied.
  - `MathApplication` logic class consuming `CalculatorService`.
  - `MathApplicationTest` which tests two scenarios:
    1. **Argument Matchers**: Used `@Mock` and verified `anyInt()` with `when(...).thenReturn(...)`. Manual constructor injection was used to resolve ambiguity.
    2. **Spying**: Used `@Spy` to wrap `CalculatorService`. Specifically stubbed only the `multiply` method with `doReturn(...)` and asserted that `add` uses the real implementation while `multiply` uses the stubbed value.
- **Verification:** Ran `mvn test` successfully.
