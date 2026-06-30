BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Salary NUMBER,
    Department VARCHAR2(50)
);

INSERT INTO Accounts VALUES (1, 1001, 'Savings', 5000);
INSERT INTO Accounts VALUES (2, 1002, 'Checking', 3000);
INSERT INTO Accounts VALUES (3, 1003, 'Savings', 12000);
INSERT INTO Accounts VALUES (4, 1004, 'Checking', 1500);

INSERT INTO Employees VALUES (1, 'John Doe', 60000, 'HR');
INSERT INTO Employees VALUES (2, 'Jane Smith', 80000, 'IT');
INSERT INTO Employees VALUES (3, 'Bob Johnson', 75000, 'IT');
INSERT INTO Employees VALUES (4, 'Alice Green', 55000, 'Finance');

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% processed successfully for all Savings accounts.');
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    IF p_bonus_percentage IS NULL OR p_bonus_percentage < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Invalid bonus percentage.');
        RETURN;
    END IF;
    
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to employees in department: ' || p_department);
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
    v_dest_exists NUMBER;
BEGIN
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be positive.');
        RETURN;
    END IF;

    BEGIN
        SELECT Balance INTO v_source_balance
        FROM Accounts
        WHERE AccountID = p_source_account;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Source account ' || p_source_account || ' does not exist.');
            RETURN;
    END;

    SELECT COUNT(*) INTO v_dest_exists
    FROM Accounts
    WHERE AccountID = p_dest_account;

    IF v_dest_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Destination account ' || p_dest_account || ' does not exist.');
        RETURN;
    END IF;

    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance. Available: ' || v_source_balance || ', Requested: ' || p_amount);
        RETURN;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_source_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_dest_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Transferred ' || p_amount || ' from Account ' || p_source_account || ' to Account ' || p_dest_account);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transaction failed. ' || SQLERRM);
END;
/
