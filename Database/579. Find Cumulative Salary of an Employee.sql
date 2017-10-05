# Write a SQL to get the cumulative sum of an employee's salary over a period of 3 months but exclude the most recent month. The result should be displayed by 'Id' ascending, and then by 'Month' descending.

USE practice;

# make table
Create table If Not Exists Employee (Id int, Month int, Salary int);
Truncate table Employee;
insert into Employee (Id, Month, Salary) values ('1', '1', '20');
insert into Employee (Id, Month, Salary) values ('2', '1', '20');
insert into Employee (Id, Month, Salary) values ('1', '2', '30');
insert into Employee (Id, Month, Salary) values ('2', '2', '30');
insert into Employee (Id, Month, Salary) values ('3', '2', '40');
insert into Employee (Id, Month, Salary) values ('1', '3', '40');
insert into Employee (Id, Month, Salary) values ('3', '3', '60');
insert into Employee (Id, Month, Salary) values ('1', '4', '60');
insert into Employee (Id, Month, Salary) values ('3', '4', '70');


SELECT * FROM Employee;

## Suggested Answer

SELECT E1.id,
         E1.month,
         (IFNULL(E1.salary,
         0) + IFNULL(E2.salary,
         0) + IFNULL(E3.salary,
         0)) AS Salary
FROM 
    (SELECT id,
         MAX(month) AS month
    FROM Employee
    GROUP BY  id
    HAVING COUNT(*) > 1) AS maxmonth
LEFT JOIN Employee E1
    ON (maxmonth.id = E1.id
        AND maxmonth.month > E1.month)
LEFT JOIN Employee E2
    ON (E2.id = E1.id
        AND E2.month = E1.month - 1)
LEFT JOIN Employee E3
    ON (E3.id = E1.id
        AND E3.month = E1.month - 2)
ORDER BY  id ASC , month DESC; 