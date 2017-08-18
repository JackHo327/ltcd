# Write a query to return the list of customers NOT referred by the person with id '2'.

USE practice;

## Make table
CREATE TABLE IF NOT EXISTS customer (id INT,name VARCHAR(25),referee_id INT);
Truncate table customer;
insert into customer (id, name, referee_id) values ('1', 'Will', NULL);
insert into customer (id, name, referee_id) values ('2', 'Jane', NULL);
insert into customer (id, name, referee_id) values ('3', 'Alex', '2');
insert into customer (id, name, referee_id) values ('4', 'Bill', NULL);
insert into customer (id, name, referee_id) values ('5', 'Zack', '1');
insert into customer (id, name, referee_id) values ('6', 'Mark', '2');

## SQL
SELECT name
FROM customer
WHERE referee_id != 2
        OR referee_id IS NULL;

## Suggested Answer
SELECT name FROM customer WHERE referee_id <> 2 OR referee_id IS NULL;