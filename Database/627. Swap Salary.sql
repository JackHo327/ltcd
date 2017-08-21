# Swap all f and m values (i.e., change all f values to m and vice versa) with a single update query and no intermediate temp table.

USE practice;

## Make table
create table if not exists salary(id int, name varchar(100), sex char(1), salary int);
Truncate table salary;
insert into salary (id, name, sex, salary) values ('1', 'A', 'm', '2500');
insert into salary (id, name, sex, salary) values ('2', 'B', 'f', '1500');
insert into salary (id, name, sex, salary) values ('3', 'C', 'm', '5500');
insert into salary (id, name, sex, salary) values ('4', 'D', 'f', '500');

## SQL
UPDATE salary SET sex = IF(sex = 'f', 'm','f');

## Suggested Answer
UPDATE salary SET sex =
    CASE sex
    WHEN 'm' THEN 'f'
    ELSE 'm' END;