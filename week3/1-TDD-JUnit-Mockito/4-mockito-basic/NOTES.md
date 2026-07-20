# Hands-On 4: Mockito Basic

- **Objective:** Understand stubbing and verifying interactions using Mockito.
- **Implemented:**
  - `pom.xml` configured with `mockito-core` and `mockito-junit-jupiter`.
  - `CalculatorService` interface and its dependent `MathApplication` logic class.
  - `MathApplicationTest` utilizing `@ExtendWith(MockitoExtension.class)`.
  - Mocked the `CalculatorService` dependency using `@Mock` and injected it with `@InjectMocks`.
  - Stubbed the `add` method using `when(...).thenReturn(...)`.
  - Verified method execution using `verify(...)`.
- **Verification:** Ran `mvn test` and passed successfully.
