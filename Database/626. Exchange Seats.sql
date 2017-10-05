-- Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.
-- The column id is continuous increment.
-- Mary wants to change seats for the adjacent students.
# Can you write a SQL query to output the result for Mary?

USE practice;

## Make table
Create table If Not Exists seat(id int, student varchar(255));
Truncate table seat;
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
-- insert into seat (id, student) values ('5', 'Jeames');

## SQL
SELECT
    CASE
    WHEN MOD(s1.id,2) != 0
        AND s1.id != maxx THEN
    s1.id + 1
    WHEN MOD(s1.id,2) != 0
        AND s1.id = maxx THEN
    s1.id
    ELSE s1.id-1
    END AS id, student
FROM seat AS s1, 
    (SELECT MAX(id) AS maxx
    FROM seat) AS s2
ORDER BY  id;

## Suggested Answer
SELECT
    CASE
    WHEN MOD(s1.id,2) != 0
        AND s1.id != maxx THEN
    s1.id + 1
    WHEN MOD(s1.id,2) != 0
        AND s1.id = maxx THEN
    s1.id
    ELSE s1.id-1
    END AS id, student
FROM seat AS s1, 
    (SELECT MAX(id) AS maxx
    FROM seat) AS s2
ORDER BY  id;


## Suggested Answer
SELECT id,
         (id+1)^1-1,
         student
FROM seat;

## "^" bitwise exclusive operate:
## for example: 170^75
            ##  0000 0000 0100 1011 (175's binary version)
            ##  0000 0000 1110 0001 (75's binary version)
            ##  Performing the bitwise exclusive OR operation on these two values
            ##  0000 0000 1010 1010  
            ##  0000 0000 0100 1011  
            ##  -------------------  
            ##  0000 0000 1110 0001 （225's binary version）
## https://docs.microsoft.com/en-us/sql/t-sql/language-elements/bitwise-exclusive-or-transact-sql