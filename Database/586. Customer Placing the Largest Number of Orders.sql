# Query the customer_number from the orders table for the customer who has placed the largest number of orders.

USE practice;

## Make table
Create table If Not Exists orders (order_number Integer, customer_number int);
Truncate table orders;
insert into orders (order_number, customer_number) values (1, 1);
insert into orders (order_number, customer_number) values (2, 2);
## insert into orders (order_number, customer_number) values (3, 2);
insert into orders (order_number, customer_number) values (3, 3);
insert into orders (order_number, customer_number) values (4, 3);

## SQL
SELECT customer_number
FROM orders
GROUP BY customer_number
ORDER BY COUNT(DISTINCT(order_number)) DESC 
LIMIT 1; ## LIMIT: It takes one or two nonnegative numeric arguments, the first of which specifies the offset of the first row to return, and the second specifies the maximum number of rows to return. The offset of the initial row is 0 (not 1). "LIMIT 1 == LIMIT(0,1)"

## Follow up: The SQL below could find all customers have the largest number of orders.
SELECT customer_number FROM
    (SELECT customer_number,
         COUNT(DISTINCT(order_number)) AS num_freq
    FROM orders
    GROUP BY  customer_number) AS tmp
WHERE 0 = 
    (SELECT COUNT(DISTINCT(num_freq))
    FROM 
        (SELECT customer_number,
         COUNT(DISTINCT(order_number)) AS num_freq
        FROM orders
        GROUP BY  customer_number) AS tmp1
        WHERE tmp1.num_freq > tmp.num_freq);

## Suggest Answer
SELECT customer_number
FROM orders
GROUP BY  customer_number
ORDER BY  COUNT(*) DESC LIMIT 1;