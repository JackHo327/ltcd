# Write a SQL query to get the nth highest salary from the Employee table.

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

# SQL
# Transact-SQL Scalar Function Syntax  
# Written the whole function as one big statement. 
# Need to use delimiters
DELIMITER //
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
     # Write your MySQL query statement below.
     SELECT MAX(Salary)
            FROM Employee Emp1
            WHERE (N-1) = ( 
                 SELECT COUNT(DISTINCT(Emp2.Salary))
                        FROM Employee Emp2
                        WHERE Emp2.Salary > Emp1.Salary)
      -- SELECT Salary FROM Employee ORDER BY Salary DESC LIMIT N-1,1;
      -- The answer above should also work in MySQL
  );
END //

# Note: refer to http://www.programmerinterview.com/index.php/database-sql/find-nth-highest-salary-sql/


SELECT MAX(Salary)
            FROM Employee Emp1
            WHERE 1 = ( 
                 SELECT COUNT(DISTINCT(Emp2.Salary))
                        FROM Employee Emp2
                        WHERE Emp2.Salary > Emp1.Salary);
                        
                        
SELECT MAX(Salary)
            FROM Employee Emp1
            WHERE 1 = ( 
                 SELECT COUNT(DISTINCT(Emp2.Salary))
                        FROM Employee Emp2
                        WHERE Emp2.Salary > Emp1.Salary);