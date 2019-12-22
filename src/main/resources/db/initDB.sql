DROP TABLE IF EXISTS students;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;
CREATE TABLE students
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    full_name VARCHAR NOT NULL,
    faculty   VARCHAR NOT NULL
);
