CREATE SCHEMA archive;

CREATE TYPE archive.LESSTYPE AS ENUM ('Individual','Group','Ensemble');
CREATE TYPE archive.INSTYPE AS ENUM ('Guitar','Bass','Drums');
CREATE TYPE archive.MGENRE AS ENUM ('Gospel', 'Punk', 'Rock');

CREATE TABLE archive.history
(
    id              BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    lesson_type     LESSTYPE                            NOT NULL,
    music_genre     MGENRE,
    instrument_type INSTYPE,
    price           INT                                 NOT NULL,
    name            VARCHAR(100)                        NOT NULL,
    email           VARCHAR(100)                        NOT NULL
);

CREATE MATERIALIZED VIEW archive.historical_data AS
select lesson.lesson_type,
       lesson.music_genre,
       lesson.instrument_type,
       payment.student_price,
       person.first_name || ' ' || person.last_name AS "Full Name",
       email.email
from public.student_history
         inner join person on person.person_id = student_history.student_id
         inner join time_slot on time_slot.time_slot_id = student_history.time_slot_id
         inner join lesson on time_slot.lesson_id = lesson.lesson_id
         inner join payment on time_slot.payment_id = payment.payment_id
         inner join (select distinct on (email.person_id) * from email) AS email
                    on person.person_id = email.person_id;

INSERT INTO archive.history ( lesson_type, music_genre, instrument_type, price, name,email)
SELECT * FROM archive.historical_data;