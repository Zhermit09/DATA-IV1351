CREATE TYPE SKILL AS ENUM ('Beginner','Intermediate','Advanced');
CREATE TYPE LESSTYPE AS ENUM ('Individual','Group','Ensemble');
CREATE TYPE ROLES AS ENUM ('Contact Person','Student','Instructor');
CREATE TYPE INSTYPE AS ENUM ('Guitar','Bass','Drums');
CREATE TYPE MGENRE AS ENUM ('Punk Rock', 'Gospel Band', 'Pop');

CREATE TABLE schedule
(
    schedule_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,

    PRIMARY KEY (schedule_id)
);


CREATE TABLE contact_details
(
    contact_details_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,

    PRIMARY KEY (contact_details_id)
);

CREATE TABLE person
(
    person_id          INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    first_name         VARCHAR(100)                     NOT NULL,
    last_name          VARCHAR(100)                     NOT NULL,
    ssn                VARCHAR(12)                      NOT NULL UNIQUE,
    role               ROLES                            NOT NULL,
    contact_details_id INT                              NOT NULL,

    PRIMARY KEY (person_id),
    FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id)
);


CREATE TABLE student
(
    skill_level      SKILL NOT NULL,
    schedule_id      INT   NOT NULL,
    sibling_discount DECIMAL(10),

    PRIMARY KEY (person_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)
) INHERITS (person);


CREATE TABLE cperson_student
(
    contact_details_id INT NOT NULL,
    student_id         INT NOT NULL,

    PRIMARY KEY (contact_details_id, student_id),
    FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id)
);


CREATE TABLE student_sibling
(
    student_id INT NOT NULL,
    sibling_id INT NOT NULL,

    PRIMARY KEY (student_id, sibling_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id),
    FOREIGN KEY (sibling_id) REFERENCES student (person_id)
);


CREATE TABLE instructor
(
    leads_ensemble BIT(1) NOT NULL,
    schedule_id    INT    NOT NULL,

    PRIMARY KEY (person_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)
) INHERITS (person);


CREATE TABLE instrument_type
(
    instrument_type_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    instrument_type    INSTYPE                          NOT NULL,

    PRIMARY KEY (instrument_type_id)
);


CREATE TABLE student_instructor_instype
(
    instrument_type_id    INT NOT NULL,
    student_instructor_id INT NOT NULL,

    PRIMARY KEY (instrument_type_id, student_instructor_id),
    FOREIGN KEY (instrument_type_id) REFERENCES instrument_type (instrument_type_id),
    FOREIGN KEY (student_instructor_id) REFERENCES student (person_id),
    FOREIGN KEY (student_instructor_id) REFERENCES instructor (person_id)

);


/*CREATE TABLE address
(
    address_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    city       VARCHAR(100)                     NOT NULL,
    zip        VARCHAR(100)                     NOT NULL,
    street     VARCHAR(100)                     NOT NULL
);

ALTER TABLE address
    ADD CONSTRAINT PK_address PRIMARY KEY (address_id);





CREATE TABLE email
(
    email              VARCHAR(100) NOT NULL,
    contact_details_id INT          NOT NULL
);

ALTER TABLE email
    ADD CONSTRAINT PK_email PRIMARY KEY (email, contact_details_id);


CREATE TABLE instrument
(
    instrument_id   INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    type            INSTYPE                          NOT NULL,
    brand           VARCHAR(100),
    total_stock     INT                              NOT NULL,
    available_stock INT                              NOT NULL
);

ALTER TABLE instrument
    ADD CONSTRAINT PK_instrument PRIMARY KEY (instrument_id);






CREATE TABLE phone
(
    phone_number       VARCHAR(100) NOT NULL,
    contact_details_id INT          NOT NULL
);

ALTER TABLE phone
    ADD CONSTRAINT PK_phone PRIMARY KEY (phone_number, contact_details_id);


CREATE TABLE price_pay
(
    instructor_pay_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    role              ROLES                            NOT NULL,
    skill_level       SKILL                            NOT NULL,
    skill_level_pay   INT                              NOT NULL,
    lesson_type       LESSTYPE                         NOT NULL,
    lesson_type_pay   INT                              NOT NULL,
    creation_date     DATE                             NOT NULL,
    valid             BIT(1)                           NOT NULL
);

ALTER TABLE price_pay
    ADD CONSTRAINT PK_price_pay PRIMARY KEY (instructor_pay_id);



CREATE TABLE time_slot
(
    time_slot_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    date         TIMESTAMP                        NOT NULL,
    duration     INTERVAL(10)                     NOT NULL,
    location     VARCHAR(100)                     NOT NULL,
    schedule_id  INT GENERATED ALWAYS AS IDENTITY NOT NULL
);

ALTER TABLE time_slot
    ADD CONSTRAINT PK_time_slot PRIMARY KEY (time_slot_id);


CREATE TABLE contact_address
(
    contact_details_id INT NOT NULL,
    address_id         INT NOT NULL
);

ALTER TABLE contact_address
    ADD CONSTRAINT PK_contact_address PRIMARY KEY (contact_details_id, address_id);






CREATE TABLE lease
(
    lease_id      INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    rent_price    INT                              NOT NULL,
    rent_date     DATE                             NOT NULL,
    return_date   DATE                             NOT NULL,
    instrument_id INT                              NOT NULL,
    student_id    INT                              NOT NULL
);

ALTER TABLE lease
    ADD CONSTRAINT PK_lease PRIMARY KEY (lease_id);


CREATE TABLE lesson
(
    lesson_id     INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    instructor_id INT                              NOT NULL,
    lesson_type   LESSTYPE                         NOT NULL,
    skill_level   SKILL                            NOT NULL,
    time_slot_id  INT                              NOT NULL
);

ALTER TABLE lesson
    ADD CONSTRAINT PK_lesson PRIMARY KEY (lesson_id);


CREATE TABLE lesson_pay
(
    instructor_pay_id INT NOT NULL,
    lesson_id         INT NOT NULL
);

ALTER TABLE lesson_pay
    ADD CONSTRAINT PK_lesson_pay PRIMARY KEY (instructor_pay_id, lesson_id);


CREATE TABLE lesson_price
(
    lesson_id INT NOT NULL
);

ALTER TABLE lesson_price
    ADD CONSTRAINT PK_lesson_price PRIMARY KEY (lesson_id);




CREATE TABLE ensemble
(
    lesson_id    INT    NOT NULL,
    min_students INT    NOT NULL,
    max_students INT    NOT NULL,
    music_genre  MGENRE NOT NULL
);

ALTER TABLE ensemble
    ADD CONSTRAINT PK_ensemble PRIMARY KEY (lesson_id);


CREATE TABLE group_lesson
(
    lesson_id       INT     NOT NULL,
    min_students    INT     NOT NULL,
    max_students    INT     NOT NULL,
    instrument_type INSTYPE NOT NULL
);

ALTER TABLE group_lesson
    ADD CONSTRAINT PK_group_lesson PRIMARY KEY (lesson_id);


CREATE TABLE individual_lesson
(
    lesson_id       INT     NOT NULL,
    student_id      INT     NOT NULL,
    instrument_type INSTYPE NOT NULL
);

ALTER TABLE individual_lesson
    ADD CONSTRAINT PK_individual_lesson PRIMARY KEY (lesson_id);


CREATE TABLE student_elesson
(
    student_id INT NOT NULL,
    lesson_id  INT NOT NULL
);

ALTER TABLE student_elesson
    ADD CONSTRAINT PK_student_elesson PRIMARY KEY (student_id, lesson_id);


CREATE TABLE student_glesson
(
    student_id INT NOT NULL,
    lesson_id  INT NOT NULL
);

ALTER TABLE student_glesson
    ADD CONSTRAINT PK_student_glesson PRIMARY KEY (student_id, lesson_id);


ALTER TABLE email
    ADD CONSTRAINT FK_email_0 FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id);


ALTER TABLE person
    ADD CONSTRAINT FK_person_0 FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id);


ALTER TABLE phone
    ADD CONSTRAINT FK_phone_0 FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id);


ALTER TABLE student
    ADD CONSTRAINT FK_student_0 FOREIGN KEY (student_id) REFERENCES person (person_id);
ALTER TABLE student
    ADD CONSTRAINT FK_student_1 FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id);


ALTER TABLE student_sibling
    ADD CONSTRAINT FK_student_sibling_0 FOREIGN KEY (student_id) REFERENCES student (student_id);
ALTER TABLE student_sibling
    ADD CONSTRAINT FK_student_sibling_1 FOREIGN KEY (sibling_id) REFERENCES student (student_id);


ALTER TABLE time_slot
    ADD CONSTRAINT FK_time_slot_0 FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id);


ALTER TABLE contact_address
    ADD CONSTRAINT FK_contact_address_0 FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id);
ALTER TABLE contact_address
    ADD CONSTRAINT FK_contact_address_1 FOREIGN KEY (address_id) REFERENCES address (address_id);




ALTER TABLE instructor
    ADD CONSTRAINT FK_instructor_0 FOREIGN KEY (instructor_id) REFERENCES person (person_id);
ALTER TABLE instructor
    ADD CONSTRAINT FK_instructor_1 FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id);


ALTER TABLE lease
    ADD CONSTRAINT FK_lease_0 FOREIGN KEY (instrument_id) REFERENCES instrument (instrument_id);
ALTER TABLE lease
    ADD CONSTRAINT FK_lease_1 FOREIGN KEY (student_id) REFERENCES student (student_id);


ALTER TABLE lesson
    ADD CONSTRAINT FK_lesson_0 FOREIGN KEY (instructor_id) REFERENCES instructor (instructor_id);
ALTER TABLE lesson
    ADD CONSTRAINT FK_lesson_1 FOREIGN KEY (time_slot_id) REFERENCES time_slot (time_slot_id);


ALTER TABLE lesson_pay
    ADD CONSTRAINT FK_lesson_pay_0 FOREIGN KEY (instructor_pay_id) REFERENCES price_pay (instructor_pay_id);
ALTER TABLE lesson_pay
    ADD CONSTRAINT FK_lesson_pay_1 FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id);


ALTER TABLE lesson_price
    ADD CONSTRAINT FK_lesson_price_0 FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id);





ALTER TABLE ensemble
    ADD CONSTRAINT FK_ensemble_0 FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id);


ALTER TABLE group_lesson
    ADD CONSTRAINT FK_group_lesson_0 FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id);


ALTER TABLE individual_lesson
    ADD CONSTRAINT FK_individual_lesson_0 FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id);
ALTER TABLE individual_lesson
    ADD CONSTRAINT FK_individual_lesson_1 FOREIGN KEY (student_id) REFERENCES student (student_id);


ALTER TABLE student_elesson
    ADD CONSTRAINT FK_student_elesson_0 FOREIGN KEY (student_id) REFERENCES student (student_id);
ALTER TABLE student_elesson
    ADD CONSTRAINT FK_student_elesson_1 FOREIGN KEY (lesson_id) REFERENCES ensemble (lesson_id);


ALTER TABLE student_glesson
    ADD CONSTRAINT FK_student_glesson_0 FOREIGN KEY (student_id) REFERENCES student (student_id);
ALTER TABLE student_glesson
    ADD CONSTRAINT FK_student_glesson_1 FOREIGN KEY (lesson_id) REFERENCES group_lesson (lesson_id);

*/
