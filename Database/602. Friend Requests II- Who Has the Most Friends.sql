# Write a query to find the the people who has most friends and the most friends number.

USE practice;

# Make table
Create table If Not Exists request_accepted ( requester_id INT NOT NULL, accepter_id INT NULL, accept_date DATE NULL);
Truncate table request_accepted;
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '2', '2016/06/03');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('2', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/09');

# SQL
SELECT id,
         count(id) AS num
FROM 
    (SELECT requester_id AS id
    FROM request_accepted
    UNION
    ALL SELECT accepter_id # UNION will union all the values and then EXCLUDE those duplicated values; UNION ALL will union all the values and keep all the values
    FROM request_accepted AS id) tmp_table # Every derived table must have its own alias
GROUP BY  id
ORDER BY  num DESC 
LIMIT 1;

# Suggested Answer
SELECT ids AS id,
         cnt AS num
FROM 
    (SELECT ids,
         count(*) AS cnt
    FROM 
        (SELECT requester_id AS ids
        FROM request_accepted
        UNION
        allSELECT accepter_id
        FROM request_accepted ) AS tbl1
        GROUP BY  ids ) AS tbl2
    ORDER BY  cnt DESC limit 1;