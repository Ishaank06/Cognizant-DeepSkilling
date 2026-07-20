# Part 2: SLF4J Logging

- **Objective:** Configure Logback and use SLF4J logging levels.
- **Implemented:**
  - Standard Maven project setup adding `slf4j-api` and `logback-classic`.
  - Defined `MathApplication` logic calling various logging levels (`trace`, `debug`, `info`, `warn`, `error`).
  - Created `logback.xml` in `src/main/resources` configuring a `ConsoleAppender` and setting the root log level to `DEBUG`.
- **Verification:** Ran `mvn exec:java` targeting the main class. The output successfully displayed `DEBUG`, `INFO` logs but omitted `TRACE` logs due to the configured root level.
