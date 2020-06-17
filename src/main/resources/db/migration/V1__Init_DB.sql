CREATE TABLE usr (
    id INT PRIMARY KEY,
    telegram_id INT NOT NULL UNIQUE,
    country_id INT NOT NULL,
    city_id INT NOT NULL,
    edu_type_id INT NOT NULL,
    edu_id INT NOT NULL,
    school_class_id INT,
    class_letter_id INT,
    faculty_id INT,
    group_id INT,
    admin_role_id INT NOT NULL
);

CREATE TABLE edu_type (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
