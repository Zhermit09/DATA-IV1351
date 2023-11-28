CREATE TYPE SKILL AS ENUM ('Beginner','Intermediate','Advanced');
CREATE TYPE LESSTYPE AS ENUM ('Individual','Group','Ensemble');
CREATE TYPE ROLES AS ENUM ('Contact Person','Student','Instructor');
CREATE TYPE INSTYPE AS ENUM ('Guitar','Bass','Drums');
CREATE TYPE MGENRE AS ENUM ('Punk Rock', 'Gospel Band', 'Pop');

CREATE TABLE schedule
(
    schedule_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY
);


CREATE TABLE time_slot
(
    time_slot_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    date         TIMESTAMP                           NOT NULL,
    duration     INTERVAL(6)                         NOT NULL,
    location     VARCHAR(100)                        NOT NULL,
    schedule_id  BIGINT                              NOT NULL REFERENCES schedule (schedule_id) ON DELETE CASCADE
);


CREATE TABLE person
(
    person_id  BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(100)                        NOT NULL,
    last_name  VARCHAR(100)                        NOT NULL,
    ssn        VARCHAR(12)                         NOT NULL UNIQUE,
    role       ROLES                               NOT NULL
);


CREATE TABLE student
(
    student_id       BIGINT NOT NULL UNIQUE PRIMARY KEY REFERENCES person (person_id) ON DELETE CASCADE,
    skill_level      SKILL  NOT NULL,
    schedule_id      BIGINT REFERENCES schedule (schedule_id) ON DELETE SET NULL,
    sibling_discount DECIMAL(3, 2)
);


CREATE TABLE instructor
(
    instructor_id  BIGINT  NOT NULL UNIQUE PRIMARY KEY REFERENCES person (person_id) ON DELETE CASCADE,
    leads_ensemble BOOLEAN NOT NULL,
    schedule_id    BIGINT  REFERENCES schedule (schedule_id) ON DELETE SET NULL
);


CREATE TABLE contact_details
(
    contact_details_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    person_id          BIGINT                              NOT NULL UNIQUE REFERENCES person (person_id) ON DELETE CASCADE
);


CREATE TABLE phone
(
    contact_details_id BIGINT       NOT NULL REFERENCES contact_details (contact_details_id) ON DELETE CASCADE,
    phone_number       VARCHAR(100) NOT NULL,

    PRIMARY KEY (contact_details_id, phone_number)
);


CREATE TABLE email
(
    contact_details_id BIGINT       NOT NULL REFERENCES contact_details (contact_details_id) ON DELETE CASCADE,
    email              VARCHAR(100) NOT NULL,

    PRIMARY KEY (contact_details_id, email)
);

CREATE TABLE address
(
    address_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    city       VARCHAR(100)                        NOT NULL,
    zip        VARCHAR(100)                        NOT NULL,
    street     VARCHAR(100)                        NOT NULL
);


CREATE TABLE contact_address
(
    contact_details_id BIGINT NOT NULL REFERENCES contact_details (contact_details_id) ON DELETE CASCADE,
    address_id         BIGINT NOT NULL REFERENCES address (address_id) ON DELETE CASCADE,

    PRIMARY KEY (contact_details_id, address_id)
);


CREATE TABLE cperson_student
(
    cperson_id BIGINT NOT NULL REFERENCES person (person_id) ON DELETE CASCADE,
    student_id BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,

    PRIMARY KEY (cperson_id, student_id)
);


CREATE TABLE student_sibling
(
    student_id BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,
    sibling_id BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,

    PRIMARY KEY (student_id, sibling_id)
);


CREATE TABLE student_instype
(
    student_id      BIGINT  NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,
    instrument_type INSTYPE NOT NULL,

    PRIMARY KEY (student_id, instrument_type)
);

CREATE TABLE instructor_instype
(
    instructor_id   BIGINT  NOT NULL REFERENCES instructor (instructor_id) ON DELETE CASCADE,
    instrument_type INSTYPE NOT NULL,

    PRIMARY KEY (instructor_id, instrument_type)
);


CREATE TABLE lesson
(
    lesson_id     BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    instructor_id BIGINT                              NOT NULL REFERENCES instructor (instructor_id) ON DELETE SET NULL,
    lesson_type   LESSTYPE                            NOT NULL,
    skill_level   SKILL                               NOT NULL,
    time_slot_id  BIGINT UNIQUE                       REFERENCES time_slot (time_slot_id) ON DELETE SET NULL
);


CREATE TABLE individual_lesson
(
    lesson_id       BIGINT UNIQUE NOT NULL PRIMARY KEY REFERENCES lesson (lesson_id) ON DELETE CASCADE,
    student_id      BIGINT        NOT NULL REFERENCES student (student_id) ON DELETE SET NULL,
    instrument_type INSTYPE       NOT NULL
);


CREATE TABLE group_lesson
(
    lesson_id       BIGINT UNIQUE NOT NULL PRIMARY KEY REFERENCES lesson (lesson_id) ON DELETE CASCADE,
    min_students    INT           NOT NULL,
    max_students    INT           NOT NULL,
    instrument_type INSTYPE       NOT NULL
);


CREATE TABLE student_glesson
(
    student_id      BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,
    group_lesson_id BIGINT NOT NULL REFERENCES group_lesson (lesson_id) ON DELETE CASCADE,

    PRIMARY KEY (student_id, group_lesson_id)
);


CREATE TABLE ensemble
(
    lesson_id    BIGINT UNIQUE NOT NULL PRIMARY KEY REFERENCES lesson (lesson_id) ON DELETE CASCADE,
    min_students INT           NOT NULL,
    max_students INT           NOT NULL,
    music_genre  MGENRE        NOT NULL
);


CREATE TABLE student_ensemble
(
    student_id  BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,
    ensemble_id BIGINT NOT NULL REFERENCES ensemble (lesson_id) ON DELETE CASCADE,

    PRIMARY KEY (student_id, ensemble_id)
);


CREATE TABLE price_pay
(
    price_pay_id    BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    creation_date   DATE                                NOT NULL,
    valid           BOOLEAN                             NOT NULL,
    role            ROLES                               NOT NULL,
    skill_level     SKILL                               NOT NULL,
    skill_level_pay INT                                 NOT NULL,
    lesson_type     LESSTYPE                            NOT NULL,
    lesson_type_pay INT                                 NOT NULL
);


CREATE TABLE lesson_price_pay
(
    price_pay_id BIGINT NOT NULL REFERENCES price_pay (price_pay_id) ON DELETE CASCADE,
    lesson_id    BIGINT NOT NULL REFERENCES lesson (lesson_id) ON DELETE CASCADE,

    PRIMARY KEY (price_pay_id, lesson_id)
);


CREATE TABLE instrument
(
    instrument_id   BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    type            INSTYPE                             NOT NULL,
    brand           VARCHAR(100),
    total_stock     INT                                 NOT NULL,
    available_stock INT                                 NOT NULL
);


CREATE TABLE lease
(
    lease_id      BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    rent_price    INT                                 NOT NULL,
    rent_date     DATE                                NOT NULL,
    return_date   DATE                                NOT NULL,
    instrument_id BIGINT                              NOT NULL REFERENCES instrument (instrument_id) ON DELETE SET NULL,
    student_id    BIGINT                              NOT NULL REFERENCES student (student_id) ON DELETE SET NULL
);