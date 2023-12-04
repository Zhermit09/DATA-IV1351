CREATE OR REPLACE VIEW _time_slots AS
SELECT time_slot.date, lesson.lesson_type
FROM time_slot LEFT JOIN lesson ON time_slot.lesson_id = lesson.lesson_id;

CREATE OR REPLACE FUNCTION monthly_report(_year TEXT)
    RETURNS TABLE
            (
                Month      TEXT,
                Total      BIGINT,
                Individual BIGINT,
                "Group"    BIGINT,
                Ensemble   BIGINT
            )
    LANGUAGE PLPGSQL
AS
$$
DECLARE
    _start_date DATE := (_year || '-01-01')::DATE;
BEGIN

    RETURN QUERY
        SELECT
            TO_CHAR(_time_slots.date, 'Mon') AS "Month",
            COUNT(*) AS "Total",
            COUNT(CASE WHEN _time_slots.lesson_type = 'Individual' THEN 1 END) AS "Individual",
            COUNT(CASE WHEN _time_slots.lesson_type = 'Group' THEN 1 END) AS "Group",
            COUNT(CASE WHEN _time_slots.lesson_type = 'Ensemble' THEN 1 END) AS "Ensemble"
        FROM _time_slots
        WHERE _start_date <= _time_slots.date AND _time_slots.date < _start_date + INTERVAL '1 year'
        GROUP BY "Month", EXTRACT(MONTH FROM _time_slots.date)
        ORDER BY EXTRACT(MONTH FROM _time_slots.date);
END ;
$$;

CREATE OR REPLACE VIEW sibling_report AS
    SELECT "No of Siblings", count(*) AS "No of Students"
    FROM
        (SELECT student_id,
                CASE WHEN family_id IS NULL THEN 0
                    ELSE count(*) OVER (PARTITION BY family_id) - 1
                    END AS "No of Siblings" from student) AS counted
    GROUP BY counted."No of Siblings"
    ORDER BY counted."No of Siblings";



CREATE OR REPLACE FUNCTION instructor_report(_num INT)
    RETURNS TABLE
            (
                "Instructor ID"     BIGINT,
                "First Name"        VARCHAR(100),
                "Last Name"         VARCHAR(100),
                "Lesson Count"      BIGINT
            )
    LANGUAGE PLPGSQL
AS
$$
BEGIN

    RETURN QUERY
        SELECT person.person_id AS "Instructor ID",
               person.first_name AS "First Name",
               person.last_name AS "Last Name",
               count(*) AS "Lesson Count"
        from person inner join time_slot on person.person_id = time_slot.instructor_id
        group by person.person_id, person.first_name, person.last_name
        HAVING count(*) > _num
        order by count(*) DESC, person.person_id;
END ;
$$;

CREATE OR REPLACE FUNCTION next_week_ensemble(_start_date DATE)
    RETURNS TABLE
            (
                "Day"      TEXT,
                "Genre"      MGENRE,
                "No of Free Seats" TEXT
            )
    LANGUAGE PLPGSQL
AS
$$
BEGIN
    RETURN QUERY
        SELECT
            TO_CHAR(time_slot.date, 'Dy') AS "Day",
            lesson.music_genre AS "GENRE",
            (CASE
                 WHEN (lesson.max_students - count(*)) > 2 THEN 'Many Seats'
                 WHEN 0 < (lesson.max_students - count(*)) AND (lesson.max_students - count(*)) < 3 THEN '1 or 2 Seats'
                 WHEN (lesson.max_students - count(*)) < 1 THEN 'No Seats'
                END)
                                          AS "No of Free Seats"
        FROM
            time_slot
                INNER JOIN lesson ON time_slot.lesson_id = lesson.lesson_id
                INNER JOIN enrollment ON enrollment.lesson_id = lesson.lesson_id
        WHERE _start_date <= time_slot.date AND time_slot.date < _start_date + INTERVAL '1 week'
          AND lesson.lesson_type = 'Ensemble'
        GROUP BY time_slot.date, lesson.music_genre, lesson.max_students
        ORDER BY time_slot.date::DATE, lesson.music_genre;
END ;
$$;