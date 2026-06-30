# Exercise 2: Implementing the Factory Method Pattern

## Scenario
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.

## Design Decision
To solve this scenario, we use the GoF **Factory Method Design Pattern**.
This creational pattern provides:
1. **Loose Coupling**: The client code (in `FactoryMethodTest`) interacts with the abstract product (`Document`) and abstract creator (`DocumentFactory`) without depending on concrete document implementations (like `WordDocument`).
2. **Extensibility**: Adding a new document type (e.g., PowerPoint) only requires creating a new concrete class (e.g., `PowerPointDocument`) and its corresponding creator (e.g., `PowerPointDocumentFactory`) without modifying existing client code.
3. **Single Responsibility Principle**: The instantiation logic is separated from the business logic of using the documents.

## Class Diagram Analogy
- **`Document` (Interface)**: Common product interface.
- **`WordDocument`, `PdfDocument`, `ExcelDocument` (Concrete Products)**: Concrete products that implement `Document`.
- **`DocumentFactory` (Abstract Creator)**: Declares the factory method `createDocument()`.
- **`WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory` (Concrete Creators)**: Override the factory method to return instances of the concrete products.

## How to Run (Using Terminal)

Compile the code:
```bash
javac -d bin src/com/example/factory/*.java
```

Execute the test suite:
```bash
java -cp bin com.example.factory.FactoryMethodTest
```
