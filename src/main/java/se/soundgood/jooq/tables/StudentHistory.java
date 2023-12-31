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
import se.soundgood.jooq.tables.Student.StudentPath;
import se.soundgood.jooq.tables.TimeSlot.TimeSlotPath;
import se.soundgood.jooq.tables.records.StudentHistoryRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StudentHistory extends TableImpl<StudentHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>student_history</code>
     */
    public static final StudentHistory STUDENT_HISTORY = new StudentHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentHistoryRecord> getRecordType() {
        return StudentHistoryRecord.class;
    }

    /**
     * The column <code>student_history.student_id</code>.
     */
    public final TableField<StudentHistoryRecord, Long> STUDENT_ID = createField(DSL.name("student_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>student_history.time_slot_id</code>.
     */
    public final TableField<StudentHistoryRecord, Long> TIME_SLOT_ID = createField(DSL.name("time_slot_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private StudentHistory(Name alias, Table<StudentHistoryRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private StudentHistory(Name alias, Table<StudentHistoryRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>student_history</code> table reference
     */
    public StudentHistory(String alias) {
        this(DSL.name(alias), STUDENT_HISTORY);
    }

    /**
     * Create an aliased <code>student_history</code> table reference
     */
    public StudentHistory(Name alias) {
        this(alias, STUDENT_HISTORY);
    }

    /**
     * Create a <code>student_history</code> table reference
     */
    public StudentHistory() {
        this(DSL.name("student_history"), null);
    }

    public <O extends Record> StudentHistory(Table<O> path, ForeignKey<O, StudentHistoryRecord> childPath, InverseForeignKey<O, StudentHistoryRecord> parentPath) {
        super(path, childPath, parentPath, STUDENT_HISTORY);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class StudentHistoryPath extends StudentHistory implements Path<StudentHistoryRecord> {
        public <O extends Record> StudentHistoryPath(Table<O> path, ForeignKey<O, StudentHistoryRecord> childPath, InverseForeignKey<O, StudentHistoryRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private StudentHistoryPath(Name alias, Table<StudentHistoryRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public StudentHistoryPath as(String alias) {
            return new StudentHistoryPath(DSL.name(alias), this);
        }

        @Override
        public StudentHistoryPath as(Name alias) {
            return new StudentHistoryPath(alias, this);
        }

        @Override
        public StudentHistoryPath as(Table<?> alias) {
            return new StudentHistoryPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<StudentHistoryRecord> getPrimaryKey() {
        return Keys.STUDENT_HISTORY_PKEY;
    }

    @Override
    public List<ForeignKey<StudentHistoryRecord, ?>> getReferences() {
        return Arrays.asList(Keys.STUDENT_HISTORY__STUDENT_HISTORY_STUDENT_ID_FKEY, Keys.STUDENT_HISTORY__STUDENT_HISTORY_TIME_SLOT_ID_FKEY);
    }

    private transient StudentPath _student;

    /**
     * Get the implicit join path to the <code>public.student</code> table.
     */
    public StudentPath student() {
        if (_student == null)
            _student = new StudentPath(this, Keys.STUDENT_HISTORY__STUDENT_HISTORY_STUDENT_ID_FKEY, null);

        return _student;
    }

    private transient TimeSlotPath _timeSlot;

    /**
     * Get the implicit join path to the <code>public.time_slot</code> table.
     */
    public TimeSlotPath timeSlot() {
        if (_timeSlot == null)
            _timeSlot = new TimeSlotPath(this, Keys.STUDENT_HISTORY__STUDENT_HISTORY_TIME_SLOT_ID_FKEY, null);

        return _timeSlot;
    }

    @Override
    public StudentHistory as(String alias) {
        return new StudentHistory(DSL.name(alias), this);
    }

    @Override
    public StudentHistory as(Name alias) {
        return new StudentHistory(alias, this);
    }

    @Override
    public StudentHistory as(Table<?> alias) {
        return new StudentHistory(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentHistory rename(String name) {
        return new StudentHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentHistory rename(Name name) {
        return new StudentHistory(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public StudentHistory rename(Table<?> name) {
        return new StudentHistory(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory where(Condition condition) {
        return new StudentHistory(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentHistory where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentHistory where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentHistory where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public StudentHistory where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public StudentHistory whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
