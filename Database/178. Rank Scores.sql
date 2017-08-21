# Write a SQL query to rank scores.

USE practice;

# Make table
Create table If Not Exists Scores (Id int, Score DECIMAL(3,2));
Truncate table Scores;
insert into Scores (Id, Score) values ('1', '0.00');
insert into Scores (Id, Score) values ('2', '3.65');
insert into Scores (Id, Score) values ('3', '4.0');
insert into Scores (Id, Score) values ('4', '3.85');
insert into Scores (Id, Score) values ('5', '4.0');
insert into Scores (Id, Score) values ('6', '3.65');

## SQL
## cannot deal with 0.00; 0.00; ...
## SET @rank := 0;
## SET @pos := -1;
## SELECT Score,
## CASE WHEN @pos = Score THEN @rank
## WHEN @pos := Score THEN @rank := @rank + 1
## END AS Rank
## FROM Scores
## ORDER BY Score DESC;

SELECT Score,
    (SELECT COUNT(DISTINCT Score)
    FROM Scores
    WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY  Score DESC;

## Another way
SELECT Score,
         @rank := @rank + (@pre <> (@pre := Score)) Rank
FROM Scores, 
    (SELECT @rank := 0,
         @pre := -1) INIT
    ORDER BY  Score DESC;

## http://www.cnblogs.com/grandyang/p/5351611.html