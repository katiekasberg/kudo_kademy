BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('student1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('teacher1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('parent1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('admin1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO profile (id, first_name, last_name, email) VALUES (1, 'StudentF1', 'StudentL1', 'student1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (2, 'TeacherF1', 'TeacherL1', 'teacher1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (3, 'ParentF1', 'ParentL1', 'parent1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (4, 'AdminF1', 'AdminL1', 'admin1@school.com');

INSERT INTO school (name) VALUES ('School1');

INSERT INTO student (id, school_id, graduation_year) VALUES (1, 1, 2025);

INSERT INTO parent (id, phone_number, address) VALUES (3, '1111111111', '1 Address St Town, State 11111');

INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Class1', 'Subject1', 2, 1, 'This is the class description', 'Period1', '08:00:00', '09:00:00', 2023);

INSERT INTO class_info_student (class_id, student_id) VALUES (1, 1);

INSERT INTO parent_student (parent_id, student_id, relation) VALUES (3, 1, 'Mother');

INSERT INTO kudo_type (name, description, value) VALUES ('KudoType1', 'This is the Kudo Type 1 description', 10);

INSERT INTO kudo_student (id, teacher_id, student_id, message, type_id) VALUES (1, 2, 1, 'This is the kudo comment message', 1);

--INSERT INTO discipline_type () VALUES ();
--
--INSERT INTO discipline student () VALUES ();
--
--INSERT INTO announcement () VALUES ();

COMMIT TRANSACTION;
