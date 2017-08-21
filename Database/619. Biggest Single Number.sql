# Write a SQL query to find the biggest number, which only appears once.

USE practice;

## Make table
Create table If Not Exists number (num int);
Truncate table number;
insert into number (num) values ('8');
insert into number (num) values ('8');
insert into number (num) values ('3');
insert into number (num) values ('3');
insert into number (num) values ('1');
insert into number (num) values ('4');
insert into number (num) values ('5');
insert into number (num) values ('6');

## SQL
SELECT MAX(num) AS num
FROM 
    (SELECT num,
         COUNT(num) freq
    FROM number
    GROUP BY  num) AS tmp_table
WHERE freq = 1;

## Suggest Answer
SELECT MAX(num) AS num
FROM 
    (SELECT num
    FROM number
    GROUP BY  num
    HAVING COUNT(num) = 1) AS t;

## Note: WHERE will filter the data first, then do other actions such grouping; HAVING will be called after grouping