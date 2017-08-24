# Write a query to print the sum of all total investment values in 2016

USE practice;

## Make table
CREATE TABLE IF NOT EXISTS insurance (PID INTEGER(11), TIV_2015 NUMERIC(15,2), TIV_2016 NUMERIC(15,2), LAT NUMERIC(5,2), LON NUMERIC(5,2) );
Truncate table insurance;
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('1', '10', '5', '10', '10');
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('2', '20', '20', '20', '20');
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('3', '10', '30', '20', '20');
insert into insurance (PID, TIV_2015, TIV_2016, LAT, LON) values ('4', '10', '40', '40', '40');

## SQL
SELECT ROUND(sum(tmp1.tiv_2016),
        2) AS TIV_2016
FROM 
    (SELECT tiv_2015,
         tiv_2016
    FROM insurance
    GROUP BY  LAT, LON
    HAVING COUNT(TIV_2016)=1) AS tmp1
WHERE tiv_2015 IN 
    (SELECT TIV_2015
    FROM insurance
    GROUP BY  TIV_2015
    HAVING COUNT(TIV_2015) > 1);

## Suggested Answer
SELECT SUM(insurance.TIV_2016) AS TIV_2016
FROM insurance
WHERE insurance.TIV_2015 IN 
    (SELECT TIV_2015
    FROM insurance
    GROUP BY  TIV_2015
    HAVING COUNT(*) > 1 )
        AND CONCAT(LAT, LON) IN 
    (SELECT CONCAT(LAT,
         LON)
    FROM insurance
    GROUP BY  LAT , LON
    HAVING COUNT(*) = 1 );

## Note: Concat the LAT and LON as a whole to represent the location information.
## Note: To decide whether a value in a column is unique or not, we can use GROUP BY and COUNT.