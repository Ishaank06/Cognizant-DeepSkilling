# Exercise 1: Implementing the Singleton Pattern

## Scenario
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.

## Design Decision
To solve this scenario, we use the **Singleton Design Pattern** with **Double-Checked Locking**. 
This lazy-initialization approach guarantees:
1. **Single Instance**: The private constructor prevents direct instantiation, and reflection access is blocked.
2. **Lazy Loading**: The logger is created only when it is requested for the first time, saving memory resources.
3. **Thread Safety**: It is fully safe for multi-threaded applications by synchronizing only during the initial creation phase.
4. **Performance**: Subsequent accesses to `getInstance()` bypass synchronization, preventing lock overhead.

## Code Overview

- **`Logger.java`**: Uses a `volatile` keyword and double-checked synchronization block inside `getInstance()` to manage access.
- **`LoggerTest.java`**: A driver program verifying:
  - Reference equality under single-threaded usage.
  - Consistent instance sharing when accessed concurrently by 10 independent threads.

## How to Run (Using Terminal)

Compile the code:
```bash
javac -d bin src/com/example/singleton/*.java
```

Execute the test suite:
```bash
java -cp bin com.example.singleton.LoggerTest
```
