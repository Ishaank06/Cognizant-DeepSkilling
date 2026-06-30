BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    IsVIP VARCHAR2(1) DEFAULT 'N'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1, 'Alice Smith', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000, 'N');
INSERT INTO Customers VALUES (2, 'Bob Jones', TO_DATE('1980-08-22', 'YYYY-MM-DD'), 8500, 'N');
INSERT INTO Customers VALUES (3, 'Charlie Brown', TO_DATE('1940-11-10', 'YYYY-MM-DD'), 15000, 'N');
INSERT INTO Customers VALUES (4, 'Diana Prince', TO_DATE('1995-02-03', 'YYYY-MM-DD'), 25000, 'N');

INSERT INTO Loans VALUES (101, 1, 50000, 7.5, TO_DATE('2026-07-15', 'YYYY-MM-DD'));
INSERT INTO Loans VALUES (102, 2, 20000, 6.0, TO_DATE('2026-09-01', 'YYYY-MM-DD'));
INSERT INTO Loans VALUES (103, 3, 30000, 8.0, TO_DATE('2026-07-20', 'YYYY-MM-DD'));
INSERT INTO Loans VALUES (104, 4, 15000, 5.5, TO_DATE('2026-07-05', 'YYYY-MM-DD'));

COMMIT;

DECLARE
    v_age NUMBER;
BEGIN
    FOR r_cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
BEGIN
    FOR r_cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
    r_loan c_due_loans%ROWTYPE;
BEGIN
    OPEN c_due_loans;
    LOOP
        FETCH c_due_loans INTO r_loan;
        EXIT WHEN c_due_loans%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || r_loan.Name || 
                             ' has Loan ID ' || r_loan.LoanID || 
                             ' due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
    CLOSE c_due_loans;
END;
/
