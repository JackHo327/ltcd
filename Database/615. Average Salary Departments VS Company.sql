# write a query to display the comparison result (higher/lower/same) of the average salary of employees in a department to the company's average salary

USE practice;

## Make table
Create table If Not Exists salary (id int, employee_id int, amount int, pay_date date);
Create table If Not Exists employee (employee_id int, department_id int);
Truncate table salary;
insert into salary (id, employee_id, amount, pay_date) values ('1', '1', '9000', '2017/03/31');
insert into salary (id, employee_id, amount, pay_date) values ('2', '2', '6000', '2017/03/31');
insert into salary (id, employee_id, amount, pay_date) values ('3', '3', '10000', '2017/03/31');
insert into salary (id, employee_id, amount, pay_date) values ('4', '1', '7000', '2017/02/28');
insert into salary (id, employee_id, amount, pay_date) values ('5', '2', '6000', '2017/02/28');
insert into salary (id, employee_id, amount, pay_date) values ('6', '3', '8000', '2017/02/28');
Truncate table employee;
insert into employee (employee_id, department_id) values ('1', '1');
insert into employee (employee_id, department_id) values ('2', '2');
insert into employee (employee_id, department_id) values ('3', '2');

## SQL
SELECT tmp_department_salary.pay_date AS pay_month,
         tmp_department_salary.department_id AS department_id,
         IF(tmp_comp_salary.monthly_avg_payment = tmp_department_salary.monthly_avg_department_salary,
         'same', IF(tmp_comp_salary.monthly_avg_payment < tmp_department_salary.monthly_avg_department_salary, 'higher', 'lower')) AS comparison
FROM 
    (SELECT SUBSTRING(pay_date,1,7) AS pay_date,
         AVG(amount) AS monthly_avg_payment
    FROM salary
    GROUP BY  SUBSTRING(pay_date,1,7)) tmp_comp_salary
JOIN 
    (SELECT e.department_id,
         SUBSTRING(s.pay_date,1,7) AS pay_date,
         AVG(s.amount) AS monthly_avg_department_salary
    FROM salary s
    JOIN employee e
        ON e.employee_id = s.employee_id
    GROUP BY  SUBSTRING(s.pay_date,1,7), e.department_id) tmp_department_salary
ON tmp_comp_salary.pay_date = tmp_department_salary.pay_date
ORDER BY tmp_department_salary.department_id,tmp_comp_salary.pay_date;

## Suggested Answer
SELECT department_salary.pay_month,
         department_id,
        
    CASE
    WHEN department_avg>company_avg THEN
    'higher'
    WHEN department_avg<company_avg THEN
    'lower'
    ELSE 'same'
    END AS comparison
FROM 
    (SELECT department_id,
         avg(amount) AS department_avg,
         date_format(pay_date,
         '%Y-%m') AS pay_month
    FROM salary
    JOIN employee
        ON salary.employee_id = employee.employee_id
    GROUP BY  department_id, pay_month ) AS department_salary
JOIN 
    (SELECT avg(amount) AS company_avg,
         date_format(pay_date,
         '%Y-%m') AS pay_month
    FROM salary
    GROUP BY  date_format(pay_date, '%Y-%m') ) AS company_salary
    ON department_salary.pay_month = company_salary.pay_month;

## Note: date_format(string, 'date_format') can bring you your ideal date-format
## e.g.: date_format('2017-03-29','%Y-%m') --> '2017-03'