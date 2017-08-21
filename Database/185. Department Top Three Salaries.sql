# Write a SQL query to find employees who earn the top three salaries in each of the department

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

## SQL
## The subquery is looking for the salary which satisfy the counts is smaller than 3.
## When 70000 ==> 90000, 85000 ==> 2 < 3
## When 90000 ==> ... ==> 0 < 3
## When 85000 ==> ... ==> 1 < 3
## When 69000 ==> ... ==> 3 == 3
## So the top 3 are 70000, 90000 and 85000
SELECT Department.Name AS Department,
         tmp.Name AS Employee,
         Salary
FROM 
    (SELECT *
    FROM Employee e1
    WHERE 3 > 
        (SELECT COUNT(DISTINCT(e2.Salary))
        FROM Employee e2
        WHERE e1.DepartmentId = e2.DepartmentId
                AND e2.Salary > e1.Salary)) tmp
    JOIN Department
    ON tmp.DepartmentId = Department.Id;

## Time Limit Exceeded
## JOIN tables will usually cost LOT OF TIME and RESOURCE
SELECT Department.Name AS Department,
         e1.Name AS Employee,
         Salary
FROM Employee e1
JOIN Department
    ON e1.DepartmentId = Department.Id
WHERE 3 > (SELECT COUNT(DISTINCT(e2.Salary))
FROM Employee e2
WHERE e1.DepartmentId = e2.DepartmentId
        AND e2.Salary > e1.Salary)
ORDER BY Department, Salary DESC;

## Suggest Answer
SELECT d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM Employee e1
JOIN Department d
    ON e1.DepartmentId = d.Id
WHERE 3 > 
    (SELECT COUNT(DISTINCT e2.Salary)
    FROM Employee e2
    WHERE e2.Salary > e1.Salary
            AND e1.DepartmentId = e2.DepartmentId) ;

## Note: In the sub-query, must specify the DepartmentIds have to be equal to each other's to ensure the comparasion is inner the Department.