# Write a query to print the node id and the type of the node. Sort your output by the node id.

USE practice;

## Make table
Create table If Not Exists tree (id int, p_id int);
Truncate table tree;
insert into tree (id, p_id) values ('1', 'None');
insert into tree (id, p_id) values ('2', '1');
insert into tree (id, p_id) values ('3', '1');
insert into tree (id, p_id) values ('4', '2');
insert into tree (id, p_id) values ('5', '2');

## SQL
SELECT id AS Id,
         IF(p_id IS NULL,
         'Root', IF((id IN 
    (SELECT p_id
    FROM tree) AND p_id IS NOT NULL), 'Inner','Leaf')) AS Type
FROM tree;

## Suggested Answer
SELECT id,
         'Root' AS Type
FROM tree
WHERE p_id IS NULL
UNION
SELECT id,
         'Leaf' AS Type
FROM tree
WHERE id NOT IN 
    (SELECT DISTINCT p_id
    FROM tree
    WHERE p_id IS NOT NULL)
        AND p_id IS NOT NULL
UNION
SELECT id,
         'Inner' AS Type
FROM tree
WHERE id IN 
    (SELECT DISTINCT p_id
    FROM tree
    WHERE p_id IS NOT NULL)
        AND p_id IS NOT NULL
ORDER BY  id;

## Suggested Answer
SELECT id AS `Id`,
    CASE
    WHEN tree.id = 
    (SELECT atree.id
    FROM tree atree
    WHERE atree.p_id IS NULL) THEN
    'Root'
    WHEN tree.id IN 
    (SELECT atree.p_id
    FROM tree atree) THEN
    'Inner'
    ELSE 'Leaf'
    END AS Type
FROM tree
ORDER BY  `Id`;

## Note: CASE:
## CASE case_value
##     WHEN when_value THEN statement_list
##     [WHEN when_value THEN statement_list] ...
##     [ELSE statement_list]
## END CASE
## OR
## CASE
##     WHEN search_condition THEN statement_list
##     [WHEN search_condition THEN statement_list] ...
##     [ELSE statement_list]
## END CASE

## Suggested Answer
SELECT atree.id,
         IF(ISNULL(atree.p_id),
         'Root', IF(atree.id IN 
    (SELECT p_id
    FROM tree), 'Inner','Leaf')) Type
FROM tree atree
ORDER BY  atree.id;