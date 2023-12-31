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
import se.soundgood.jooq.tables.Address.AddressPath;
import se.soundgood.jooq.tables.Person.PersonPath;
import se.soundgood.jooq.tables.records.PersonAddressRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonAddress extends TableImpl<PersonAddressRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>person_address</code>
     */
    public static final PersonAddress PERSON_ADDRESS = new PersonAddress();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PersonAddressRecord> getRecordType() {
        return PersonAddressRecord.class;
    }

    /**
     * The column <code>person_address.person_id</code>.
     */
    public final TableField<PersonAddressRecord, Long> PERSON_ID = createField(DSL.name("person_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>person_address.address_id</code>.
     */
    public final TableField<PersonAddressRecord, Long> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private PersonAddress(Name alias, Table<PersonAddressRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PersonAddress(Name alias, Table<PersonAddressRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>person_address</code> table reference
     */
    public PersonAddress(String alias) {
        this(DSL.name(alias), PERSON_ADDRESS);
    }

    /**
     * Create an aliased <code>person_address</code> table reference
     */
    public PersonAddress(Name alias) {
        this(alias, PERSON_ADDRESS);
    }

    /**
     * Create a <code>person_address</code> table reference
     */
    public PersonAddress() {
        this(DSL.name("person_address"), null);
    }

    public <O extends Record> PersonAddress(Table<O> path, ForeignKey<O, PersonAddressRecord> childPath, InverseForeignKey<O, PersonAddressRecord> parentPath) {
        super(path, childPath, parentPath, PERSON_ADDRESS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PersonAddressPath extends PersonAddress implements Path<PersonAddressRecord> {
        public <O extends Record> PersonAddressPath(Table<O> path, ForeignKey<O, PersonAddressRecord> childPath, InverseForeignKey<O, PersonAddressRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PersonAddressPath(Name alias, Table<PersonAddressRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PersonAddressPath as(String alias) {
            return new PersonAddressPath(DSL.name(alias), this);
        }

        @Override
        public PersonAddressPath as(Name alias) {
            return new PersonAddressPath(alias, this);
        }

        @Override
        public PersonAddressPath as(Table<?> alias) {
            return new PersonAddressPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<PersonAddressRecord> getPrimaryKey() {
        return Keys.PERSON_ADDRESS_PKEY;
    }

    @Override
    public List<ForeignKey<PersonAddressRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PERSON_ADDRESS__PERSON_ADDRESS_PERSON_ID_FKEY, Keys.PERSON_ADDRESS__PERSON_ADDRESS_ADDRESS_ID_FKEY);
    }

    private transient PersonPath _person;

    /**
     * Get the implicit join path to the <code>public.person</code> table.
     */
    public PersonPath person() {
        if (_person == null)
            _person = new PersonPath(this, Keys.PERSON_ADDRESS__PERSON_ADDRESS_PERSON_ID_FKEY, null);

        return _person;
    }

    private transient AddressPath _address;

    /**
     * Get the implicit join path to the <code>public.address</code> table.
     */
    public AddressPath address() {
        if (_address == null)
            _address = new AddressPath(this, Keys.PERSON_ADDRESS__PERSON_ADDRESS_ADDRESS_ID_FKEY, null);

        return _address;
    }

    @Override
    public PersonAddress as(String alias) {
        return new PersonAddress(DSL.name(alias), this);
    }

    @Override
    public PersonAddress as(Name alias) {
        return new PersonAddress(alias, this);
    }

    @Override
    public PersonAddress as(Table<?> alias) {
        return new PersonAddress(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonAddress rename(String name) {
        return new PersonAddress(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonAddress rename(Name name) {
        return new PersonAddress(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PersonAddress rename(Table<?> name) {
        return new PersonAddress(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress where(Condition condition) {
        return new PersonAddress(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonAddress where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonAddress where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonAddress where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PersonAddress where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PersonAddress whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
