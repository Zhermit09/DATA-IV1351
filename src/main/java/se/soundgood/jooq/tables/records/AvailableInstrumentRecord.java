/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.records;


import org.jooq.impl.TableRecordImpl;

import se.soundgood.jooq.enums.Instype;
import se.soundgood.jooq.tables.AvailableInstrument;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AvailableInstrumentRecord extends TableRecordImpl<AvailableInstrumentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>available_instrument.instrument_id</code>.
     */
    public AvailableInstrumentRecord setInstrumentId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>available_instrument.instrument_id</code>.
     */
    public Long getInstrumentId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>available_instrument.type</code>.
     */
    public AvailableInstrumentRecord setType(Instype value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>available_instrument.type</code>.
     */
    public Instype getType() {
        return (Instype) get(1);
    }

    /**
     * Setter for <code>available_instrument.brand</code>.
     */
    public AvailableInstrumentRecord setBrand(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>available_instrument.brand</code>.
     */
    public String getBrand() {
        return (String) get(2);
    }

    /**
     * Setter for <code>available_instrument.description</code>.
     */
    public AvailableInstrumentRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>available_instrument.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>available_instrument.price</code>.
     */
    public AvailableInstrumentRecord setPrice(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>available_instrument.price</code>.
     */
    public Integer getPrice() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AvailableInstrumentRecord
     */
    public AvailableInstrumentRecord() {
        super(AvailableInstrument.AVAILABLE_INSTRUMENT);
    }

    /**
     * Create a detached, initialised AvailableInstrumentRecord
     */
    public AvailableInstrumentRecord(Long instrumentId, Instype type, String brand, String description, Integer price) {
        super(AvailableInstrument.AVAILABLE_INSTRUMENT);

        setInstrumentId(instrumentId);
        setType(type);
        setBrand(brand);
        setDescription(description);
        setPrice(price);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised AvailableInstrumentRecord
     */
    public AvailableInstrumentRecord(se.soundgood.jooq.tables.pojos.AvailableInstrument value) {
        super(AvailableInstrument.AVAILABLE_INSTRUMENT);

        if (value != null) {
            setInstrumentId(value.instrumentId());
            setType(value.type());
            setBrand(value.brand());
            setDescription(value.description());
            setPrice(value.price());
            resetChangedOnNotNull();
        }
    }
}
