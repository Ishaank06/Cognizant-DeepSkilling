# Exercise 2: E-commerce Platform Search Function

## Understanding Asymptotic Notation

Asymptotic notation is a mathematical tool used to describe the limiting behavior of a function. In computer science, we use it to analyze and compare the performance (time and space complexity) of algorithms as the input size ($N$) grows towards infinity.

### Big O Notation
**Big O Notation ($O$)** represents the upper bound of an algorithm's running time (worst-case scenario). It helps software engineers:
- Predict algorithm scalability independently of hardware, OS, or compiler differences.
- Identify performance bottlenecks early in the design phase.

### Search Operations Scenarios
For searching elements in a collection, we evaluate three scenarios:
1. **Best Case ($\Omega$)**: The minimum resources needed. For example, finding the target item at the very first position in the array.
2. **Average Case ($\Theta$)**: The expected resources needed over all possible inputs. For search, this usually corresponds to the item being located in the middle of the array.
3. **Worst Case ($O$)**: The maximum resources needed. For example, finding the target item at the very end of the array, or not finding it at all.

---

## Comparison of Search Algorithms

| Aspect | Linear Search | Binary Search |
|---|---|---|
| **Data Requirement** | Works on any array (unsorted or sorted). | Requires the array to be **sorted**. |
| **Best Case Time** | $O(1)$ (Target is the first element) | $O(1)$ (Target is the middle element) |
| **Average Case Time** | $O(N)$ (Target is in the middle) | $O(\log N)$ |
| **Worst Case Time** | $O(N)$ (Target is at the end or absent) | $O(\log N)$ (Repeatedly halving search space) |
| **Space Complexity** | $O(1)$ (In-place search) | $O(1)$ (Iterative implementation) |

---

## E-commerce Platform Suitability Analysis

### Which algorithm is more suitable and why?

For a modern e-commerce platform, **Binary Search** is far more suitable than Linear Search for product lookup, provided that the catalog is pre-sorted. Here is why:

1. **Scalability ($N$ growth)**:
   - If an e-commerce catalog contains $1,000,000$ products:
     - **Linear Search** requires up to $1,000,000$ comparisons in the worst case.
     - **Binary Search** requires at most $\log_2(1,000,000) \approx 20$ comparisons.
   - The efficiency gap scales exponentially as the product list grows.

2. **Sorted Nature of Catalogs**:
   - In real-world e-commerce databases, indexing is used to keep product records sorted automatically by key attributes (like Product ID or SKU).
   - Because the catalog is sorted once and read millions of times, the one-time cost of sorting is amortized, making Binary Search extremely cost-efficient.

---

## How to Run (Using Terminal)

Compile the code:
```bash
javac -d bin src/com/example/search/*.java
```

Execute the test suite:
```bash
java -cp bin com.example.search.SearchTest
```
