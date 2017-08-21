# Write a SQL query to find all numbers that appear at least three times consecutively.

USE practice;

## Make table
Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

## SQL
SELECT DISTINCT tmp1.ConsecutiveNums
FROM 
    (SELECT l1.Id,
         l1.Num AS ConsecutiveNums
    FROM Logs l1
    JOIN logs l2
        ON l1.Num = l2.Num
            AND l1.Id - l2.Id = -1 ) tmp1
JOIN 
    (SELECT l1.Id,
         l1.Num AS ConsecutiveNums
    FROM Logs l1
    JOIN logs l2
        ON l1.Num = l2.Num
            AND l1.Id - l2.Id = -1 ) tmp2
    ON tmp1.ConsecutiveNums = tmp2.ConsecutiveNums
        AND tmp1.Id - tmp2.Id = -1;

## Suggested Answer
SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3 ## create 3 tables
WHERE l1.Id = l2.Id - 1
        AND l2.Id = l3.Id - 1
        AND l1.Num = l2.Num
        AND l2.Num = l3.Num ;