# Write a query to find the shortest distance between two points in these points.

USE practice;

## Make table
CREATE TABLE If Not Exists point (x INT NOT NULL, UNIQUE INDEX x_UNIQUE (x ASC));
Truncate table point;
insert into point (x) values ('-1');
insert into point (x) values ('0');
insert into point (x) values ('2');

## SQL
SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM point p1, point p2
WHERE p1.x != p2.x;

## Suggested Answer
SELECT MIN(ABS(p1.x - p2.x)) AS shortest
FROM point p1
JOIN point p2
    ON p1.x != p2.x ;