# Select all employee's name and bonus whose bonus is < 1000.

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

## SQL
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < 
    (SELECT MAX(Salary)
    FROM Employee);

## Suggested Answer
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary;

## Note: OFFSET == pick the start position => LIMIT 1 OFFSET 1 == start from #1 (#! not included), find the the next 1 (#2)

SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary

## Note: IFNULL(expr1, expr2) == if expr1 is not NULL, then return expr1, or return expr2