# Exercise: PL/SQL Exercises

This directory contains database schemas, sample records, and PL/SQL code blocks to solve foundational scenarios involving control structures and stored procedures.

## Folder Structure
- **`control_structures.sql`**: Contains the tables, dummy data, and anonymous PL/SQL blocks for Control Structures (Exercise 1).
- **`stored_procedures.sql`**: Contains the tables, dummy data, and stored procedures for Stored Procedures (Exercise 2).

---

## Exercise 1: Control Structures

This exercise demonstrates the use of conditional checks (`IF-THEN`), loops (`FOR LOOP`), and cursor handling.

### Scenarios
1. **Loan Interest Rate Discount**: If a customer's age is above 60, a 1% discount is applied to their current loan interest rate.
2. **VIP Promotion**: Sets an `IsVIP` flag to `'Y'` (TRUE) for customers whose current balance exceeds $10,000.
3. **Due Date Reminders**: Uses an explicit cursor to fetch loans due within the next 30 days and outputs dynamic reminder notices via `DBMS_OUTPUT.PUT_LINE`.

---

## Exercise 2: Stored Procedures

This exercise demonstrates custom business logic encapsulated in reusable database procedures.

### Procedures
1. **`ProcessMonthlyInterest`**: Processes a monthly interest payout of 1% on current balances for all accounts designated as `'Savings'`.
2. **`UpdateEmployeeBonus`**: Modifies the salary of all employees within a specified department by adding a user-defined bonus percentage (passed as a parameter).
3. **`TransferFunds`**: Moves money between accounts while verifying:
   - Positive transfer amounts.
   - Existence of both source and destination accounts.
   - Sufficient balance in the source account (raising custom error messages if validation fails).

---

## How to Execute

These scripts are fully compliant with standard Oracle PL/SQL engines (such as SQL*Plus, SQL Developer, or Live SQL).

1. Execute the DDL & initialization DML in your database client:
   ```sql
   @control_structures.sql
   @stored_procedures.sql
   ```
2. Enable server output to view print logs:
   ```sql
   SET SERVEROUTPUT ON;
   ```
3. Test a stored procedure in an anonymous block:
   ```sql
   BEGIN
       TransferFunds(p_source_account => 1, p_dest_account => 2, p_amount => 500);
   END;
   /
   ```
