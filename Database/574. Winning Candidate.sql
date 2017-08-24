# Write a sql to find the name of the winning candidate, the above example will return the winner B.

USE practice;

## Make table
Create table If Not Exists Candidate (id int, Name varchar(255));
Create table If Not Exists Vote (id int, CandidateId int);
Truncate table Vote;
insert into Vote (id, CandidateId) values ('1', '2');
insert into Vote (id, CandidateId) values ('2', '4');
insert into Vote (id, CandidateId) values ('3', '3');
insert into Vote (id, CandidateId) values ('4', '2');
insert into Vote (id, CandidateId) values ('5', '5');
Truncate table Candidate;
insert into Candidate (id, Name) values ('1', 'A');
insert into Candidate (id, Name) values ('2', 'B');
insert into Candidate (id, Name) values ('3', 'C');
insert into Candidate (id, Name) values ('4', 'D');
insert into Candidate (id, Name) values ('5', 'E');

## SQL
SELECT c.Name AS Name
FROM 
    (SELECT CandidateId
    FROM Vote
    GROUP BY  CandidateId
    ORDER BY  COUNT(CandidateId) DESC LIMIT 1) AS tmp_vote
JOIN Candidate c
    ON tmp_vote.CandidateId = c.id;

## Suggested Answer
SELECT name AS 'Name'
FROM Candidate
JOIN 
    (SELECT Candidateid
    FROM Vote
    GROUP BY  Candidateid
    ORDER BY  COUNT(*) DESC LIMIT 1) AS winner
WHERE Candidate.id = winner.Candidateid;

## Note: if using outer join, it will create NULL variables when there are no matching pairs.