# Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be America, Asia and Europe respectively

USE practice;

## Make table
Create table If Not Exists student (name varchar(50), continent varchar(7));
Truncate table student;
insert into student (name, continent) values ('Jane', 'America');
insert into student (name, continent) values ('Pascal', 'Europe');
insert into student (name, continent) values ('Xi', 'Asia');
insert into student (name, continent) values ('Jack', 'America');

## SQL
## set three place markers
## when every continent occurs, then the place marker will increase 1 unit
## and the corresponding name will be recorded below every continent

## Suggested Answer
set @r1 = 0, @r2 = 0, @r3 = 0;
select min(America) America, min(Asia) Asia, min(Europe) Europe FROM
(select case when continent='America' then @r1 :=@r1+1
                  when continent='Asia' then @r2 :=@r2+1
                  when continent='Europe' then @r3 :=@r3+1 end RowNum,
             case when continent='America' then name end America,
             case when continent='Asia' then name end Asia,
             case when continent='Europe' then name end Europe
      from student
      order by name) t
      GROUP BY RowNum ;