BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('student1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('teacher1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('parent1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('admin1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('student2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student5','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student6','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student7','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('parent2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('parent3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('teacher2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('teacher3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');

INSERT INTO profile (id, first_name, last_name, email) VALUES (1, 'StudentF1', 'StudentL1', 'student1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (2, 'TeacherF1', 'TeacherL1', 'teacher1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (3, 'ParentF1', 'ParentL1', 'parent1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (4, 'AdminF1', 'AdminL1', 'admin1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (5, 'StudentF2', 'StudentL2', 'student2@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (6, 'StudentF3', 'StudentL3', 'student3@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (7, 'StudentF4', 'StudentL4', 'student4@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (8, 'StudentF5', 'StudentL5', 'student5@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (9, 'StudentF6', 'StudentL6', 'student6@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (10, 'StudentF7', 'StudentL7', 'student7@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (11, 'ParentF2', 'ParentL2', 'parent2@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (12, 'ParentF3', 'ParentL3', 'parent3@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (13, 'TeacherF2', 'TeacherL2', 'teacher2@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (14, 'TeacherF3', 'TeacherL3', 'teacher3@school.com');


INSERT INTO school (name) VALUES ('School1');

INSERT INTO student (id, school_id, graduation_year) VALUES (1, 1, 2025);
INSERT INTO student (id, school_id, graduation_year) VALUES (5, 1, 2024);
INSERT INTO student (id, school_id, graduation_year) VALUES (6, 1, 2026);
INSERT INTO student (id, school_id, graduation_year) VALUES (7, 1, 2025);
INSERT INTO student (id, school_id, graduation_year) VALUES (8, 1, 2025);
INSERT INTO student (id, school_id, graduation_year) VALUES (9, 1, 2026);
INSERT INTO student (id, school_id, graduation_year) VALUES (10, 1, 2025);

INSERT INTO parent (id, phone_number, address) VALUES (3, '1111111111', '1 Address St Town, State 11111');
INSERT INTO parent (id, phone_number, address) VALUES (11, '2222222222', '2 Address St Town, State 11111');
INSERT INTO parent (id, phone_number, address) VALUES (12, '3333333333', '3 Address St Town, State 11111');

INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Class1', 'Subject1', 2, 1, 'This is the class 1 description', 'Period1', '08:00:00', '09:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Class2', 'Subject1', 13, 1, 'This is the class 2 description', 'Period2', '09:00:00', '10:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Class3', 'Subject2', 13, 1, 'This is the class 3 description', 'Period3', '10:00:00', '11:00:00', 2023);

INSERT INTO class_info_student (class_id, student_id) VALUES (1, 1);
INSERT INTO class_info_student (class_id, student_id) VALUES (1, 5);
INSERT INTO class_info_student (class_id, student_id) VALUES (1, 6);
INSERT INTO class_info_student (class_id, student_id) VALUES (1, 7);
INSERT INTO class_info_student (class_id, student_id) VALUES (1, 8);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 1);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 5);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 6);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 7);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 8);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 9);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 5);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 6);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 7);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 10);

INSERT INTO parent_student (parent_id, student_id, relation) VALUES (3, 1, 'Mother');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (11, 5, 'Father');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (11, 6, 'Father');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (12, 8, 'Other');

INSERT INTO kudo_type (name, description, value) VALUES ('KudoType1', 'This is the Kudo Type 1 description', 10);
INSERT INTO kudo_type (name, description, value) VALUES ('KudoType2', 'This is the Kudo Type 2 description', 3);
INSERT INTO kudo_type (name, description, value) VALUES ('KudoType3', 'This is the Kudo Type 3 description', 20);

INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (2, 1, 'This is the kudo comment 1 message', 1);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (2, 5, 'This is the kudo comment 2 message', 1);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (13, 8, 'This is the kudo comment 3 message', 2);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (13, 7, 'This is the kudo comment 4 message', 2);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (14, 7, 'This is the kudo comment 5 message', 3);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (14, 7, 'This is the kudo comment 6 message', 2);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (2, 1, 'This is the kudo comment 7 message', 2);

--INSERT INTO discipline_type () VALUES ();
--
--INSERT INTO discipline student () VALUES ();
--
--INSERT INTO announcement () VALUES ();

COMMIT TRANSACTION;