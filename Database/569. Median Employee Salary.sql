# Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.

USE practice;

## Make table
Create table If Not Exists Employee (Id int, Company varchar(255), Salary int);
Truncate table Employee;
insert into Employee (Id, Company, Salary) values ('1', 'A', '2341');
insert into Employee (Id, Company, Salary) values ('2', 'A', '341');
insert into Employee (Id, Company, Salary) values ('3', 'A', '15');
insert into Employee (Id, Company, Salary) values ('4', 'A', '15314');
insert into Employee (Id, Company, Salary) values ('5', 'A', '451');
insert into Employee (Id, Company, Salary) values ('6', 'A', '513');
insert into Employee (Id, Company, Salary) values ('7', 'B', '15');
insert into Employee (Id, Company, Salary) values ('8', 'B', '13');
insert into Employee (Id, Company, Salary) values ('9', 'B', '1154');
insert into Employee (Id, Company, Salary) values ('10', 'B', '1345');
insert into Employee (Id, Company, Salary) values ('11', 'B', '1221');
insert into Employee (Id, Company, Salary) values ('12', 'B', '234');
insert into Employee (Id, Company, Salary) values ('13', 'C', '2345');
insert into Employee (Id, Company, Salary) values ('14', 'C', '2645');
insert into Employee (Id, Company, Salary) values ('15', 'C', '2645');
insert into Employee (Id, Company, Salary) values ('16', 'C', '2652');
insert into Employee (Id, Company, Salary) values ('17', 'C', '65');

## SQL
set @current_pos := NULL;
set @mirror := NULL;
SELECT DISTINCT tmp1.Id AS Id,
         tmp1.Company AS Company,
         tmp1.Salary AS Salary
FROM 
    (SELECT tmp.Id,
         tmp.Company,
         tmp.Salary ,
         tmp.rank
    FROM 
        (SELECT Id,
         Company,
         Salary,
         @current_pos :=IF(@mirror = Company,
         @current_pos+1,
         1) AS rank,
         @mirror := Company AS mirrror
        FROM Employee
        ORDER BY  Company, Salary) tmp
        GROUP BY  tmp.Company, tmp.Salary) tmp1
    JOIN 
    (SELECT Company,
         CEIL((COUNT(Company)+1)/2) AS CEILING,
         FLOOR((COUNT(Company)+1)/2) AS FLOOR
    FROM Employee
    GROUP BY  Company) tmp2
    ON (tmp1.Company = tmp2.Company
        AND tmp1.rank = tmp2.CEILING)
        OR (tmp1.Company = tmp2.Company
        AND tmp1.rank = tmp2.FLOOR);

## Suggested Answer
SELECT Id,
         Company,
         Salary
FROM 
    (SELECT e.Id,
         e.Salary,
         e.Company,
         IF(@prev = e.Company,
         @Rank:=@Rank + 1,
         @Rank:=1) AS rank,
         @prev:=e.Company
    FROM Employee e, 
        (SELECT @Rank:=0,
         @prev:=0) AS temp
        ORDER BY  e.Company , e.Salary , e.Id) Ranking
    INNER JOIN 
    (SELECT COUNT(*) AS totalcount,
         Company AS name
    FROM Employee e2
    GROUP BY  e2.Company) companycount
    ON companycount.name = Ranking.Company
WHERE Rank = FLOOR((totalcount + 1) / 2)
        OR Rank = FLOOR((totalcount + 2) / 2);

## Suggested Answer
SELECT Employee.Id,
         Employee.Company,
         Employee.Salary
FROM Employee, Employee alias
WHERE Employee.Company = alias.Company
GROUP BY  Employee.Company , Employee.Salary
HAVING SUM(CASE
    WHEN Employee.Salary = alias.Salary THEN
    1
    ELSE 0 END) >= ABS(SUM(SIGN(Employee.Salary - alias.Salary)))
ORDER BY  Employee.Id;

## Note: In MySQL 5.6, this code runs fine, but if you are using MySQL 5.7+, please use ANY_VALUE(Employee.Id) instead of Employee.Id in the SELECT statement. Otherwise, you may encouter the following error message: Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'Employee.Id' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by.
