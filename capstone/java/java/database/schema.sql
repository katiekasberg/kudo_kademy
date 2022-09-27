BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profile(
    id INTEGER NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL DEFAULT '"placeholder.image"'
);
ALTER TABLE
    profile ADD PRIMARY KEY(id);
CREATE TABLE school(
    id INTEGER NOT NULL,
    name INTEGER NOT NULL,
    primary_color VARCHAR(255) NOT NULL DEFAULT '#FF0000',
    secondary_color VARCHAR(255) NOT NULL DEFAULT '#FFFF00',
    logo VARCHAR(255) NOT NULL DEFAULT '"default.image"'
);
ALTER TABLE
    school ADD PRIMARY KEY(id);
CREATE TABLE class(
    id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    teacher_id INTEGER NOT NULL,
    school_id INTEGER NOT NULL,
    description VARCHAR(255) NOT NULL,
    period VARCHAR(255) NOT NULL,
    start_time TIME(0) WITHOUT TIME ZONE NOT NULL,
    end_time TIME(0) WITHOUT TIME ZONE NOT NULL,
    school_year INTEGER NOT NULL
);
ALTER TABLE
    class ADD PRIMARY KEY(id);
CREATE TABLE class_student(
    class_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL
);
ALTER TABLE
    class_student ADD PRIMARY KEY(class_id);
CREATE TABLE parent_student(
    parent_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    relation VARCHAR(255) NOT NULL
);
ALTER TABLE
    parent_student ADD PRIMARY KEY(parent_id);
CREATE TABLE kudo_type(
    id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    value INTEGER NOT NULL
);
ALTER TABLE
    kudo_type ADD PRIMARY KEY(id);
CREATE TABLE kudo_student(
    id INTEGER NOT NULL,
    teacher_id INTEGER NOT NULL,
    student_id INTEGER NOT NULL,
    message VARCHAR(255) NOT NULL,
    type_id INTEGER NOT NULL,
    approval_status VARCHAR(255) NOT NULL DEFAULT 'Pending'
);
ALTER TABLE
    kudo_student ADD PRIMARY KEY(id);
CREATE TABLE discipline_type(
    id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);
ALTER TABLE
    discipline_type ADD PRIMARY KEY(id);
CREATE TABLE discipline_student(id INTEGER NOT NULL);
ALTER TABLE
    discipline_student ADD PRIMARY KEY(id);
CREATE TABLE student(
    id INTEGER NOT NULL,
    school_id INTEGER NOT NULL,
    graduation_year INTEGER NOT NULL
);
ALTER TABLE
    student ADD PRIMARY KEY(id);
CREATE TABLE parent(
    id INTEGER NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);
ALTER TABLE
    parent ADD PRIMARY KEY(id);
CREATE TABLE announcement(
    id INTEGER NOT NULL,
    school_id INTEGER NOT NULL,
    message VARCHAR(255) NOT NULL,
    admin_id INTEGER NOT NULL
);
ALTER TABLE
    announcement ADD PRIMARY KEY(id);
ALTER TABLE
    student ADD CONSTRAINT student_school_id_foreign FOREIGN KEY(school_id) REFERENCES school(id);
ALTER TABLE
    class ADD CONSTRAINT class_teacher_id_foreign FOREIGN KEY(teacher_id) REFERENCES profile(id);
ALTER TABLE
    class ADD CONSTRAINT class_school_id_foreign FOREIGN KEY(school_id) REFERENCES school(id);
ALTER TABLE
    kudo_student ADD CONSTRAINT kudo_student_type_id_foreign FOREIGN KEY(type_id) REFERENCES kudo_type(id);
ALTER TABLE
    parent_student ADD CONSTRAINT parent_student_student_id_foreign FOREIGN KEY(student_id) REFERENCES student(id);
ALTER TABLE
    kudo_student ADD CONSTRAINT kudo_student_teacher_id_foreign FOREIGN KEY(teacher_id) REFERENCES profile(id);
ALTER TABLE
    kudo_student ADD CONSTRAINT kudo_student_student_id_foreign FOREIGN KEY(student_id) REFERENCES profile(id);
ALTER TABLE
    class_student ADD CONSTRAINT class_student_student_id_foreign FOREIGN KEY(student_id) REFERENCES student(id);

COMMIT TRANSACTION;