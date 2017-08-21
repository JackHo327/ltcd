# Write a SQL query that finds out employees who earn more than their managers.

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int);
Truncate table Employee;
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', NULL);
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', NULL);

## SQL
SELECT e1.Name AS Employee
FROM Employee AS e1
JOIN Employee AS e2
    ON e1.ManagerId = e2.Id
        AND e1.Salary > e2.Salary;

## Suggested Answer
SELECT a.Name AS 'Employee'
FROM Employee AS a, Employee AS b
WHERE a.ManagerId = b.Id
        AND a.Salary > b.Salary;

## Suggested Answer
SELECT a.NAME AS Employee
FROM Employee AS a
JOIN Employee AS b
    ON a.ManagerId = b.Id
        AND a.Salary > b.Salary;