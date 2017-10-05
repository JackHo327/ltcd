# query all the consecutive available seats order by the seat_id using the following cinema table

USE practice;

## make table
Create table If Not Exists cinema (seat_id int primary key auto_increment, free bool);
Truncate table cinema;
insert into cinema (seat_id, free) values ('1', '1');
insert into cinema (seat_id, free) values ('2', '0');
insert into cinema (seat_id, free) values ('3', '1');
insert into cinema (seat_id, free) values ('4', '1');
insert into cinema (seat_id, free) values ('5', '1');

## SQL 
SELECT DISTINCT c1.seat_id AS seat_id
FROM cinema c1, cinema c2
WHERE c1.free = 1
        AND c2.free = 1
        AND (c1.seat_id - c2.seat_id = 1
        OR c2.seat_id - c1.seat_id = 1)
ORDER BY  seat_id;

## Suggested Answer
SELECT DISTINCT a.seat_id
FROM cinema a
JOIN cinema b
    ON abs(a.seat_id - b.seat_id) = 1
        AND a.free = true
        AND b.free = true
ORDER BY  a.seat_id;