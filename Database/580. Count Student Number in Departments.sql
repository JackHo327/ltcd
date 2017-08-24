# Write a query to print the respective department name and number of students majoring in each department for all departments in the department table (even ones with no current students).

USE practice;

## Make table
CREATE TABLE IF NOT EXISTS student (student_id int,student_name VARCHAR(45), gender VARCHAR(6), dept_id INT);
CREATE TABLE IF NOT EXISTS department (dept_id int, dept_name VARCHAR(255));
Truncate table department;
insert into department (dept_id, dept_name) values (1, 'Engineering');
insert into department (dept_id, dept_name) values (2, 'Science');
insert into department (dept_id, dept_name) values (3, 'Law');
Truncate table student;
insert into student (student_id, student_name, gender, dept_id) values ('1', 'Jack', 'M', '1');
insert into student (student_id, student_name, gender, dept_id) values ('2', 'Jane', 'F', '1');
insert into student (student_id, student_name, gender, dept_id) values ('3', 'Mark', 'M', '2');

## SQL
SELECT tmp.dept_name AS dept_name,
         IF(tmp.student_id IS NULL,
         0,
         COUNT(tmp.dept_name)) AS student_number
FROM 
    (SELECT d.dept_name,
        d.dept_id,
        s.student_id
    FROM department d
    LEFT JOIN student s
        ON d.dept_id = s.dept_id
    GROUP BY  d.dept_name,s.student_id) tmp
GROUP BY  dept_name
ORDER BY  student_number DESC, dept_name;

## Suggested Answer
SELECT dept_name,
         COUNT(student_id) AS student_number 
FROM department LEFT OUTER
JOIN student
    ON department.dept_id = student.dept_id
GROUP BY  department.dept_name
ORDER BY  student_number DESC , department.dept_name;

## Note: COUNT(student_id) can be directly used here, if the student_id is NULL after the LEFT JOIN, then COUNT() will count it as 0.
