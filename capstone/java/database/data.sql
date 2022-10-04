BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('admin1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('admin2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('admin3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) VALUES ('teacher1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('teacher2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('teacher3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('teacher4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');

INSERT INTO users (username,password_hash,role) VALUES ('student1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student5','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student6','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student7','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student8','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student9','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('student10','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');

INSERT INTO users (username,password_hash,role) VALUES ('parent1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('parent2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('parent3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');
INSERT INTO users (username,password_hash,role) VALUES ('parent4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PARENT');


INSERT INTO profile (id, first_name, last_name, email) VALUES (1001, 'Theo', 'Mills', 'admin1@school.com');
INSERT INTO profile (id, first_name, last_name, email, image) VALUES (1002, 'Linette', 'Putnam', 'admin2@school.com', 'https://images.pexels.com/photos/1024311/pexels-photo-1024311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1003, 'JaMarcus', 'Meisner', 'admin3@school.com');

INSERT INTO profile (id, first_name, last_name, email) VALUES (1004, 'Lynda', 'Dodson', 'teacher1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1005, 'Nadia', 'Campana', 'teacher2@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1006, 'Fynn', 'Hopkins', 'teacher3@school.com');
INSERT INTO profile (id, first_name, last_name, email, image) VALUES (1007, 'Brian', 'Smets', 'teacher4@school.com', 'https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');

INSERT INTO profile (id, first_name, last_name, email) VALUES (1008, 'Isabel', 'Glenn', 'student1@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1009, 'Wendy', 'Hargrave', 'student2@school.com');
INSERT INTO profile (id, first_name, last_name, email, image) VALUES (1010, 'Kalum', 'Ortiz', 'student3@school.com', 'https://img.freepik.com/free-photo/smiling-happy-boy-pointing-fingers-up-copyspace_171337-16394.jpg?w=1380&t=st=1664564323~exp=1664564923~hmac=f0170cd87238a8c28b87a7c771c72f68ee88715f0932333a8f162b9e4c8a12da');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1011, 'Joseph', 'Farley', 'student4@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1012, 'Mariya', 'Mcgrath', 'student5@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1013, 'Jillian', 'Glenn', 'student6@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1014, 'Anil', 'Key', 'student7@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1015, 'Tyrique', 'Cline', 'student8@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1016, 'Gabriella', 'Morikawa', 'student9@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1017, 'Marianna', 'Millington', 'student10@school.com');

INSERT INTO profile (id, first_name, last_name, email, image) VALUES (1018, 'Miles', 'Millington', 'parent1@school.com', 'https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1019, 'Kim', 'Millington', 'parent2@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1020, 'Janet', 'Glenn', 'parent3@school.com');
INSERT INTO profile (id, first_name, last_name, email) VALUES (1021, 'Dan', 'Ortiz', 'parent4@school.com');


INSERT INTO school (name) VALUES ('Cypress Hill Middle School');
INSERT INTO school (name) VALUES ('Cypress Hill High School');


INSERT INTO student (id, school_id, graduation_year) VALUES (1008, 1, 2028);
INSERT INTO student (id, school_id, graduation_year) VALUES (1009, 1, 2027);
INSERT INTO student (id, school_id, graduation_year) VALUES (1010, 1, 2027);
INSERT INTO student (id, school_id, graduation_year) VALUES (1011, 1, 2028);
INSERT INTO student (id, school_id, graduation_year) VALUES (1012, 1, 2029);
INSERT INTO student (id, school_id, graduation_year) VALUES (1013, 2, 2023);
INSERT INTO student (id, school_id, graduation_year) VALUES (1014, 2, 2024);
INSERT INTO student (id, school_id, graduation_year) VALUES (1015, 2, 2025);
INSERT INTO student (id, school_id, graduation_year) VALUES (1016, 2, 2025);
INSERT INTO student (id, school_id, graduation_year) VALUES (1017, 2, 2024);


INSERT INTO parent (id, phone_number, address) VALUES (1018, '1111111111', '1 Address St Town, State 11111');
INSERT INTO parent (id, phone_number, address) VALUES (1019, '2222222222', '2 Address St Town, State 11111');
INSERT INTO parent (id, phone_number, address) VALUES (1020, '2222222222', '2 Address St Town, State 11111');
INSERT INTO parent (id, phone_number, address) VALUES (1021, '4444444444', '3 Address St Town, State 11111');


INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('8th Grade Math', 'Math', 1005, 1, '8th Grade Math with Ms. Campana', 'Period 1', '08:00:00', '09:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('7th Grade Social Studies', 'Social Studies', 1007, 1, '7th Grade Social Studies with Mr. Smets', 'Period 1', '08:00:00', '09:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Mixed Media 1', 'Art', 1004, 2, 'Mixed Media Art (all grades) with Mrs. Dodson', 'Period 1', '08:00:00', '09:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Honors Bio', 'Biology', 1006, 2, 'Honors Biology with Mr. Hopkins', 'Period 2', '09:00:00', '10:00:00', 2023);
INSERT INTO class_info (name, subject, teacher_id, school_id, description, period, start_time, end_time, school_year) VALUES ('Honors Bio', 'Biology', 1006, 2, 'Honors Biology with Mr. Hopkins', 'Period 3', '10:00:00', '11:00:00', 2023);


INSERT INTO class_info_student (class_id, student_id) VALUES (1, 1009);
INSERT INTO class_info_student (class_id, student_id) VALUES (1, 1010);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 1008);
INSERT INTO class_info_student (class_id, student_id) VALUES (2, 1011);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 1013);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 1014);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 1015);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 1016);
INSERT INTO class_info_student (class_id, student_id) VALUES (3, 1017);
INSERT INTO class_info_student (class_id, student_id) VALUES (4, 1014);
INSERT INTO class_info_student (class_id, student_id) VALUES (4, 1017);
INSERT INTO class_info_student (class_id, student_id) VALUES (5, 1015);
INSERT INTO class_info_student (class_id, student_id) VALUES (5, 1016);


INSERT INTO parent_student (parent_id, student_id, relation) VALUES (1018, 1017, 'Father');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (1019, 1017, 'Mother');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (1020, 1008, 'Grandmother');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (1020, 1013, 'Grandmother');
INSERT INTO parent_student (parent_id, student_id, relation) VALUES (1021, 1010, 'Father');


INSERT INTO kudo_type (name, description, value) VALUES ('Help a Classmate', 'Lend a helping hand to a classmate.', 10);
INSERT INTO kudo_type (name, description, value) VALUES ('Do a Good Deed', 'Do something kind for someone!', 10);
INSERT INTO kudo_type (name, description, value) VALUES ('Extra Credit', 'Go above and beyond on an assignment!', 5);


INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (1004, 1013, 'Great job helping Arthur figure out how to prep his supplies!', 1);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (1004, 1013, 'Wow, Jillian put in 5 outside hours of work making her sculpture look amazing!', 3);
INSERT INTO kudo_student (teacher_id, student_id, message, type_id) VALUES (1004, 1017, 'Thanks for all of the wonderful compliments you gave to other students! You really made them feel special!', 2);

--INSERT INTO discipline_type () VALUES ();
--
--INSERT INTO discipline student () VALUES ();
--
INSERT INTO announcement (school_id, message, admin_id) VALUES (1, 'Two weeks until the next check-in! Get out there and show your teachers all the good deeds you can do!', 1001);
INSERT INTO announcement (message, admin_id) VALUES ('Attention all Students and Parents! Report cards will be going out next Monday!', 1002);

COMMIT TRANSACTION;