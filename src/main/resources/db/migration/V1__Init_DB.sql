CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;


-- Education tables

CREATE TABLE country (
    id         INT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    is_allowed BOOLEAN DEFAULT TRUE
);

CREATE TABLE city (
    id         INT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    is_allowed BOOLEAN DEFAULT TRUE,
    country_id INT NOT NULL REFERENCES country(id)
);

CREATE TABLE education_type (
    id    INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE education (
    id                INT PRIMARY KEY,
    title             VARCHAR(255) NOT NULL,
    is_allowed        BOOLEAN DEFAULT TRUE,
    city_id           INT NOT NULL REFERENCES city(id),
    education_type_id INT NOT NULL REFERENCES education_type(id)
);

CREATE TABLE school_class (
    id    INT PRIMARY KEY,
    title INT NOT NULL
);

CREATE TABLE class_letter (
    id    INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE faculty (
    id           INT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    is_allowed   BOOLEAN DEFAULT TRUE,
    education_id INT NOT NULL REFERENCES education(id)
);

CREATE TABLE course (
    id    INT PRIMARY KEY,
    title INT NOT NULL
);

CREATE TABLE grp (
    id         INT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    faculty_id INT NOT NULL REFERENCES faculty(id)
);


-- User tables

CREATE TABLE telegram_account (
    id         INT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    username   VARCHAR(255) NOT NULL,
    photo_url  VARCHAR(255) NOT NULL,
    auth_date  TIMESTAMP NOT NULL,
    hash       VARCHAR(255) NOT NULL
);

CREATE TABLE usr (
    id                  INT PRIMARY KEY,
    telegram_account_id INT NOT NULL REFERENCES telegram_account(id),
    country_id          INT NOT NULL REFERENCES country(id),
    city_id             INT NOT NULL REFERENCES city(id),
    education_type_id   INT NOT NULL REFERENCES education_type(id),
    education_id        INT NOT NULL REFERENCES education(id),
    school_class_id     INT          REFERENCES school_class(id),
    class_letter_id     INT          REFERENCES class_letter(id),
    faculty_id          INT          REFERENCES faculty(id),
    course_id           INT          REFERENCES course(id),
    group_id            INT          REFERENCES grp(id)
);


-- Timetable tables

CREATE TABLE subject (
    id           INT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    education_id INT NOT NULL REFERENCES education(id)
);

CREATE TABLE teacher (
    id           INT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    surname      VARCHAR(255) NOT NULL,
    patronymic   VARCHAR(255) NOT NULL,
    education_id INT NOT NULL REFERENCES education(id)
);

CREATE TABLE classroom (
    id           INT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    education_id INT NOT NULL REFERENCES education(id)
);

CREATE TABLE lesson (
    id            INT PRIMARY KEY,
    first_start   TIMESTAMP NOT NULL,
    first_end     TIMESTAMP,
    second_start  TIMESTAMP,
    second_end    TIMESTAMP NOT NULL,
    serial_number INT NOT NULL
);

CREATE TABLE lesson_subjects (
    lesson_id   INT NOT NULL REFERENCES lesson(id),
    subjects_id INT NOT NULL REFERENCES subject(id)
);

CREATE TABLE lesson_teachers (
    lesson_id   INT NOT NULL REFERENCES lesson(id),
    teachers_id INT NOT NULL REFERENCES teacher(id)
);

CREATE TABLE lesson_classrooms (
    lesson_id     INT NOT NULL REFERENCES lesson(id),
    classrooms_id INT NOT NULL REFERENCES classroom(id)
);

CREATE TABLE timetable (
    id       INT PRIMARY KEY,
    rating   INT NOT NULL,
    user_id  INT NOT NULL REFERENCES usr(id),
    group_id INT NOT NULL REFERENCES grp(id)
);

CREATE TABLE timetable_monday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    monday_lessons_id    INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_tuesday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    tuesday_lessons_id   INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_wednesday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    wednesday_lessons_id INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_thursday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    thursday_lessons_id  INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_friday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    friday_lessons_id    INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_saturday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    saturday_lessons_id  INT NOT NULL REFERENCES lesson(id)
);
CREATE TABLE timetable_sunday_lessons (
    timetable_id         INT NOT NULL REFERENCES timetable(id),
    sunday_lessons_id    INT NOT NULL REFERENCES lesson(id)
);
