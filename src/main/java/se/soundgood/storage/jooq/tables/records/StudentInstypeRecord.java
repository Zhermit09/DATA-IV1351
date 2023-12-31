/*
 * This file is generated by jOOQ.
 */
package se.soundgood.storage.jooq.tables.records;


import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;

import se.soundgood.storage.jooq.enums.Instype;
import se.soundgood.storage.jooq.enums.Skill;
import se.soundgood.storage.jooq.tables.StudentInstype;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StudentInstypeRecord extends UpdatableRecordImpl<StudentInstypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>student_instype.student_id</code>.
     */
    public StudentInstypeRecord setStudentId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>student_instype.student_id</code>.
     */
    public Long getStudentId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>student_instype.instrument_type</code>.
     */
    public StudentInstypeRecord setInstrumentType(Instype value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>student_instype.instrument_type</code>.
     */
    public Instype getInstrumentType() {
        return (Instype) get(1);
    }

    /**
     * Setter for <code>student_instype.skill_level</code>.
     */
    public StudentInstypeRecord setSkillLevel(Skill value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>student_instype.skill_level</code>.
     */
    public Skill getSkillLevel() {
        return (Skill) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Instype> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StudentInstypeRecord
     */
    public StudentInstypeRecord() {
        super(StudentInstype.STUDENT_INSTYPE);
    }

    /**
     * Create a detached, initialised StudentInstypeRecord
     */
    public StudentInstypeRecord(Long studentId, Instype instrumentType, Skill skillLevel) {
        super(StudentInstype.STUDENT_INSTYPE);

        setStudentId(studentId);
        setInstrumentType(instrumentType);
        setSkillLevel(skillLevel);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised StudentInstypeRecord
     */
    public StudentInstypeRecord(se.soundgood.storage.jooq.tables.pojos.StudentInstype value) {
        super(StudentInstype.STUDENT_INSTYPE);

        if (value != null) {
            setStudentId(value.studentId());
            setInstrumentType(value.instrumentType());
            setSkillLevel(value.skillLevel());
            resetChangedOnNotNull();
        }
    }
}
