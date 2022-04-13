INSERT INTO "task"
("id", "title"      , "description"                   , "active", "date"               , "importance") VALUES
(1   , 'Write essay', 'Java programming language'     , TRUE    , '2022-06-30 16:30:00', 0.8         ),
(2   , 'Pass exam'  , 'Web-programming'               , TRUE    , '2022-06-30 12:45:00', 1.0         ),
(3   , 'Read book'  , 'Clean code (Robert C. Martin)' , FALSE   , '2021-11-30 13:00:00', 0.5         ),
(4   , 'Do lab work', 'Web-programming: write SQL'    , TRUE    , '2022-04-30 11:15:00', 0.8         ),
(5   , 'Do exercise', 'Mathematics: solve equation'   , FALSE   , '2022-02-25 08:20:00', 0.7         ),
(6   , 'Do test'    , 'Mathematics: solving equations', TRUE    , '2022-02-25 17:05:00', 0.8         );
SELECT setval('task_id_seq', 6);
