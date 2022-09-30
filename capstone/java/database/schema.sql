BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profile(
    id INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    image VARCHAR(255) NOT NULL DEFAULT '"placeholder.image"',
    CONSTRAINT PK_profile PRIMARY KEY (id),
    CONSTRAINT FK_users_profile FOREIGN KEY (id) REFERENCES users(user_id)
);

CREATE TABLE school(
    id SERIAL,
    name VARCHAR(150),
    primary_color VARCHAR(7) NOT NULL DEFAULT '#FF0000',
    secondary_color VARCHAR(7) NOT NULL DEFAULT '#FFFF00',
    logo VARCHAR(150) NOT NULL DEFAULT '"default.image"',
    CONSTRAINT PK_school PRIMARY KEY (id)
);

CREATE TABLE student(
    id INTEGER NOT NULL,
    school_id INTEGER NOT NULL,
    graduation_year INTEGER NOT NULL,
    CONSTRAINT PK_student PRIMARY KEY (id),
    CONSTRAINT FK_student_school_student FOREIGN KEY(school_id) REFERENCES school(id),
    CONSTRAINT FK_profile_student FOREIGN KEY(id) REFERENCES profile(id)
);

CREATE TABLE parent(
    id INTEGER NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT PK_parent PRIMARY Key (id),
    CONSTRAINT FK_profile_parent FOREIGN KEY(id) REFERENCES profile(id)
);

CREATE TABLE class_info(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    subject VARCHAR(50) NOT NULL,
    teacher_id INTEGER NOT NULL,
    school_id INTEGER NOT NULL,
    description VARCHAR(150) NOT NULL,
    period VARCHAR(15) NOT NULL,
    start_time TIME(0) WITHOUT TIME ZONE NOT NULL,
    end_time TIME(0) WITHOUT TIME ZONE NOT NULL,
    school_year INTEGER NOT NULL,
    CONSTRAINT PK_class PRIMARY KEY (id),
    CONSTRAINT FK_profile_class_info_teacher FOREIGN KEY(teacher_id) REFERENCES profile(id),
    CONSTRAINT FK_profile_class_info_school FOREIGN KEY(school_id) REFERENCES school(id)
);

CREATE TABLE class_info_student(
    class_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    CONSTRAINT PK_class_info_student PRIMARY KEY (class_id, student_id),
    CONSTRAINT FK_student_class_info_student FOREIGN KEY(student_id) REFERENCES student(id),
    CONSTRAINT FK_class_info_student FOREIGN KEY(class_id) REFERENCES class_info(id)
);

CREATE TABLE parent_student(
    parent_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    relation VARCHAR(50) NOT NULL,
    CONSTRAINT PK_parent_student PRIMARY KEY (parent_id, student_id),
    CONSTRAINT FK_student_parent_student FOREIGN KEY(student_id) REFERENCES student(id),
    CONSTRAINT FK_parent_student_student FOREIGN KEY(parent_id) REFERENCES parent(id)
);

CREATE TABLE kudo_type(
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(150) NOT NULL,
    value INTEGER NOT NULL,
    CONSTRAINT PK_kudo_type PRIMARY KEY (id)
);

CREATE TABLE kudo_student(
    id SERIAL,
    teacher_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    message VARCHAR(255) NOT NULL,
    type_id INTEGER NOT NULL,
    approval_status VARCHAR(20) NOT NULL DEFAULT 'Pending',
    CONSTRAINT PK_kudo_student PRIMARY KEY (id),
    CONSTRAINT FK_kudo_type_kudo_student FOREIGN KEY(type_id) REFERENCES kudo_type(id),
    CONSTRAINT FK_profile_kudo_student_teacher FOREIGN KEY(teacher_id) REFERENCES profile(id),
    CONSTRAINT FK_profile_kudo_student_student FOREIGN KEY(student_id) REFERENCES profile(id)
);

--CREATE TABLE discipline_type(
--    id INTEGER NOT NULL,
--    name VARCHAR(50) NOT NULL,
--    description VARCHAR(150) NOT NULL,
--    CONSTRAINT PK_discipline_type PRIMARY KEY (id)
--);
--
--CREATE TABLE discipline_student(
--    id INTEGER NOT NULL,
--    CONSTRAINT PK_discipline_student PRIMARY KEY (id)
--);
--
--CREATE TABLE announcement(
--    id INTEGER NOT NULL,
--    school_id INTEGER NOT NULL,
--    message VARCHAR(255) NOT NULL,
--    admin_id INTEGER NOT NULL,
--    CONSTRAINT PK_announcement PRIMARY KEY (id)
--);

COMMIT TRANSACTION;