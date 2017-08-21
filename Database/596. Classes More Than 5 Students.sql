## Please list out all classes which have more than or equal to 5 students.

USE practice;

## Make table
Create table If Not Exists courses (student varchar(255), class varchar(255));
Truncate table courses;
Insert into courses (student, class) values ('A','Math');
Insert into courses (student, class) values ('B','English');
Insert into courses (student, class) values ('C','Math');
Insert into courses (student, class) values ('D','Biology');
Insert into courses (student, class) values ('E','Math');
Insert into courses (student, class) values ('F','Computer');
Insert into courses (student, class) values ('G','Math');
Insert into courses (student, class) values ('H','Math');
Insert into courses (student, class) values ('I','Math');

## SQL
SELECT tmp_table.class AS class
FROM (SELECT DISTINCT student, class  ## The students should not be counted duplicate in each course.
      FROM courses) AS tmp_table
GROUP BY tmp_table.class
HAVING COUNT(class) > 4; ## HAVING COUNT(DISTINCT student) > 4;

## Suggest Answer
SELECT class
FROM 
    (SELECT class,
         COUNT(DISTINCT student) AS num
    FROM courses
    GROUP BY  class) AS temp_table
WHERE num >= 5;

## Suggest Answer
SELECT class
FROM courses
GROUP BY  class
HAVING COUNT(DISTINCT student) >= 5;