# Cognizant Deep Skilling - Week 1

This repository contains the exercises completed for Week 1, focusing on core software design principles and foundational data structures/algorithms.

## Directory Structure

```
.
├── .gitignore
├── README.md
└── week1/
    ├── design_principles/
    │   ├── SingletonPatternExample/      # Thread-safe logging utility using double-checked locking
    │   └── FactoryMethodPatternExample/  # Loose-coupled document creation framework
    └── data_structures/
        ├── EcommerceSearchPlatform/      # Linear vs. Binary search implementation & analysis
        └── FinancialForecasting/         # Recursive vs. Iterative financial forecasting & analysis
```

## Exercises Summary

### 1. Design Principles - Singleton Pattern
- **Folder**: `week1/design_principles/SingletonPatternExample`
- **Focus**: Implemented a thread-safe `Logger` using double-checked locking to ensure only a single instance exists. Verification includes multi-threaded test access.

### 2. Design Principles - Factory Method Pattern
- **Folder**: `week1/design_principles/FactoryMethodPatternExample`
- **Focus**: Developed a Document Management system utilizing the Factory Method Pattern. Decouples the client from concrete implementations (`WordDocument`, `PdfDocument`, `ExcelDocument`).

### 3. Data Structures - E-commerce Search Function
- **Folder**: `week1/data_structures/EcommerceSearchPlatform`
- **Focus**: Created Product lookups via Linear and Binary Search. Includes an analysis of asymptotic complexities (Big O, best/average/worst-case scenarios) and performance benchmarking.

### 4. Data Structures - Financial Forecasting
- **Folder**: `week1/data_structures/FinancialForecasting`
- **Focus**: Modeled compound investment growth using recursive algorithms, analyzed recursion limits (call stack space bounds), and implemented optimized iterative and memoized solutions.
