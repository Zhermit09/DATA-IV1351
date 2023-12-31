/*
 * This file is generated by jOOQ.
 */
package se.soundgood.storage.jooq.tables;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import se.soundgood.storage.jooq.DefaultSchema;
import se.soundgood.storage.jooq.Keys;
import se.soundgood.storage.jooq.tables.InstrumentSpecification.InstrumentSpecificationPath;
import se.soundgood.storage.jooq.tables.Lease.LeasePath;
import se.soundgood.storage.jooq.tables.RentPrice.RentPricePath;
import se.soundgood.storage.jooq.tables.records.InstrumentRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Instrument extends TableImpl<InstrumentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>instrument</code>
     */
    public static final Instrument INSTRUMENT = new Instrument();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InstrumentRecord> getRecordType() {
        return InstrumentRecord.class;
    }

    /**
     * The column <code>instrument.instrument_id</code>.
     */
    public final TableField<InstrumentRecord, Long> INSTRUMENT_ID = createField(DSL.name("instrument_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>instrument.description</code>.
     */
    public final TableField<InstrumentRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>instrument.instrument_specification_id</code>.
     */
    public final TableField<InstrumentRecord, Long> INSTRUMENT_SPECIFICATION_ID = createField(DSL.name("instrument_specification_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private Instrument(Name alias, Table<InstrumentRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Instrument(Name alias, Table<InstrumentRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>instrument</code> table reference
     */
    public Instrument(String alias) {
        this(DSL.name(alias), INSTRUMENT);
    }

    /**
     * Create an aliased <code>instrument</code> table reference
     */
    public Instrument(Name alias) {
        this(alias, INSTRUMENT);
    }

    /**
     * Create a <code>instrument</code> table reference
     */
    public Instrument() {
        this(DSL.name("instrument"), null);
    }

    public <O extends Record> Instrument(Table<O> path, ForeignKey<O, InstrumentRecord> childPath, InverseForeignKey<O, InstrumentRecord> parentPath) {
        super(path, childPath, parentPath, INSTRUMENT);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class InstrumentPath extends Instrument implements Path<InstrumentRecord> {
        public <O extends Record> InstrumentPath(Table<O> path, ForeignKey<O, InstrumentRecord> childPath, InverseForeignKey<O, InstrumentRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private InstrumentPath(Name alias, Table<InstrumentRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public InstrumentPath as(String alias) {
            return new InstrumentPath(DSL.name(alias), this);
        }

        @Override
        public InstrumentPath as(Name alias) {
            return new InstrumentPath(alias, this);
        }

        @Override
        public InstrumentPath as(Table<?> alias) {
            return new InstrumentPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<InstrumentRecord, Long> getIdentity() {
        return (Identity<InstrumentRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<InstrumentRecord> getPrimaryKey() {
        return Keys.INSTRUMENT_PKEY;
    }

    @Override
    public List<ForeignKey<InstrumentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.INSTRUMENT__INSTRUMENT_INSTRUMENT_SPECIFICATION_ID_FKEY);
    }

    private transient InstrumentSpecificationPath _instrumentSpecification;

    /**
     * Get the implicit join path to the
     * <code>public.instrument_specification</code> table.
     */
    public InstrumentSpecificationPath instrumentSpecification() {
        if (_instrumentSpecification == null)
            _instrumentSpecification = new InstrumentSpecificationPath(this, Keys.INSTRUMENT__INSTRUMENT_INSTRUMENT_SPECIFICATION_ID_FKEY, null);

        return _instrumentSpecification;
    }

    private transient LeasePath _lease;

    /**
     * Get the implicit to-many join path to the <code>public.lease</code> table
     */
    public LeasePath lease() {
        if (_lease == null)
            _lease = new LeasePath(this, null, Keys.LEASE__LEASE_INSTRUMENT_ID_FKEY.getInverseKey());

        return _lease;
    }

    private transient RentPricePath _rentPrice;

    /**
     * Get the implicit to-many join path to the <code>public.rent_price</code>
     * table
     */
    public RentPricePath rentPrice() {
        if (_rentPrice == null)
            _rentPrice = new RentPricePath(this, null, Keys.RENT_PRICE__RENT_PRICE_INSTRUMENT_ID_FKEY.getInverseKey());

        return _rentPrice;
    }

    @Override
    public Instrument as(String alias) {
        return new Instrument(DSL.name(alias), this);
    }

    @Override
    public Instrument as(Name alias) {
        return new Instrument(alias, this);
    }

    @Override
    public Instrument as(Table<?> alias) {
        return new Instrument(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Instrument rename(String name) {
        return new Instrument(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Instrument rename(Name name) {
        return new Instrument(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Instrument rename(Table<?> name) {
        return new Instrument(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument where(Condition condition) {
        return new Instrument(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instrument where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instrument where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instrument where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instrument where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instrument whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
