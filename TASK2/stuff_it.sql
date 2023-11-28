
CREATE OR REPLACE PROCEDURE create_address(
    _contact_id BIGINT,
    _city VARCHAR(100),
    _zip VARCHAR(100),
    _street VARCHAR(100))
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO address VALUES (DEFAULT, _city, _zip, _street);

    INSERT INTO contact_address
    VALUES (_contact_id, currval(pg_get_serial_sequence('address', 'address_id')));
END;
$$;


CREATE OR REPLACE PROCEDURE create_contact(
    _person_id BIGINT,
    _phone VARCHAR(100),
    _email VARCHAR(100),
    _city VARCHAR(100),
    _zip VARCHAR(100),
    _street VARCHAR(100))
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO contact_details VALUES (default, _person_id);
    INSERT INTO phone VALUES (currval(pg_get_serial_sequence('contact_details', 'contact_details_id')), _phone);
    INSERT INTO email VALUES (currval(pg_get_serial_sequence('contact_details', 'contact_details_id')), _email);
    CALL create_address(currval(pg_get_serial_sequence('contact_details', 'contact_details_id')), _city, _zip, _street);
END;
$$;


CREATE OR REPLACE PROCEDURE create_student(
    _first_name VARCHAR(100),
    _last_name VARCHAR(100),
    _ssn VARCHAR(12),
    _skill_level SKILL,
    _schedule_id BIGINT,
    _discount DECIMAL(3, 2),
    _phone VARCHAR(100),
    _email VARCHAR(100),
    _city VARCHAR(100),
    _zip VARCHAR(100),
    _street VARCHAR(100),
    _instype INSTYPE[])
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO person VALUES (default, _first_name, _last_name, _ssn, 'Student');
    INSERT INTO student
    VALUES (currval(pg_get_serial_sequence('person', 'person_id')), _skill_level, _schedule_id, _discount);

    CALL create_contact(currval(pg_get_serial_sequence('person', 'person_id')), _phone, _email, _city, _zip, _street);
    CALL add_student_instrument(currval(pg_get_serial_sequence('person', 'person_id')), _instype);
END;
$$;


CREATE OR REPLACE PROCEDURE create_instructor(
    _first_name VARCHAR(100),
    _last_name VARCHAR(100),
    _ssn VARCHAR(12),
    _leads_ensemble BOOLEAN,
    _schedule_id BIGINT,
    _phone VARCHAR(100),
    _email VARCHAR(100),
    _city VARCHAR(100),
    _zip VARCHAR(100),
    _street VARCHAR(100),
    _instype INSTYPE[])
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO person VALUES (default, _first_name, _last_name, _ssn, 'Instructor');
    INSERT INTO instructor
    VALUES (currval(pg_get_serial_sequence('person', 'person_id')), _leads_ensemble, _schedule_id);

    CALL create_contact(currval(pg_get_serial_sequence('person', 'person_id')), _phone, _email, _city, _zip, _street);
    CALL add_instructor_instrument(currval(pg_get_serial_sequence('person', 'person_id')), _instype);
END;
$$;


CREATE OR REPLACE PROCEDURE create_person(
    _first_name VARCHAR(100),
    _last_name VARCHAR(100),
    _ssn VARCHAR(12),
    _role ROLES,
    _phone VARCHAR(100),
    _email VARCHAR(100),
    _city VARCHAR(100),
    _zip VARCHAR(100),
    _street VARCHAR(100))
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO person VALUES (default, _first_name, _last_name, _ssn, _role);
    CALL create_contact(currval(pg_get_serial_sequence('person', 'person_id')), _phone, _email, _city, _zip, _street);
END;
$$;


CREATE OR REPLACE PROCEDURE add_student_instrument(_student_id BIGINT, _instype INSTYPE[])
    LANGUAGE PLPGSQL
AS
$$
DECLARE
    i INSTYPE;
BEGIN
    FOREACH i IN ARRAY _instype
        LOOP
            INSERT INTO student_instype VALUES (_student_id, i);
        END LOOP;
END;
$$;

CREATE OR REPLACE PROCEDURE add_instructor_instrument(_instructor_id BIGINT, _instype INSTYPE[])
    LANGUAGE PLPGSQL
AS
$$
DECLARE
    i INSTYPE;
BEGIN
    FOREACH i IN ARRAY _instype
        LOOP
            INSERT INTO instructor_instype VALUES (_instructor_id, i);
        END LOOP;
END;
$$;


CREATE OR REPLACE PROCEDURE create_ilesson(
    _instructor_id BIGINT,
    _skill SKILL,
    _time_id BIGINT,
    _student_id BIGINT,
    _instype INSTYPE)
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO lesson VALUES (default, _instructor_id, 'Individual', _skill, _time_id);
    INSERT INTO individual_lesson
    VALUES (currval(pg_get_serial_sequence('lesson', 'lesson_id')), _student_id, _instype);
END;
$$;

CREATE OR REPLACE PROCEDURE create_glesson(
    _instructor_id BIGINT,
    _skill SKILL,
    _time_id BIGINT,
    _min_students INT,
    _max_students INT,
    _instype INSTYPE)
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO lesson VALUES (default, _instructor_id, 'Group', _skill, _time_id);
    INSERT INTO group_lesson
    VALUES (currval(pg_get_serial_sequence('lesson', 'lesson_id')), _min_students, _max_students, _instype);
END;
$$;


CREATE OR REPLACE PROCEDURE create_ensemble(
    _instructor_id BIGINT,
    _skill SKILL,
    _time_id BIGINT,
    _min_students INT,
    _max_students INT,
    _music_genre MGENRE)
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    INSERT INTO lesson VALUES (default, _instructor_id, 'Ensemble', _skill, _time_id);
    INSERT INTO ensemble
    VALUES (currval(pg_get_serial_sequence('lesson', 'lesson_id')), _min_students, _max_students, _music_genre);
END;
$$;


DO
$$
    DECLARE
        c_id           BIGINT;
        DECLARE sch_id BIGINT;
        DECLARE s1_id  BIGINT;
        DECLARE s2_id  BIGINT;
        DECLARE i_id   BIGINT;
        DECLARE t1_id  BIGINT;
        DECLARE t2_id  BIGINT;
        DECLARE t3_id  BIGINT;
        DECLARE l1_id  BIGINT;
        DECLARE l2_id  BIGINT;
        DECLARE l3_id  BIGINT;
    BEGIN
        INSERT INTO schedule DEFAULT VALUES;
        sch_id := currval(pg_get_serial_sequence('schedule', 'schedule_id'));

        INSERT INTO time_slot VALUES (default, '2025-01-01 16:00', '1 hour 30 min', 'A101', sch_id);
        t1_id := currval(pg_get_serial_sequence('time_slot', 'time_slot_id'));
        INSERT INTO time_slot VALUES (default, '2025-01-11 13:00', '2 hour 30 min', 'A201', sch_id);
        t2_id := currval(pg_get_serial_sequence('time_slot', 'time_slot_id'));
        INSERT INTO time_slot VALUES (default, '2025-01-21 15:00', '3 hour 20 min', 'A301', sch_id);
        t3_id := currval(pg_get_serial_sequence('time_slot', 'time_slot_id'));


        CALL create_instructor('InstructorA', 'F', '20030502***3', TRUE, sch_id, '2123456789',
                               'instructorA@gmail.two', 'Stockholm', '123 54', 'Gatan 3', '{"Drums","Bass","Guitar"}');
        i_id := currval(pg_get_serial_sequence('person', 'person_id'));

        CALL create_person('ParentA', 'D', '20030502***4', 'Contact Person', '0123456789', 'parentA@gmail.one',
                           'Stockholm', '123 45', 'Gatan 1');
        c_id := currval(pg_get_serial_sequence('person', 'person_id'));
        CALL create_student('StudentA', 'D', '20030502***0', 'Beginner', sch_id, NULL, '0123456789',
                            'studentA@gmail.one', 'Stockholm', '123 45', 'Gatan 1', '{"Drums"}');
        s1_id := currval(pg_get_serial_sequence('person', 'person_id'));
        CALL create_student('StudentB', 'D', '20030502***1', 'Intermediate', sch_id, NULL, '1123456789',
                            'studenB@gmail.one', 'Stockholm', '123 45', 'Gatan 1', '{"Bass"}');
        s2_id := currval(pg_get_serial_sequence('person', 'person_id'));

        INSERT INTO cperson_student VALUES (c_id, s1_id);
        INSERT INTO cperson_student VALUES (c_id, s2_id);
        INSERT INTO student_sibling VALUES (s1_id, s2_id);

        CALL create_ilesson(i_id, 'Beginner', t1_id, s1_id, 'Drums');
        l1_id := currval(pg_get_serial_sequence('lesson', 'lesson_id'));
        CALL create_glesson(i_id, 'Intermediate', t2_id, 1, 2, 'Bass');
        l2_id := currval(pg_get_serial_sequence('lesson', 'lesson_id'));
        CALL create_ensemble(i_id, 'Advanced', t3_id, 1, 2, 'Punk Rock');
        l3_id := currval(pg_get_serial_sequence('lesson', 'lesson_id'));

        CALL create_person('ParentB', 'E', '20030502***5', 'Contact Person', '0123456789', 'parentA@gmail.one',
                           'Stockholm', '123 46', 'Gatan 2');
        c_id := currval(pg_get_serial_sequence('person', 'person_id'));
        CALL create_student('StudentC', 'E', '20030502***2', 'Advanced', sch_id, NULL, '2123456789',
                            'studenC@gmail.one', 'Stockholm', '123 46', 'Gatan 2', '{"Guitar"}');
        s1_id := currval(pg_get_serial_sequence('person', 'person_id'));

        INSERT INTO cperson_student VALUES (c_id, s1_id);

        INSERT INTO student_glesson VALUES (s1_id, l2_id);
        INSERT INTO student_glesson VALUES (s2_id, l2_id);
        INSERT INTO student_ensemble VALUES (s1_id, l3_id);
        INSERT INTO student_ensemble VALUES (s2_id, l3_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', FALSE, 'Student', 'Beginner', 100, 'Individual', 100);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l1_id);
        INSERT INTO price_pay VALUES (default, '2024-11-21', TRUE, 'Student', 'Beginner', 110, 'Individual', 110);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l1_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', FALSE, 'Instructor', 'Beginner', 1000, 'Individual', 1000);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l1_id);
        INSERT INTO price_pay VALUES (default, '2024-11-21', TRUE, 'Instructor', 'Beginner', 1100, 'Individual', 1100);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l1_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', TRUE, 'Student', 'Intermediate', 120, 'Group', 120);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l2_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', TRUE, 'Instructor', 'Intermediate', 1200, 'Group', 1200);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l2_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', TRUE, 'Student', 'Advanced', 150, 'Ensemble', 150);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l2_id);

        INSERT INTO price_pay VALUES (default, '2024-01-01', TRUE, 'Instructor', 'Advanced', 1500, 'Ensemble', 1500);
        INSERT INTO lesson_price_pay VALUES (currval(pg_get_serial_sequence('price_pay', 'price_pay_id')), l2_id);

        INSERT INTO instrument VALUES (default, 'Guitar', 'A', 1, 1);
        INSERT INTO lease
        VALUES (default, 100, '2024-11-21', '2024-11-21'::DATE + INTERVAL '12 months',
                currval(pg_get_serial_sequence('instrument', 'instrument_id')), s1_id);

        INSERT INTO instrument VALUES (default, 'Bass', 'B', 1, 1);
        INSERT INTO lease
        VALUES (default, 200, '2024-11-25', '2024-11-25'::DATE + INTERVAL '12 months',
                currval(pg_get_serial_sequence('instrument', 'instrument_id')), s1_id);
        INSERT INTO instrument VALUES (default, 'Drums', 'C', 1, 1);
    END
$$;

/*
--delete from lease;

CREATE OR REPLACE FUNCTION f()

    RETURNS TRIGGER
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    RAISE NOTICE 'student_id %', NEW.student_id;
    RETURN NULL;
END;
$$;

CREATE OR REPLACE TRIGGER max_lease
    AFTER INSERT
    ON lease
    FOR EACH STATEMENT
EXECUTE FUNCTION f();


INSERT INTO lease VALUES (default, 300, '2024-11-25', '2024-11-25'::DATE + INTERVAL '12 months',3 ,6 );
select * from lease;*/