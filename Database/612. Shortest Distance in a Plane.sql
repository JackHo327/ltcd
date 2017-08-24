# Write a query to find the shortest distance between these points rounded to 2 decimals.

USE practice;

## Make table
CREATE TABLE If Not Exists point_2d (x INT NOT NULL, y INT NOT NULL);
Truncate table point_2d;
insert into point_2d (x, y) values ('-1', '-1');
insert into point_2d (x, y) values ('0', '0');
insert into point_2d (x, y) values ('-1', '-2');

## SQL
SELECT MIN(ROUND((SQRT(POW((p1.x-p2.x),
        2)+POW((p1.y-p2.y),
        2))),
         2)) AS shortest
FROM point_2d p1, point_2d p2
WHERE p1.x!=p2.x
        OR p1.y!= p2.y;

## Suggested ANswer
SELECT ROUND(SQRT(MIN(POW((p1.x-p2.x),
        2)+POW((p1.y-p2.y),
        2))),
        2) AS shortest
FROM point_2d p1, point_2d p2
WHERE p1.x!=p2.x
        OR p1.y!= p2.y;

## Note: put MIN() inside the SQRT() will reduce the processing time