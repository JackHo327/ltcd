# Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

USE practice;

## Make table
Create table If Not Exists Weather (Id int, Date date, Temperature int);
Truncate table Weather;
insert into Weather (Id, Date, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, Date, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, Date, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, Date, Temperature) values ('4', '2015-01-04', '30');

## SQL
SELECT DISTINCT W2.Id 
FROM Weather W2 
JOIN Weather W1
ON W2.Temperature > W1.Temperature AND DATEDIFF(W2.Date, W1.Date) = 1;

# Suggested Answer
SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.date, w.date) = 1
        AND weather.Temperature > w.Temperature;

# Note: DATEDIFF(date1, date2) can be used to calculate the difference between 2 dates == date1 - date2
