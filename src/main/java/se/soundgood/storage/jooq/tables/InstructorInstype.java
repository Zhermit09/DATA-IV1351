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
import se.soundgood.storage.jooq.enums.Instype;
import se.soundgood.storage.jooq.tables.Instructor.InstructorPath;
import se.soundgood.storage.jooq.tables.records.InstructorInstypeRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InstructorInstype extends TableImpl<InstructorInstypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>instructor_instype</code>
     */
    public static final InstructorInstype INSTRUCTOR_INSTYPE = new InstructorInstype();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InstructorInstypeRecord> getRecordType() {
        return InstructorInstypeRecord.class;
    }

    /**
     * The column <code>instructor_instype.instructor_id</code>.
     */
    public final TableField<InstructorInstypeRecord, Long> INSTRUCTOR_ID = createField(DSL.name("instructor_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>instructor_instype.instrument_type</code>.
     */
    public final TableField<InstructorInstypeRecord, Instype> INSTRUMENT_TYPE = createField(DSL.name("instrument_type"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(Instype.class), this, "");

    private InstructorInstype(Name alias, Table<InstructorInstypeRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private InstructorInstype(Name alias, Table<InstructorInstypeRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>instructor_instype</code> table reference
     */
    public InstructorInstype(String alias) {
        this(DSL.name(alias), INSTRUCTOR_INSTYPE);
    }

    /**
     * Create an aliased <code>instructor_instype</code> table reference
     */
    public InstructorInstype(Name alias) {
        this(alias, INSTRUCTOR_INSTYPE);
    }

    /**
     * Create a <code>instructor_instype</code> table reference
     */
    public InstructorInstype() {
        this(DSL.name("instructor_instype"), null);
    }

    public <O extends Record> InstructorInstype(Table<O> path, ForeignKey<O, InstructorInstypeRecord> childPath, InverseForeignKey<O, InstructorInstypeRecord> parentPath) {
        super(path, childPath, parentPath, INSTRUCTOR_INSTYPE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class InstructorInstypePath extends InstructorInstype implements Path<InstructorInstypeRecord> {
        public <O extends Record> InstructorInstypePath(Table<O> path, ForeignKey<O, InstructorInstypeRecord> childPath, InverseForeignKey<O, InstructorInstypeRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private InstructorInstypePath(Name alias, Table<InstructorInstypeRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public InstructorInstypePath as(String alias) {
            return new InstructorInstypePath(DSL.name(alias), this);
        }

        @Override
        public InstructorInstypePath as(Name alias) {
            return new InstructorInstypePath(alias, this);
        }

        @Override
        public InstructorInstypePath as(Table<?> alias) {
            return new InstructorInstypePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<InstructorInstypeRecord> getPrimaryKey() {
        return Keys.INSTRUCTOR_INSTYPE_PKEY;
    }

    @Override
    public List<ForeignKey<InstructorInstypeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.INSTRUCTOR_INSTYPE__INSTRUCTOR_INSTYPE_INSTRUCTOR_ID_FKEY);
    }

    private transient InstructorPath _instructor;

    /**
     * Get the implicit join path to the <code>public.instructor</code> table.
     */
    public InstructorPath instructor() {
        if (_instructor == null)
            _instructor = new InstructorPath(this, Keys.INSTRUCTOR_INSTYPE__INSTRUCTOR_INSTYPE_INSTRUCTOR_ID_FKEY, null);

        return _instructor;
    }

    @Override
    public InstructorInstype as(String alias) {
        return new InstructorInstype(DSL.name(alias), this);
    }

    @Override
    public InstructorInstype as(Name alias) {
        return new InstructorInstype(alias, this);
    }

    @Override
    public InstructorInstype as(Table<?> alias) {
        return new InstructorInstype(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public InstructorInstype rename(String name) {
        return new InstructorInstype(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public InstructorInstype rename(Name name) {
        return new InstructorInstype(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public InstructorInstype rename(Table<?> name) {
        return new InstructorInstype(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype where(Condition condition) {
        return new InstructorInstype(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public InstructorInstype where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public InstructorInstype where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public InstructorInstype where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public InstructorInstype where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public InstructorInstype whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
