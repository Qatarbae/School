-- Создание схемы
CREATE SCHEMA IF NOT EXISTS school;

-- Создание таблицы role в схеме "school"
CREATE TABLE IF not exists school.role (
                             id SERIAL PRIMARY KEY,
                             role_name VARCHAR(255) NOT NULL
);

-- Создание таблицы user в схеме "school"
CREATE TABLE IF not exists school.user (
                             id SERIAL PRIMARY KEY,
                             full_name VARCHAR(255) NOT NULL,
                             login VARCHAR(100) UNIQUE NOT NULL,
                             password VARCHAR(255) NOT NULL,
                             role_id INT UNIQUE NOT NULL,
                             FOREIGN KEY (role_id) REFERENCES school.role(id)
);

-- Создание таблицы course
CREATE TABLE IF not exists school.course (
                               id SERIAL PRIMARY KEY,
                               course_name VARCHAR(255) NOT NULL,
                               description TEXT
);

-- Создание промежуточной таблицы user_course
CREATE TABLE IF not exists school.user_course (
                                    id SERIAL PRIMARY KEY,
                                    user_id INT NOT NULL,
                                    course_id INT NOT NULL,
                                    FOREIGN KEY (user_id) REFERENCES school."user"(id),
                                    FOREIGN KEY (course_id) REFERENCES school.course(id)
);
-- Создание таблицы module
CREATE TABLE IF not exists school.module (
                               id SERIAL PRIMARY KEY,
                               course_id INT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               description TEXT,
                               FOREIGN KEY (course_id) REFERENCES school.course(id)
);
-- Создание таблицы lesson
CREATE TABLE IF not exists school.lesson (
                               id SERIAL PRIMARY KEY,
                               module_id INT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               description TEXT,
                               FOREIGN KEY (module_id) REFERENCES school.module(id)
);
-- Создание таблицы step
CREATE TABLE IF not exists school.step (
                               id SERIAL PRIMARY KEY,
                               lesson_id INT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               description TEXT,
                               FOREIGN KEY (lesson_id) REFERENCES school.lesson(id)
);
-- Создание таблицы text_step
CREATE TABLE IF not exists school.text_step (
                                  id SERIAL PRIMARY KEY,
                                  step_id INT NOT NULL,
                                  name VARCHAR(255) NOT NULL,
                                  description TEXT,
                                  FOREIGN KEY (step_id) REFERENCES school.step(id)
);

-- Создание таблицы video_step
CREATE TABLE IF not exists school.video_step (
                                   id SERIAL PRIMARY KEY,
                                   step_id INT NOT NULL,
                                   name VARCHAR(255) NOT NULL,
                                   url VARCHAR(255) NOT NULL,
                                   FOREIGN KEY (step_id) REFERENCES school.step(id)
);

-- Создание таблицы test_step
CREATE TABLE IF not exists school.test_step (
                                  id SERIAL PRIMARY KEY,
                                  step_id INT NOT NULL,
                                  name VARCHAR(255) NOT NULL,
                                  FOREIGN KEY (step_id) REFERENCES school.step(id)
);
-- Создание таблицы test_block_step
CREATE TABLE IF not exists school.test_block_step (
                                        id SERIAL PRIMARY KEY,
                                        test_step_id INT NOT NULL,
                                        question TEXT NOT NULL,
                                        one_correct BOOLEAN NOT NULL,
                                        FOREIGN KEY (test_step_id) REFERENCES school.test_step(id)
);
-- Создание таблицы test_option_step
CREATE TABLE IF not exists school.test_option_step (
                                         id SERIAL PRIMARY KEY,
                                         test_block_step_id INT NOT NULL,
                                         option TEXT NOT NULL,
                                         valid BOOLEAN NOT NULL,
                                         FOREIGN KEY (test_block_step_id) REFERENCES school.test_block_step(id)
);
