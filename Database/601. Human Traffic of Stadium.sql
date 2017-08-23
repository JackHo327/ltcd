# Write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).

## Make table
Create table If Not Exists stadium (id int, date DATE NULL, people int);
Truncate table stadium;
insert into stadium (id, date, people) values ('1', '2017-01-01', '10');
insert into stadium (id, date, people) values ('2', '2017-01-02', '109');
insert into stadium (id, date, people) values ('3', '2017-01-03', '150');
insert into stadium (id, date, people) values ('4', '2017-01-04', '99');
insert into stadium (id, date, people) values ('5', '2017-01-05', '145');
insert into stadium (id, date, people) values ('6', '2017-01-06', '1455');
insert into stadium (id, date, people) values ('7', '2017-01-07', '199');
insert into stadium (id, date, people) values ('8', '2017-01-08', '188');

## SQL
SELECT DISTINCT s1.id AS id,
         s1.date AS 'date', s1.people AS people
FROM stadium s1, stadium s2, stadium s3
WHERE ((s1.id - s2.id = 1
        AND s1.id - s3.id = 2
        AND s2.id - s3.id =1) -- t1, t2, t3
        OR (s2.id - s1.id = 1
        AND s2.id - s3.id = 2
        AND s1.id - s3.id =1) -- t2, t1, t3
        OR (s3.id - s2.id = 1
        AND s2.id - s1.id =1
        AND s3.id - s1.id = 2))
        AND s1.people >= 100
        AND s2.people >= 100
        AND s3.people >= 100
ORDER BY  s1.Id;

## Suggest Answer
SELECT DISTINCT t1.*
FROM stadium t1, stadium t2, stadium t3
WHERE t1.people >= 100
        AND t2.people >= 100
        AND t3.people >= 100
        AND ( (t1.id - t2.id = 1
        AND t1.id - t3.id = 2
        AND t2.id - t3.id =1) -- t1, t2, t3
        OR (t2.id - t1.id = 1
        AND t2.id - t3.id = 2
        AND t1.id - t3.id =1) -- t2, t1, t3
        OR (t3.id - t2.id = 1
        AND t2.id - t1.id =1
        AND t3.id - t1.id = 2) -- t3, t2, t1 )
ORDER BY  t1.id;