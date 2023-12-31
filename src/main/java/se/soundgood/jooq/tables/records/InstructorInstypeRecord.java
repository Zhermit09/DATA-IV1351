/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.records;


import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;

import se.soundgood.jooq.enums.Instype;
import se.soundgood.jooq.tables.InstructorInstype;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InstructorInstypeRecord extends UpdatableRecordImpl<InstructorInstypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>instructor_instype.instructor_id</code>.
     */
    public InstructorInstypeRecord setInstructorId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>instructor_instype.instructor_id</code>.
     */
    public Long getInstructorId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>instructor_instype.instrument_type</code>.
     */
    public InstructorInstypeRecord setInstrumentType(Instype value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>instructor_instype.instrument_type</code>.
     */
    public Instype getInstrumentType() {
        return (Instype) get(1);
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
     * Create a detached InstructorInstypeRecord
     */
    public InstructorInstypeRecord() {
        super(InstructorInstype.INSTRUCTOR_INSTYPE);
    }

    /**
     * Create a detached, initialised InstructorInstypeRecord
     */
    public InstructorInstypeRecord(Long instructorId, Instype instrumentType) {
        super(InstructorInstype.INSTRUCTOR_INSTYPE);

        setInstructorId(instructorId);
        setInstrumentType(instrumentType);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised InstructorInstypeRecord
     */
    public InstructorInstypeRecord(se.soundgood.jooq.tables.pojos.InstructorInstype value) {
        super(InstructorInstype.INSTRUCTOR_INSTYPE);

        if (value != null) {
            setInstructorId(value.instructorId());
            setInstrumentType(value.instrumentType());
            resetChangedOnNotNull();
        }
    }
}
