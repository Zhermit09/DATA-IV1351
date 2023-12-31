/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
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

import se.soundgood.jooq.DefaultSchema;
import se.soundgood.jooq.Keys;
import se.soundgood.jooq.tables.Person.PersonPath;
import se.soundgood.jooq.tables.records.PhoneRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Phone extends TableImpl<PhoneRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>phone</code>
     */
    public static final Phone PHONE = new Phone();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PhoneRecord> getRecordType() {
        return PhoneRecord.class;
    }

    /**
     * The column <code>phone.person_id</code>.
     */
    public final TableField<PhoneRecord, Long> PERSON_ID = createField(DSL.name("person_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>phone.phone_number</code>.
     */
    public final TableField<PhoneRecord, String> PHONE_NUMBER = createField(DSL.name("phone_number"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    private Phone(Name alias, Table<PhoneRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Phone(Name alias, Table<PhoneRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>phone</code> table reference
     */
    public Phone(String alias) {
        this(DSL.name(alias), PHONE);
    }

    /**
     * Create an aliased <code>phone</code> table reference
     */
    public Phone(Name alias) {
        this(alias, PHONE);
    }

    /**
     * Create a <code>phone</code> table reference
     */
    public Phone() {
        this(DSL.name("phone"), null);
    }

    public <O extends Record> Phone(Table<O> path, ForeignKey<O, PhoneRecord> childPath, InverseForeignKey<O, PhoneRecord> parentPath) {
        super(path, childPath, parentPath, PHONE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PhonePath extends Phone implements Path<PhoneRecord> {
        public <O extends Record> PhonePath(Table<O> path, ForeignKey<O, PhoneRecord> childPath, InverseForeignKey<O, PhoneRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PhonePath(Name alias, Table<PhoneRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PhonePath as(String alias) {
            return new PhonePath(DSL.name(alias), this);
        }

        @Override
        public PhonePath as(Name alias) {
            return new PhonePath(alias, this);
        }

        @Override
        public PhonePath as(Table<?> alias) {
            return new PhonePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<PhoneRecord> getPrimaryKey() {
        return Keys.PHONE_PKEY;
    }

    @Override
    public List<ForeignKey<PhoneRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PHONE__PHONE_PERSON_ID_FKEY);
    }

    private transient PersonPath _person;

    /**
     * Get the implicit join path to the <code>public.person</code> table.
     */
    public PersonPath person() {
        if (_person == null)
            _person = new PersonPath(this, Keys.PHONE__PHONE_PERSON_ID_FKEY, null);

        return _person;
    }

    @Override
    public Phone as(String alias) {
        return new Phone(DSL.name(alias), this);
    }

    @Override
    public Phone as(Name alias) {
        return new Phone(alias, this);
    }

    @Override
    public Phone as(Table<?> alias) {
        return new Phone(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Phone rename(String name) {
        return new Phone(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Phone rename(Name name) {
        return new Phone(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Phone rename(Table<?> name) {
        return new Phone(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone where(Condition condition) {
        return new Phone(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Phone where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Phone where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Phone where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Phone where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Phone whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
