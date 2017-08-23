# Write a query to find the median of all numbers and name the result as median.

USE practice;

## Make table;
Create table If Not Exists Numbers (Number int, Frequency int);
Truncate table Numbers;
insert into Numbers (Number, Frequency) values ('0', '7');
insert into Numbers (Number, Frequency) values ('1', '1');
insert into Numbers (Number, Frequency) values ('2', '3');
insert into Numbers (Number, Frequency) values ('3', '1');

## SQL
## rank the numbers
## find the middle of sequences number
## If the middle sequence of all numbers
## digit or not:
## if digit: then use ceil() and floor() to get the numbers and then sum them up and divided the whole value by 2 to get the median number
## if not: get the middle number and it's the median


## Suggested Answer
set @r1=0,@r2=0;
select avg(M.Number) median
from
((select Number
from (select *, @r1:=@r1+Frequency CDF
      from Numbers
      order by Number) T
where CDF >=  ceil((@r1+1)/2)
limit 1)
union
(select Number
from (select *, @r2:=@r2+Frequency CDF
      from Numbers
      order by Number) T
where CDF >=  floor((@r2+1)/2)
limit 1)) M