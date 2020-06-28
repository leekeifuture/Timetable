CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

CREATE TABLE country (
    id         INT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    is_allowed BOOLEAN DEFAULT TRUE
);

CREATE TABLE city (
    id         INT PRIMARY KEY,
    country_id INT NOT NULL REFERENCES country(id),
    title      VARCHAR(255) NOT NULL,
    is_allowed BOOLEAN DEFAULT TRUE
);

CREATE TABLE education_type (
    id    INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE education (
    id                INT PRIMARY KEY,
    city_id           INT NOT NULL REFERENCES city(id),
    education_type_id INT NOT NULL REFERENCES education_type(id),
    title             VARCHAR(255) NOT NULL,
    is_allowed        BOOLEAN DEFAULT TRUE
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
    education_id INT NOT NULL REFERENCES education(id),
    title        VARCHAR(255) NOT NULL,
    is_allowed   BOOLEAN DEFAULT TRUE
);

CREATE TABLE course (
    id    INT PRIMARY KEY,
    title INT NOT NULL
);

CREATE TABLE grp (
    id         INT PRIMARY KEY,
    faculty_id INT NOT NULL REFERENCES faculty(id),
    title      VARCHAR(255) NOT NULL
);

CREATE TABLE usr (
    id                INT PRIMARY KEY,
    telegram_id       INT NOT NULL UNIQUE,
    country_id        INT NOT NULL REFERENCES country(id),
    city_id           INT NOT NULL REFERENCES city(id),
    education_type_id INT NOT NULL REFERENCES education_type(id),
    education_id      INT NOT NULL REFERENCES education(id),
    school_class_id   INT          REFERENCES school_class(id),
    class_letter_id   INT          REFERENCES class_letter(id),
    faculty_id        INT          REFERENCES faculty(id),
    course_id         INT          REFERENCES course(id),
    group_id          INT          REFERENCES grp(id)
);
