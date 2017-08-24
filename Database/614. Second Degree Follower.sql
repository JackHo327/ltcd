# Write a sql query to get the amount of each follower’s follower if he/she has one.

USE practice;

## Make table
Create table If Not Exists follow (followee varchar(255), follower varchar(255));
Truncate table follow;
insert into follow (followee, follower) values ('A', 'B');
insert into follow (followee, follower) values ('B', 'C');
insert into follow (followee, follower) values ('B', 'D');
insert into follow (followee, follower) values ('D', 'E');

## SQL
SELECT tmp.followee AS follower,
         COUNT(tmp.followee) AS num
FROM 
    (SELECT DISTINCT f1.follower AS followee,
         f2.follower AS follower
    FROM follow f1
    JOIN follow f2
        ON f1.follower = f2.followee) tmp
GROUP BY  follower
ORDER BY  follower;

## Suggested Answer
## Not available, temporarily