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
import se.soundgood.jooq.enums.Instype;
import se.soundgood.jooq.enums.Skill;
import se.soundgood.jooq.tables.Student.StudentPath;
import se.soundgood.jooq.tables.records.StudentInstypeRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StudentInstype extends TableImpl<StudentInstypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>student_instype</code>
     */
    public static final StudentInstype STUDENT_INSTYPE = new StudentInstype();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentInstypeRecord> getRecordType() {
        return StudentInstypeRecord.class;
    }

    /**
     * The column <code>student_instype.student_id</code>.
     */
    public final TableField<StudentInstypeRecord, Long> STUDENT_ID = createField(DSL.name("student_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>student_instype.instrument_type</code>.
     */
    public final TableField<StudentInstypeRecord, Instype> INSTRUMENT_TYPE = createField(DSL.name("instrument_type"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(Instype.class), this, "");

    /**
     * The column <code>student_instype.skill_level</code>.
     */
    public final TableField<StudentInstypeRecord, Skill> SKILL_LEVEL = createField(DSL.name("skill_level"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(Skill.class), this, "");

    private StudentInstype(Name alias, Table<StudentInstypeRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private StudentInstype(Name alias, Table<StudentInstypeRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>student_instype</code> table reference
     */
    public StudentInstype(String alias) {
        this(DSL.name(alias), STUDENT_INSTYPE);
    }

    /**
     * Create an aliased <code>student_instype</code> table reference
     */
    public StudentInstype(Name alias) {
        this(alias, STUDENT_INSTYPE);
    }

    /**
     * Create a <code>student_instype</code> table reference
     */
    public StudentInstype() {
        this(DSL.name("student_instype"), null);
    }

    public <O extends Record> StudentInstype(Table<O> path, ForeignKey<O, StudentInstypeRecord> childPath, InverseForeignKey<O, StudentInstypeRecord> parentPath) {
        super(path, childPath, parentPath, STUDENT_INSTYPE);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class StudentInstypePath extends StudentInstype implements Path<StudentInstypeRecord> {
        public <O extends Record> StudentInstypePath(Table<O> path, ForeignKey<O, StudentInstypeRecord> childPath, InverseForeignKey<O, StudentInstypeRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private StudentInstypePath(Name alias, Table<StudentInstypeRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public StudentInstypePath as(String alias) {
            return new StudentInstypePath(DSL.name(alias), this);
        }

        @Override
        public StudentInstypePath as(Name alias) {
            return new StudentInstypePath(alias, this);
        }

        @Override
        public StudentInstypePath as(Table<?> alias) {
            return new StudentInstypePath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<StudentInstypeRecord> getPrimaryKey() {
        return Keys.STUDENT_INSTYPE_PKEY;
    }

    @Override
    public List<ForeignKey<StudentInstypeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.STUDENT_INSTYPE__STUDENT_INSTYPE_STUDENT_ID_FKEY);
    }

    private transient StudentPath _student;

    /**
     * Get the implicit join path to the <code>public.student</code> table.
     */
    public StudentPath student() {
        if (_student == null)
            _student = new StudentPath(this, Keys.STUDENT_INSTYPE__STUDENT_INSTYPE_STUDENT_ID_FKEY, null);

        return _student;
    }

    @Override
    public StudentInstype as(String alias) {
        return new StudentInstype(DSL.name(alias), this);
    }

    @Override
    public StudentInstype as(Name alias) {
        return new StudentInstype(alias, this);
    }

    @Override
    public StudentInstype as(Table<?> alias) {
        return new StudentInstype(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentInstype rename(String name) {
        return new StudentInstype(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentInstype rename(Name name) {
        return new StudentInstype(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentInstype rename(Table<?> name) {
        return new StudentInstype(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype where(Condition condition) {
        return new StudentInstype(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentInstype where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentInstype where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentInstype where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentInstype where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentInstype whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
