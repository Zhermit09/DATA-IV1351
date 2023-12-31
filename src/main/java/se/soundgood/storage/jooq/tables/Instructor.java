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
import se.soundgood.storage.jooq.tables.InstructorInstype.InstructorInstypePath;
import se.soundgood.storage.jooq.tables.Lesson.LessonPath;
import se.soundgood.storage.jooq.tables.Person.PersonPath;
import se.soundgood.storage.jooq.tables.TimeSlot.TimeSlotPath;
import se.soundgood.storage.jooq.tables.records.InstructorRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Instructor extends TableImpl<InstructorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>instructor</code>
     */
    public static final Instructor INSTRUCTOR = new Instructor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InstructorRecord> getRecordType() {
        return InstructorRecord.class;
    }

    /**
     * The column <code>instructor.instructor_id</code>.
     */
    public final TableField<InstructorRecord, Long> INSTRUCTOR_ID = createField(DSL.name("instructor_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>instructor.leads_ensemble</code>.
     */
    public final TableField<InstructorRecord, Boolean> LEADS_ENSEMBLE = createField(DSL.name("leads_ensemble"), SQLDataType.BOOLEAN.nullable(false), this, "");

    private Instructor(Name alias, Table<InstructorRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Instructor(Name alias, Table<InstructorRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>instructor</code> table reference
     */
    public Instructor(String alias) {
        this(DSL.name(alias), INSTRUCTOR);
    }

    /**
     * Create an aliased <code>instructor</code> table reference
     */
    public Instructor(Name alias) {
        this(alias, INSTRUCTOR);
    }

    /**
     * Create a <code>instructor</code> table reference
     */
    public Instructor() {
        this(DSL.name("instructor"), null);
    }

    public <O extends Record> Instructor(Table<O> path, ForeignKey<O, InstructorRecord> childPath, InverseForeignKey<O, InstructorRecord> parentPath) {
        super(path, childPath, parentPath, INSTRUCTOR);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class InstructorPath extends Instructor implements Path<InstructorRecord> {
        public <O extends Record> InstructorPath(Table<O> path, ForeignKey<O, InstructorRecord> childPath, InverseForeignKey<O, InstructorRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private InstructorPath(Name alias, Table<InstructorRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public InstructorPath as(String alias) {
            return new InstructorPath(DSL.name(alias), this);
        }

        @Override
        public InstructorPath as(Name alias) {
            return new InstructorPath(alias, this);
        }

        @Override
        public InstructorPath as(Table<?> alias) {
            return new InstructorPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<InstructorRecord> getPrimaryKey() {
        return Keys.INSTRUCTOR_PKEY;
    }

    @Override
    public List<ForeignKey<InstructorRecord, ?>> getReferences() {
        return Arrays.asList(Keys.INSTRUCTOR__INSTRUCTOR_INSTRUCTOR_ID_FKEY);
    }

    private transient PersonPath _person;

    /**
     * Get the implicit join path to the <code>public.person</code> table.
     */
    public PersonPath person() {
        if (_person == null)
            _person = new PersonPath(this, Keys.INSTRUCTOR__INSTRUCTOR_INSTRUCTOR_ID_FKEY, null);

        return _person;
    }

    private transient InstructorInstypePath _instructorInstype;

    /**
     * Get the implicit to-many join path to the
     * <code>public.instructor_instype</code> table
     */
    public InstructorInstypePath instructorInstype() {
        if (_instructorInstype == null)
            _instructorInstype = new InstructorInstypePath(this, null, Keys.INSTRUCTOR_INSTYPE__INSTRUCTOR_INSTYPE_INSTRUCTOR_ID_FKEY.getInverseKey());

        return _instructorInstype;
    }

    private transient LessonPath _lesson;

    /**
     * Get the implicit to-many join path to the <code>public.lesson</code>
     * table
     */
    public LessonPath lesson() {
        if (_lesson == null)
            _lesson = new LessonPath(this, null, Keys.LESSON__LESSON_INSTRUCTOR_ID_FKEY.getInverseKey());

        return _lesson;
    }

    private transient TimeSlotPath _timeSlot;

    /**
     * Get the implicit to-many join path to the <code>public.time_slot</code>
     * table
     */
    public TimeSlotPath timeSlot() {
        if (_timeSlot == null)
            _timeSlot = new TimeSlotPath(this, null, Keys.TIME_SLOT__TIME_SLOT_INSTRUCTOR_ID_FKEY.getInverseKey());

        return _timeSlot;
    }

    @Override
    public Instructor as(String alias) {
        return new Instructor(DSL.name(alias), this);
    }

    @Override
    public Instructor as(Name alias) {
        return new Instructor(alias, this);
    }

    @Override
    public Instructor as(Table<?> alias) {
        return new Instructor(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Instructor rename(String name) {
        return new Instructor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Instructor rename(Name name) {
        return new Instructor(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Instructor rename(Table<?> name) {
        return new Instructor(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor where(Condition condition) {
        return new Instructor(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instructor where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instructor where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instructor where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Instructor where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Instructor whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
