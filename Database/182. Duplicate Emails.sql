# Write a SQL query to find all duplicate emails

USE practice;

## Make table
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');

## SQL
SELECT Email
FROM Person
GROUP BY  Email
HAVING COUNT(Email) > 1;

## Suggest Answer
SELECT Email
FROM 
    (SELECT Email,
         count(Email) AS num
    FROM Person
    GROUP BY  Email ) AS statistic
WHERE num > 1;

## Suggest Answer
SELECT Email
FROM Person
GROUP BY  Email
HAVING count(Email) > 1;