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
import se.soundgood.jooq.tables.records.StudentRecord;
import se.soundgood.jooq.tables.ContactPersonStudent.ContactPersonStudentPath;
import se.soundgood.jooq.tables.Enrollment.EnrollmentPath;
import se.soundgood.jooq.tables.Lease.LeasePath;
import se.soundgood.jooq.tables.Lesson.LessonPath;
import se.soundgood.jooq.tables.Person.PersonPath;
import se.soundgood.jooq.tables.StudentHistory.StudentHistoryPath;
import se.soundgood.jooq.tables.StudentInstype.StudentInstypePath;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Student extends TableImpl<StudentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>student</code>
     */
    public static final Student STUDENT = new Student();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentRecord> getRecordType() {
        return StudentRecord.class;
    }

    /**
     * The column <code>student.student_id</code>.
     */
    public final TableField<StudentRecord, Long> STUDENT_ID = createField(DSL.name("student_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>student.family_id</code>.
     */
    public final TableField<StudentRecord, Long> FAMILY_ID = createField(DSL.name("family_id"), SQLDataType.BIGINT, this, "");

    private Student(Name alias, Table<StudentRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Student(Name alias, Table<StudentRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>student</code> table reference
     */
    public Student(String alias) {
        this(DSL.name(alias), STUDENT);
    }

    /**
     * Create an aliased <code>student</code> table reference
     */
    public Student(Name alias) {
        this(alias, STUDENT);
    }

    /**
     * Create a <code>student</code> table reference
     */
    public Student() {
        this(DSL.name("student"), null);
    }

    public <O extends Record> Student(Table<O> path, ForeignKey<O, StudentRecord> childPath, InverseForeignKey<O, StudentRecord> parentPath) {
        super(path, childPath, parentPath, STUDENT);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class StudentPath extends Student implements Path<StudentRecord> {
        public <O extends Record> StudentPath(Table<O> path, ForeignKey<O, StudentRecord> childPath, InverseForeignKey<O, StudentRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private StudentPath(Name alias, Table<StudentRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public StudentPath as(String alias) {
            return new StudentPath(DSL.name(alias), this);
        }

        @Override
        public StudentPath as(Name alias) {
            return new StudentPath(alias, this);
        }

        @Override
        public StudentPath as(Table<?> alias) {
            return new StudentPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<StudentRecord> getPrimaryKey() {
        return Keys.STUDENT_PKEY;
    }

    @Override
    public List<ForeignKey<StudentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.STUDENT__STUDENT_STUDENT_ID_FKEY);
    }

    private transient PersonPath _person;

    /**
     * Get the implicit join path to the <code>public.person</code> table.
     */
    public PersonPath person() {
        if (_person == null)
            _person = new PersonPath(this, Keys.STUDENT__STUDENT_STUDENT_ID_FKEY, null);

        return _person;
    }

    private transient ContactPersonStudentPath _contactPersonStudent;

    /**
     * Get the implicit to-many join path to the
     * <code>public.contact_person_student</code> table
     */
    public ContactPersonStudentPath contactPersonStudent() {
        if (_contactPersonStudent == null)
            _contactPersonStudent = new ContactPersonStudentPath(this, null, Keys.CONTACT_PERSON_STUDENT__CONTACT_PERSON_STUDENT_STUDENT_ID_FKEY.getInverseKey());

        return _contactPersonStudent;
    }

    private transient EnrollmentPath _enrollment;

    /**
     * Get the implicit to-many join path to the <code>public.enrollment</code>
     * table
     */
    public EnrollmentPath enrollment() {
        if (_enrollment == null)
            _enrollment = new EnrollmentPath(this, null, Keys.ENROLLMENT__ENROLLMENT_STUDENT_ID_FKEY.getInverseKey());

        return _enrollment;
    }

    private transient LeasePath _lease;

    /**
     * Get the implicit to-many join path to the <code>public.lease</code> table
     */
    public LeasePath lease() {
        if (_lease == null)
            _lease = new LeasePath(this, null, Keys.LEASE__LEASE_STUDENT_ID_FKEY.getInverseKey());

        return _lease;
    }

    private transient StudentHistoryPath _studentHistory;

    /**
     * Get the implicit to-many join path to the
     * <code>public.student_history</code> table
     */
    public StudentHistoryPath studentHistory() {
        if (_studentHistory == null)
            _studentHistory = new StudentHistoryPath(this, null, Keys.STUDENT_HISTORY__STUDENT_HISTORY_STUDENT_ID_FKEY.getInverseKey());

        return _studentHistory;
    }

    private transient StudentInstypePath _studentInstype;

    /**
     * Get the implicit to-many join path to the
     * <code>public.student_instype</code> table
     */
    public StudentInstypePath studentInstype() {
        if (_studentInstype == null)
            _studentInstype = new StudentInstypePath(this, null, Keys.STUDENT_INSTYPE__STUDENT_INSTYPE_STUDENT_ID_FKEY.getInverseKey());

        return _studentInstype;
    }

    /**
     * Get the implicit many-to-many join path to the <code>public.lesson</code>
     * table
     */
    public LessonPath lesson() {
        return enrollment().lesson();
    }

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.time_slot</code> table
     */
    public TimeSlot.TimeSlotPath timeSlot() {
        return studentHistory().timeSlot();
    }

    @Override
    public Student as(String alias) {
        return new Student(DSL.name(alias), this);
    }

    @Override
    public Student as(Name alias) {
        return new Student(alias, this);
    }

    @Override
    public Student as(Table<?> alias) {
        return new Student(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(String name) {
        return new Student(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(Name name) {
        return new Student(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(Table<?> name) {
        return new Student(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student where(Condition condition) {
        return new Student(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Student where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Student where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Student where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Student where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Student whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}