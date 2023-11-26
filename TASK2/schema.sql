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


CREATE TABLE time_slot
(
    time_slot_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    date         TIMESTAMP                        NOT NULL,
    duration     INTERVAL(6)                      NOT NULL,
    location     VARCHAR(100)                     NOT NULL,
    schedule_id  INT                              NOT NULL,

    PRIMARY KEY (time_slot_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (schedule_id)

);


CREATE TABLE contact_details
(
    contact_details_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,

    PRIMARY KEY (contact_details_id)
);


CREATE TABLE phone
(
    contact_details_id INT          NOT NULL,
    phone_number       VARCHAR(100) NOT NULL,

    PRIMARY KEY (contact_details_id, phone_number),
    FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id)
);


CREATE TABLE email
(
    contact_details_id INT          NOT NULL,
    email              VARCHAR(100) NOT NULL,


    PRIMARY KEY (contact_details_id, email),
    FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id)
);

CREATE TABLE address
(
    address_id INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    city       VARCHAR(100)                     NOT NULL,
    zip        VARCHAR(100)                     NOT NULL,
    street     VARCHAR(100)                     NOT NULL,

    PRIMARY KEY (address_id)
);


CREATE TABLE contact_address
(
    contact_details_id INT NOT NULL,
    address_id         INT NOT NULL,

    PRIMARY KEY (contact_details_id, address_id),
    FOREIGN KEY (contact_details_id) REFERENCES contact_details (contact_details_id),
    FOREIGN KEY (address_id) REFERENCES address (address_id)

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


CREATE TABLE lesson
(
    lesson_id     INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    instructor_id INT                              NOT NULL,
    lesson_type   LESSTYPE                         NOT NULL,
    skill_level   SKILL                            NOT NULL,
    time_slot_id  INT                              NOT NULL,

    PRIMARY KEY (lesson_id),
    FOREIGN KEY (instructor_id) REFERENCES instructor (person_id),
    FOREIGN KEY (time_slot_id) REFERENCES time_slot (time_slot_id)
);


CREATE TABLE individual_lesson
(
    student_id      INT     NOT NULL,
    instrument_type INSTYPE NOT NULL,

    PRIMARY KEY (lesson_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id)

) INHERITS (lesson);


CREATE TABLE group_lesson
(
    min_students    INT     NOT NULL,
    max_students    INT     NOT NULL,
    instrument_type INSTYPE NOT NULL,

    PRIMARY KEY (lesson_id)
) INHERITS (lesson);


CREATE TABLE student_glesson
(
    student_id INT NOT NULL,
    lesson_id  INT NOT NULL,

    PRIMARY KEY (student_id, lesson_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id),
    FOREIGN KEY (lesson_id) REFERENCES group_lesson (lesson_id)
);


CREATE TABLE ensemble
(
    min_students INT    NOT NULL,
    max_students INT    NOT NULL,
    music_genre  MGENRE NOT NULL,

    PRIMARY KEY (lesson_id)
) INHERITS (lesson);


CREATE TABLE student_ensemble
(
    student_id INT NOT NULL,
    lesson_id  INT NOT NULL,

    PRIMARY KEY (student_id, lesson_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id),
    FOREIGN KEY (lesson_id) REFERENCES ensemble (lesson_id)
);


CREATE TABLE price_pay
(
    price_pay_id    INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    creation_date   DATE                             NOT NULL,
    valid           BIT(1)                           NOT NULL,
    role            ROLES                            NOT NULL,
    skill_level     SKILL                            NOT NULL,
    skill_level_pay INT                              NOT NULL,
    lesson_type     LESSTYPE                         NOT NULL,
    lesson_type_pay INT                              NOT NULL,

    PRIMARY KEY (price_pay_id)
);


CREATE TABLE lesson_price_pay
(
    price_pay_id INT NOT NULL,
    lesson_id    INT NOT NULL,

    PRIMARY KEY (price_pay_id, lesson_id),
    FOREIGN KEY (price_pay_id) REFERENCES price_pay (price_pay_id),
    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id)
);


CREATE TABLE instrument
(
    instrument_id   INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    type            INSTYPE                          NOT NULL,
    brand           VARCHAR(100),
    total_stock     INT                              NOT NULL,
    available_stock INT                              NOT NULL,

    PRIMARY KEY (instrument_id)
);


CREATE TABLE lease
(
    lease_id      INT GENERATED ALWAYS AS IDENTITY NOT NULL,
    rent_price    INT                              NOT NULL,
    rent_date     DATE                             NOT NULL,
    return_date   DATE                             NOT NULL,
    instrument_id INT                              NOT NULL,
    student_id    INT                              NOT NULL,

    PRIMARY KEY (lease_id),
    FOREIGN KEY (instrument_id) REFERENCES instrument (instrument_id),
    FOREIGN KEY (student_id) REFERENCES student (person_id)
);