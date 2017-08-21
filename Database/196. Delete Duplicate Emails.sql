# Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.

USE practice;

## Make table
Create Table If Not Exists Person (Id int, Email varchar(255));
Truncate Person;
Insert into Person (Id,Email) values ('1','John@example.com'), ('2','bob@example.com'),('3','John@example.com');

## SQL
DELETE p1
FROM Person AS p1, Person p2
WHERE p1.Email = p2.Email
        AND p1.Id > p2.Id;

## Suggested Answer
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;

# DELETE [WHEN JOIN, THERE SHOULD BE TABLE] FROM [TABLE(S)] WHERE [];
# DELETE FROM [TABLE(S)] WHERE [];