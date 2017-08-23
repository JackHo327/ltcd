# Write a query to find the overall acceptance rate of requests rounded to 2 decimals, which is the number of acceptance divide the number of requests.

USE practice;

## Make table
Create table If Not Exists friend_request ( sender_id INT NOT NULL, send_to_id INT NULL, request_date DATE NULL);
Create table If Not Exists request_accepted ( requester_id INT NOT NULL, accepter_id INT NULL, accept_date DATE NULL);
Truncate table friend_request;
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '2', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '3', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('1', '4', '2016/06/01');
insert into friend_request (sender_id, send_to_id, request_date) values ('2', '3', '2016/06/02');
insert into friend_request (sender_id, send_to_id, request_date) values ('3', '4', '2016/06/09');
Truncate table request_accepted;
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '2', '2016/06/03');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('1', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('2', '3', '2016/06/08');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/09');
insert into request_accepted (requester_id, accepter_id, accept_date) values ('3', '4', '2016/06/10');

## SQL
SELECT if(COUNT(sender_id) = 0, # friend_request table is EMPTY
         0.00,
         ROUND(COUNT(DISTINCT requester_id,
         accepter_id)/COUNT(DISTINCT sender_id,
         send_to_id),
        2)) AS accept_rate
FROM request_accepted, friend_request;

## Suggested Answer
SELECT round( ifnull( 
    (SELECT count(*)
    FROM 
        (SELECT DISTINCT requester_id,
         accepter_id
        FROM request_accepted) AS A) / 
            (SELECT count(*)
            FROM 
                (SELECT DISTINCT sender_id,
         send_to_id
                FROM friend_request) AS B), 0) , 2) AS accept_rate;

## Note: IFNULL(exper1,exper2) ==> if the exper1 "IS NOT NULL", then--> exper1, else then --> exper2