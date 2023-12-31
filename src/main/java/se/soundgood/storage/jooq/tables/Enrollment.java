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
import se.soundgood.storage.jooq.tables.Lesson.LessonPath;
import se.soundgood.storage.jooq.tables.Student.StudentPath;
import se.soundgood.storage.jooq.tables.records.EnrollmentRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Enrollment extends TableImpl<EnrollmentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>enrollment</code>
     */
    public static final Enrollment ENROLLMENT = new Enrollment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EnrollmentRecord> getRecordType() {
        return EnrollmentRecord.class;
    }

    /**
     * The column <code>enrollment.lesson_id</code>.
     */
    public final TableField<EnrollmentRecord, Long> LESSON_ID = createField(DSL.name("lesson_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>enrollment.student_id</code>.
     */
    public final TableField<EnrollmentRecord, Long> STUDENT_ID = createField(DSL.name("student_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private Enrollment(Name alias, Table<EnrollmentRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Enrollment(Name alias, Table<EnrollmentRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>enrollment</code> table reference
     */
    public Enrollment(String alias) {
        this(DSL.name(alias), ENROLLMENT);
    }

    /**
     * Create an aliased <code>enrollment</code> table reference
     */
    public Enrollment(Name alias) {
        this(alias, ENROLLMENT);
    }

    /**
     * Create a <code>enrollment</code> table reference
     */
    public Enrollment() {
        this(DSL.name("enrollment"), null);
    }

    public <O extends Record> Enrollment(Table<O> path, ForeignKey<O, EnrollmentRecord> childPath, InverseForeignKey<O, EnrollmentRecord> parentPath) {
        super(path, childPath, parentPath, ENROLLMENT);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class EnrollmentPath extends Enrollment implements Path<EnrollmentRecord> {
        public <O extends Record> EnrollmentPath(Table<O> path, ForeignKey<O, EnrollmentRecord> childPath, InverseForeignKey<O, EnrollmentRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private EnrollmentPath(Name alias, Table<EnrollmentRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public EnrollmentPath as(String alias) {
            return new EnrollmentPath(DSL.name(alias), this);
        }

        @Override
        public EnrollmentPath as(Name alias) {
            return new EnrollmentPath(alias, this);
        }

        @Override
        public EnrollmentPath as(Table<?> alias) {
            return new EnrollmentPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<EnrollmentRecord> getPrimaryKey() {
        return Keys.ENROLLMENT_PKEY;
    }

    @Override
    public List<ForeignKey<EnrollmentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ENROLLMENT__ENROLLMENT_LESSON_ID_FKEY, Keys.ENROLLMENT__ENROLLMENT_STUDENT_ID_FKEY);
    }

    private transient LessonPath _lesson;

    /**
     * Get the implicit join path to the <code>public.lesson</code> table.
     */
    public LessonPath lesson() {
        if (_lesson == null)
            _lesson = new LessonPath(this, Keys.ENROLLMENT__ENROLLMENT_LESSON_ID_FKEY, null);

        return _lesson;
    }

    private transient StudentPath _student;

    /**
     * Get the implicit join path to the <code>public.student</code> table.
     */
    public StudentPath student() {
        if (_student == null)
            _student = new StudentPath(this, Keys.ENROLLMENT__ENROLLMENT_STUDENT_ID_FKEY, null);

        return _student;
    }

    @Override
    public Enrollment as(String alias) {
        return new Enrollment(DSL.name(alias), this);
    }

    @Override
    public Enrollment as(Name alias) {
        return new Enrollment(alias, this);
    }

    @Override
    public Enrollment as(Table<?> alias) {
        return new Enrollment(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Enrollment rename(String name) {
        return new Enrollment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Enrollment rename(Name name) {
        return new Enrollment(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Enrollment rename(Table<?> name) {
        return new Enrollment(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment where(Condition condition) {
        return new Enrollment(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Enrollment where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Enrollment where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Enrollment where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Enrollment where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Enrollment whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
