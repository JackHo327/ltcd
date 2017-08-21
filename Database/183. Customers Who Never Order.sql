# Write a SQL query to find all customers who never order anything.

USE practice;

## Make table
Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');

## SQL
SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN 
    (SELECT o.CustomerId
    FROM Orders o
    JOIN Customers c1 ## Note: JOIN is not necessary, because here could directly use the customerId in Customers
        ON o.CustomerId = c1.Id);

## Suggested Answer
SELECT customers.name AS 'Customers'
FROM customers
WHERE customers.id NOT IN 
    (SELECT customerid
    FROM orders );