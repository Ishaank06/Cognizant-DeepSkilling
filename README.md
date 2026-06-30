# Cognizant Deep Skilling - Week 1

This repository contains the exercises completed for Week 1, focusing on core software design principles, foundational data structures/algorithms, and PL/SQL programming.

## Directory Structure

```
.
├── .gitignore
├── README.md
└── week1/
    ├── design_principles/
    │   ├── SingletonPatternExample/      # Thread-safe logging utility using double-checked locking
    │   └── FactoryMethodPatternExample/  # Loose-coupled document creation framework
    ├── data_structures/
    │   ├── EcommerceSearchPlatform/      # Linear vs. Binary search implementation & analysis
    │   └── FinancialForecasting/         # Recursive vs. Iterative financial forecasting & analysis
    └── pl_sql/
        ├── control_structures.sql        # Control structures (loops, cursors, conditionals)
        ├── stored_procedures.sql         # Stored procedures (modular transactions)
        └── README.md                     # PL/SQL environment execution guide
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

### 5. PL/SQL - Control Structures & Stored Procedures
- **Folder**: `week1/pl_sql`
- **Focus**: Developed database scripts for business logic rules (age-based discounts, VIP status promotion, loan due date cursor reminders) and reusable transaction procedures (savings interest processing, employee bonuses, and validated funds transfer).
