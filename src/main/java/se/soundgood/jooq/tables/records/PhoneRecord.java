/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.records;


import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;

import se.soundgood.jooq.tables.pojos.Phone;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PhoneRecord extends UpdatableRecordImpl<PhoneRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>phone.person_id</code>.
     */
    public PhoneRecord setPersonId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>phone.person_id</code>.
     */
    public Long getPersonId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>phone.phone_number</code>.
     */
    public PhoneRecord setPhoneNumber(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>phone.phone_number</code>.
     */
    public String getPhoneNumber() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PhoneRecord
     */
    public PhoneRecord() {
        super(se.soundgood.jooq.tables.Phone.PHONE);
    }

    /**
     * Create a detached, initialised PhoneRecord
     */
    public PhoneRecord(Long personId, String phoneNumber) {
        super(se.soundgood.jooq.tables.Phone.PHONE);

        setPersonId(personId);
        setPhoneNumber(phoneNumber);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised PhoneRecord
     */
    public PhoneRecord(Phone value) {
        super(se.soundgood.jooq.tables.Phone.PHONE);

        if (value != null) {
            setPersonId(value.personId());
            setPhoneNumber(value.phoneNumber());
            resetChangedOnNotNull();
        }
    }
}