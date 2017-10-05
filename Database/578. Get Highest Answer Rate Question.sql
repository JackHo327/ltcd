# 
USE practice;

## make table
Create table If Not Exists survey_log (uid int, action varchar(255), question_id int, answer_id int, q_num int, timestamp int);
Truncate table survey_log;
insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'answer', '285', '123', '1', '1');
insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'answer', '285', '123', '1', '2');
insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'answer', '369', '123', '2', '3');
insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'skip', '369', null, '2', '4');

-- Truncate table survey_log;
-- insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'show', '285', null, '1', '1');
-- insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'answer', '285', '123', '1', '2');
-- insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'answer', '369', '123', '2', '3');
-- insert into survey_log (uid, action, question_id, answer_id, q_num, timestamp) values ('5', 'skip', '369', null, '2', '4');

select * from survey_log;

SELECT question_id as survey_log
FROM
(
    SELECT question_id,
         SUM(case when action="answer" THEN 1 ELSE 0 END) as num_answer,
        SUM(case when action="show" THEN 1 ELSE 0 END) as num_show    
    FROM survey_log
    GROUP BY question_id
) as tbl
ORDER BY (num_answer / num_show) DESC 
LIMIT 1;

SELECT k.question_id
FROM 
    (SELECT *,
         if(num_answer > num_show,
         num_answer,
         num_answer/num_show) divids
    FROM 
        (SELECT question_id,
         SUM(case
            WHEN action="answer" THEN
            1
            ELSE 0 END) AS num_answer, SUM(case
            WHEN action="show" THEN
            1
            ELSE 0 END) AS num_show
        FROM survey_log
        GROUP BY  question_id ) AS tbl
        ORDER BY  divids DESC) AS k
    WHERE k.divids = 
    (SELECT max(p.divids)
    FROM 
        (SELECT *,
         if(num_answer > num_show,
         num_answer,
         num_answer/num_show) AS divids
        FROM 
            (SELECT question_id,
         SUM(case
                WHEN action="answer" THEN
                1
                ELSE 0 END) AS num_answer, SUM(case
                WHEN action="show" THEN
                1
                ELSE 0 END) AS num_show
            FROM survey_log
            GROUP BY  question_id ) AS tb1
            ORDER BY  divids DESC) AS p);

## Suggested Answer
## Bad question