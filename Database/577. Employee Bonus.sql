# Select all employee's name and bonus whose bonus is < 1000.

USE practice;

## Make table
Create table If Not Exists Employee (EmpId int, Name varchar(255), Supervisor int, Salary int);
Create table If Not Exists Bonus (EmpId int, Bonus int);
Truncate table Employee;
insert into Employee (EmpId, Name, Supervisor, Salary) values ('3', 'Brad', NULL, '4000');
insert into Employee (EmpId, Name, Supervisor, Salary) values ('1', 'John', 3, '1000');
insert into Employee (EmpId, Name, Supervisor, Salary) values ('2', 'Dan', 3, '2000');
insert into Employee (EmpId, Name, Supervisor, Salary) values ('4', 'Thomas', 3, '4000');
Truncate table Bonus;
insert into Bonus (EmpId, Bonus) values ('2', '500');
insert into Bonus (EmpId, Bonus) values ('4', '2000');

## SQL
SELECT name,
         bonus
FROM Employee
LEFT JOIN Bonus
    ON Employee.empId = Bonus.empId
WHERE bonus < 1000
        OR bonus IS NULL;

## Suggested Answer
SELECT
    Employee.name, Bonus.bonus
FROM
    Employee
        LEFT JOIN
    Bonus ON Employee.empid = Bonus.empid
WHERE
    bonus < 1000 OR bonus IS NULL;

## Note: People have no bonus records are also needed to be considered