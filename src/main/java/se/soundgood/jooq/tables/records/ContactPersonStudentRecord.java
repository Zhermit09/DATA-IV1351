/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.records;


import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;

import se.soundgood.jooq.tables.ContactPersonStudent;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ContactPersonStudentRecord extends UpdatableRecordImpl<ContactPersonStudentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>contact_person_student.student_id</code>.
     */
    public ContactPersonStudentRecord setStudentId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>contact_person_student.student_id</code>.
     */
    public Long getStudentId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>contact_person_student.contact_person_id</code>.
     */
    public ContactPersonStudentRecord setContactPersonId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>contact_person_student.contact_person_id</code>.
     */
    public Long getContactPersonId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContactPersonStudentRecord
     */
    public ContactPersonStudentRecord() {
        super(ContactPersonStudent.CONTACT_PERSON_STUDENT);
    }

    /**
     * Create a detached, initialised ContactPersonStudentRecord
     */
    public ContactPersonStudentRecord(Long studentId, Long contactPersonId) {
        super(ContactPersonStudent.CONTACT_PERSON_STUDENT);

        setStudentId(studentId);
        setContactPersonId(contactPersonId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised ContactPersonStudentRecord
     */
    public ContactPersonStudentRecord(se.soundgood.jooq.tables.pojos.ContactPersonStudent value) {
        super(ContactPersonStudent.CONTACT_PERSON_STUDENT);

        if (value != null) {
            setStudentId(value.studentId());
            setContactPersonId(value.contactPersonId());
            resetChangedOnNotNull();
        }
    }
}
