# Hands-On 2: JUnit Advanced Testing

- **Objective:** Master Parameterized tests and suites.
- **Implemented:**
  - Added JUnit 5 Jupiter Params and Jupiter Engine to `pom.xml`.
  - Created `MathUtils.java` with a logic-driven `isPrime()` method.
  - Wrote a parameterized test `MathUtilsTest` utilizing `@ValueSource` passing both prime and non-prime integers.
  - Implemented `TestSuite` combining the tests using JUnit Platform Suite.
- **Verification:** Ran `mvn test` which successfully executed all tests.
