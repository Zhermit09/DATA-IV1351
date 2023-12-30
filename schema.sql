CREATE TYPE SKILL AS ENUM ('Beginner','Intermediate','Advanced');
CREATE TYPE LESSTYPE AS ENUM ('Individual','Group','Ensemble');
CREATE TYPE INSTYPE AS ENUM ('Guitar','Bass','Drums');
CREATE TYPE MGENRE AS ENUM ('Gospel', 'Punk', 'Rock');
CREATE TYPE SETTINGS AS ENUM ('SETTINGS');


CREATE TABLE db_settings
(
    id              SETTINGS NOT NULL PRIMARY KEY DEFAULT 'SETTINGS',
    max_lease_count INT      NOT NULL             DEFAULT 2,
    max_rent_period INTERVAL NOT NULL             DEFAULT '12 months'
);
INSERT into db_settings default
values;


------------------------------------------------------------------------------------------------------------------------
CREATE TABLE person
(
    person_id  BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(100)                        NOT NULL,
    last_name  VARCHAR(100)                        NOT NULL,
    ssn        VARCHAR(12)                         NOT NULL UNIQUE
);


CREATE TABLE student
(
    student_id BIGINT NOT NULL PRIMARY KEY REFERENCES person (person_id),
    family_id  BIGINT
);
CREATE SEQUENCE student_family_id_seq;


CREATE TABLE student_instype
(
    student_id      BIGINT  NOT NULL REFERENCES student (student_id),
    instrument_type INSTYPE NOT NULL,
    skill_level     SKILL   NOT NULL,

    PRIMARY KEY (student_id, instrument_type)
);


CREATE TABLE contact_person_student
(
    student_id        BIGINT NOT NULL REFERENCES student (student_id),
    contact_person_id BIGINT NOT NULL REFERENCES person (person_id) ON DELETE CASCADE,

    PRIMARY KEY (student_id, contact_person_id)
);


CREATE TABLE instructor
(
    instructor_id  BIGINT  NOT NULL PRIMARY KEY REFERENCES person (person_id),
    leads_ensemble BOOLEAN NOT NULL
);


CREATE TABLE instructor_instype
(
    instructor_id   BIGINT  NOT NULL REFERENCES instructor (instructor_id),
    instrument_type INSTYPE NOT NULL,

    PRIMARY KEY (instructor_id, instrument_type)
);


------------------------------------------------------------------------------------------------------------------------
CREATE TABLE phone
(
    person_id    BIGINT       NOT NULL REFERENCES person (person_id) ON DELETE CASCADE,
    phone_number VARCHAR(100) NOT NULL,

    PRIMARY KEY (person_id, phone_number)
);


CREATE TABLE email
(
    person_id BIGINT       NOT NULL REFERENCES person (person_id) ON DELETE CASCADE,
    email     VARCHAR(100) NOT NULL,

    PRIMARY KEY (person_id, email)
);


CREATE TABLE address
(
    address_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    city       VARCHAR(100)                        NOT NULL,
    zip        VARCHAR(100)                        NOT NULL,
    street     VARCHAR(100)                        NOT NULL
);


CREATE TABLE person_address
(
    person_id  BIGINT NOT NULL REFERENCES person (person_id) ON DELETE CASCADE,
    address_id BIGINT NOT NULL REFERENCES address (address_id) ON DELETE CASCADE,

    PRIMARY KEY (person_id, address_id)
);


------------------------------------------------------------------------------------------------------------------------
CREATE TABLE instrument_specification
(
    instrument_specification_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    type                        INSTYPE                             NOT NULL,
    brand                       VARCHAR(100)
);


CREATE TABLE instrument
(
    instrument_id               BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    description                 VARCHAR(100),
    instrument_specification_id BIGINT                              NOT NULL REFERENCES instrument_specification (instrument_specification_id)
);


CREATE TABLE rent_price
(
    rent_price_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    price         INT                                 NOT NULL,
    from_date     DATE                                NOT NULL,
    to_date       DATE,
    instrument_id BIGINT                              NOT NULL REFERENCES instrument (instrument_id)
);


CREATE TABLE lease
(
    lease_id      BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    rent_date     DATE                                NOT NULL,
    return_date   DATE                                NOT NULL,
    instrument_id BIGINT                              NOT NULL REFERENCES instrument (instrument_id),
    student_id    BIGINT                              NOT NULL REFERENCES student (student_id),
    rent_price_id BIGINT                              NOT NULL REFERENCES rent_price (rent_price_id)
);
------------------------------------------------------------------------------------------------------------------------


CREATE TABLE payment_description
(
    payment_description_id BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    description            VARCHAR(100)                        NOT NULL
);


CREATE TABLE payment
(
    payment_id             BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    payment_description_id BIGINT                              NOT NULL REFERENCES payment_description (payment_description_id),
    from_date              DATE                                NOT NULL,
    to_date                DATE,
    instructor_pay         INT                                 NOT NULL,
    student_price          INT                                 NOT NULL,
    sibling_discount       DEC(10, 7)                          NOT NULL
);
------------------------------------------------------------------------------------------------------------------------


CREATE TABLE lesson
(
    lesson_id              BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    instructor_id          BIGINT                              NOT NULL REFERENCES instructor (instructor_id),
    lesson_type            LESSTYPE                            NOT NULL,
    skill_level            SKILL                               NOT NULL,
    min_students           INT                                 NOT NULL,
    max_students           INT                                 NOT NULL,
    instrument_type        INSTYPE,
    music_genre            MGENRE,
    payment_description_id BIGINT                              NOT NULL REFERENCES payment_description (payment_description_id)
);


CREATE TABLE enrollment
(
    lesson_id  BIGINT NOT NULL REFERENCES lesson (lesson_id) ON DELETE CASCADE,
    student_id BIGINT NOT NULL REFERENCES student (student_id) ON DELETE CASCADE,

    PRIMARY KEY (lesson_id, student_id)
);
------------------------------------------------------------------------------------------------------------------------


CREATE TABLE time_slot
(
    time_slot_id  BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    date          TIMESTAMP                           NOT NULL,
    duration      INTERVAL                            NOT NULL,
    location      VARCHAR(100)                        NOT NULL,
    lesson_id     BIGINT                              NOT NULL REFERENCES lesson (lesson_id),
    instructor_id BIGINT                              NOT NULL REFERENCES instructor (instructor_id),
    payment_id    BIGINT                              NOT NULL REFERENCES payment (payment_id)
);


CREATE TABLE student_history
(
    student_id   BIGINT NOT NULL REFERENCES student (student_id),
    time_slot_id BIGINT NOT NULL REFERENCES time_slot (time_slot_id),

    PRIMARY KEY (student_id, time_slot_id)
);
------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW available_instrument AS
select instrument.instrument_id,
       instrument_specification.type,
       instrument_specification.brand,
       instrument.description,
       rent_price.price
from instrument
         inner join rent_price ON instrument.instrument_id = rent_price.instrument_id
         inner join instrument_specification ON instrument.instrument_specification_id = instrument_specification.instrument_specification_id
where (rent_price.from_date <= CURRENT_DATE AND CURRENT_DATE <= COALESCE(rent_price.to_date, CURRENT_DATE))
  AND NOT EXISTS
    (select 1
     from lease
     where lease.rent_date <= CURRENT_DATE
       AND CURRENT_DATE <= lease.return_date
       and lease.instrument_id = instrument.instrument_id)
order by instrument_id;