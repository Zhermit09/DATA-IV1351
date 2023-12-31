/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables;


import java.util.Collection;

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

import se.soundgood.jooq.DefaultSchema;
import se.soundgood.jooq.Keys;
import se.soundgood.jooq.tables.records.PaymentDescriptionRecord;
import se.soundgood.jooq.tables.Lesson.LessonPath;
import se.soundgood.jooq.tables.Payment.PaymentPath;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PaymentDescription extends TableImpl<PaymentDescriptionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>payment_description</code>
     */
    public static final PaymentDescription PAYMENT_DESCRIPTION = new PaymentDescription();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PaymentDescriptionRecord> getRecordType() {
        return PaymentDescriptionRecord.class;
    }

    /**
     * The column <code>payment_description.payment_description_id</code>.
     */
    public final TableField<PaymentDescriptionRecord, Long> PAYMENT_DESCRIPTION_ID = createField(DSL.name("payment_description_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>payment_description.description</code>.
     */
    public final TableField<PaymentDescriptionRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    private PaymentDescription(Name alias, Table<PaymentDescriptionRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PaymentDescription(Name alias, Table<PaymentDescriptionRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>payment_description</code> table reference
     */
    public PaymentDescription(String alias) {
        this(DSL.name(alias), PAYMENT_DESCRIPTION);
    }

    /**
     * Create an aliased <code>payment_description</code> table reference
     */
    public PaymentDescription(Name alias) {
        this(alias, PAYMENT_DESCRIPTION);
    }

    /**
     * Create a <code>payment_description</code> table reference
     */
    public PaymentDescription() {
        this(DSL.name("payment_description"), null);
    }

    public <O extends Record> PaymentDescription(Table<O> path, ForeignKey<O, PaymentDescriptionRecord> childPath, InverseForeignKey<O, PaymentDescriptionRecord> parentPath) {
        super(path, childPath, parentPath, PAYMENT_DESCRIPTION);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PaymentDescriptionPath extends PaymentDescription implements Path<PaymentDescriptionRecord> {
        public <O extends Record> PaymentDescriptionPath(Table<O> path, ForeignKey<O, PaymentDescriptionRecord> childPath, InverseForeignKey<O, PaymentDescriptionRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PaymentDescriptionPath(Name alias, Table<PaymentDescriptionRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PaymentDescriptionPath as(String alias) {
            return new PaymentDescriptionPath(DSL.name(alias), this);
        }

        @Override
        public PaymentDescriptionPath as(Name alias) {
            return new PaymentDescriptionPath(alias, this);
        }

        @Override
        public PaymentDescriptionPath as(Table<?> alias) {
            return new PaymentDescriptionPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<PaymentDescriptionRecord, Long> getIdentity() {
        return (Identity<PaymentDescriptionRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PaymentDescriptionRecord> getPrimaryKey() {
        return Keys.PAYMENT_DESCRIPTION_PKEY;
    }

    private transient LessonPath _lesson;

    /**
     * Get the implicit to-many join path to the <code>public.lesson</code>
     * table
     */
    public LessonPath lesson() {
        if (_lesson == null)
            _lesson = new LessonPath(this, null, Keys.LESSON__LESSON_PAYMENT_DESCRIPTION_ID_FKEY.getInverseKey());

        return _lesson;
    }

    private transient PaymentPath _payment;

    /**
     * Get the implicit to-many join path to the <code>public.payment</code>
     * table
     */
    public PaymentPath payment() {
        if (_payment == null)
            _payment = new PaymentPath(this, null, Keys.PAYMENT__PAYMENT_PAYMENT_DESCRIPTION_ID_FKEY.getInverseKey());

        return _payment;
    }

    @Override
    public PaymentDescription as(String alias) {
        return new PaymentDescription(DSL.name(alias), this);
    }

    @Override
    public PaymentDescription as(Name alias) {
        return new PaymentDescription(alias, this);
    }

    @Override
    public PaymentDescription as(Table<?> alias) {
        return new PaymentDescription(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentDescription rename(String name) {
        return new PaymentDescription(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentDescription rename(Name name) {
        return new PaymentDescription(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PaymentDescription rename(Table<?> name) {
        return new PaymentDescription(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription where(Condition condition) {
        return new PaymentDescription(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PaymentDescription where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PaymentDescription where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PaymentDescription where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PaymentDescription where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PaymentDescription whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}