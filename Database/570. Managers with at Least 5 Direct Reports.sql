# Write a SQL query that finds out managers with at least 5 direct report

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Name varchar(255), Department varchar(255), ManagerId int);
Truncate table Employee;
insert into Employee (Id, Name, Department, ManagerId) values ('101', 'John', 'A', NULL);
insert into Employee (Id, Name, Department, ManagerId) values ('102', 'Dan', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('103', 'James', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('104', 'Amy', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('105', 'Anne', 'A', '101');
insert into Employee (Id, Name, Department, ManagerId) values ('106', 'Ron', 'B', '101');

## SQL
SELECT e1.Name AS Name
FROM Employee e1
INNER JOIN Employee e2
ON e1.Id = e2.ManagerId
GROUP BY e1.Name
HAVING COUNT(e1.Name) >= 5;

## Suggested Answer
SELECT Name
FROM Employee AS t1
JOIN 
    (SELECT ManagerId
    FROM Employee
    GROUP BY  ManagerId
    HAVING COUNT(ManagerId) >= 5) AS t2
    ON t1.Id = t2.ManagerId;

## Note: It's ok to get the ManagerId (>=5) by the ManagerId, and this will make the table smaller before join.