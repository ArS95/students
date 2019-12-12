FROM students;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO students(full_name, faculty)
VALUES ('Олег Олег Олегович', 'machine'),
       ('Генадий Гена Генадьевич', 'medicine'),
       ('Кайсар Кайсар Кайсарович', 'transport'),
       ('Паша Паша Пашевич', 'ingener'),
       ('Сайран Сайран Сайранович', 'social');
