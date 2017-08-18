# Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

USE practice;

## Make table
Create table If Not Exists Person (PersonId int, FirstName varchar(255), LastName varchar(255));
Create table If Not Exists Address (AddressId int, PersonId int, City varchar(255), State varchar(255));
Truncate table Person;
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen');
Truncate table Address;
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York');

## SQL
SELECT FirstName,
         LastName,
         City,
         State
FROM Person
LEFT JOIN Address
    ON Person.PersonId=Address.PersonId;

## Suggested Answer
SELECT FirstName,
         LastName,
         City,
         State
FROM Person
LEFT JOIN Address
    ON Person.PersonId = Address.PersonId;

## Note: Using where clause to filter the records will fail if there is no address information for a person because it will not display the name information.