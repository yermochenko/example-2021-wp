DROP TABLE IF EXISTS "task";

CREATE TABLE "task" (
    "id"          SERIAL    PRIMARY KEY,
    "title"       TEXT      NOT NULL,
    "description" TEXT      NOT NULL,
    "active"      BOOLEAN   NOT NULL,
    "date"        TIMESTAMP NOT NULL,
    "importance"  REAL      NOT NULL
);
