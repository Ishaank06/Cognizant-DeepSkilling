# Exercise 7: Financial Forecasting

## Understanding Recursive Algorithms

Recursion is a programming technique where a method calls itself directly or indirectly to solve a problem. It works by breaking down a complex problem into smaller, more manageable subproblems of the same type.

Every recursive algorithm requires two key components:
1. **Base Case**: The condition under which the recursion terminates, preventing infinite loops.
2. **Recursive Step**: The logic that reduces the problem towards the base case and calls the method again.

### Why use Recursion?
- **Simplifies Code**: Many algorithms and data structures (such as tree traversals, graph searches, divide-and-conquer, and mathematical recurrences like Fibonacci or growth rates) are naturally recursive. Recursion maps directly to these models, resulting in clean, readable code.

---

## Complexity Analysis & Limitations

For the recursive compound interest formula:
$$FV(t) = (1 + r) \times FV(t-1)$$
$$Base\ Case: FV(0) = PV$$

### Time Complexity: $O(N)$
- There are $N$ total recursive calls made to compute the forecast for $N$ periods. Each call takes $O(1)$ constant time. Hence, the overall time complexity is linear.

### Space Complexity: $O(N)$
- Every recursive call creates a new stack frame on the call stack to store local variables and the return address. For $N$ periods, there are $N$ active stack frames, leading to $O(N)$ auxiliary space complexity.
- **The Stack Overflow Risk**: For large values of $N$ (e.g., $10,000+$ periods), the JVM will exhaust the call stack memory limit, causing a `StackOverflowError` and crashing the application.

---

## Optimization Techniques

To optimize recursive algorithms and avoid excessive computation or stack overflows, we can employ three main strategies:

### 1. Iteration (Looping)
- By converting the recursion into a simple `for` or `while` loop, we calculate the growth iteratively.
- **Benefit**: Reduces the space complexity from $O(N)$ to $O(1)$ by eliminating call stack allocation. It is completely safe from stack overflow errors.

### 2. Memoization (Caching)
- In branching recursion (e.g., predicting multiple scenarios, binomial trees, or Fibonacci where subproblems overlap), we cache computed results in a HashMap or array. Before computing, the method checks the cache.
- **Benefit**: Drastically reduces time complexity (e.g., from $O(2^N)$ exponential down to $O(N)$ linear).

### 3. Closed-Form Mathematical Formula
- Using direct computation via exponents: $FV = PV \times (1 + r)^t$ (using `Math.pow(1 + rate, periods)`).
- **Benefit**: Executes in $O(\log N)$ or $O(1)$ time and $O(1)$ space.

---

## How to Run (Using Terminal)

Compile the code:
```bash
javac -d bin src/com/example/forecast/*.java
```

Execute the test suite:
```bash
java -cp bin com.example.forecast.ForecastingTest
```
