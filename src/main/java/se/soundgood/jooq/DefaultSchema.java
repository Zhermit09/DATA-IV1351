/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import se.soundgood.jooq.tables.Address;
import se.soundgood.jooq.tables.AvailableInstrument;
import se.soundgood.jooq.tables.ContactPersonStudent;
import se.soundgood.jooq.tables.DbSettings;
import se.soundgood.jooq.tables.Email;
import se.soundgood.jooq.tables.Enrollment;
import se.soundgood.jooq.tables.Instructor;
import se.soundgood.jooq.tables.InstructorInstype;
import se.soundgood.jooq.tables.Instrument;
import se.soundgood.jooq.tables.InstrumentSpecification;
import se.soundgood.jooq.tables.Lease;
import se.soundgood.jooq.tables.Lesson;
import se.soundgood.jooq.tables.Payment;
import se.soundgood.jooq.tables.PaymentDescription;
import se.soundgood.jooq.tables.Person;
import se.soundgood.jooq.tables.PersonAddress;
import se.soundgood.jooq.tables.Phone;
import se.soundgood.jooq.tables.RentPrice;
import se.soundgood.jooq.tables.Student;
import se.soundgood.jooq.tables.StudentHistory;
import se.soundgood.jooq.tables.StudentInstype;
import se.soundgood.jooq.tables.TimeSlot;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>address</code>.
     */
    public final Address ADDRESS = Address.ADDRESS;

    /**
     * The table <code>available_instrument</code>.
     */
    public final AvailableInstrument AVAILABLE_INSTRUMENT = AvailableInstrument.AVAILABLE_INSTRUMENT;

    /**
     * The table <code>contact_person_student</code>.
     */
    public final ContactPersonStudent CONTACT_PERSON_STUDENT = ContactPersonStudent.CONTACT_PERSON_STUDENT;

    /**
     * The table <code>db_settings</code>.
     */
    public final DbSettings DB_SETTINGS = DbSettings.DB_SETTINGS;

    /**
     * The table <code>email</code>.
     */
    public final Email EMAIL = Email.EMAIL;

    /**
     * The table <code>enrollment</code>.
     */
    public final Enrollment ENROLLMENT = Enrollment.ENROLLMENT;

    /**
     * The table <code>instructor</code>.
     */
    public final Instructor INSTRUCTOR = Instructor.INSTRUCTOR;

    /**
     * The table <code>instructor_instype</code>.
     */
    public final InstructorInstype INSTRUCTOR_INSTYPE = InstructorInstype.INSTRUCTOR_INSTYPE;

    /**
     * The table <code>instrument</code>.
     */
    public final Instrument INSTRUMENT = Instrument.INSTRUMENT;

    /**
     * The table <code>instrument_specification</code>.
     */
    public final InstrumentSpecification INSTRUMENT_SPECIFICATION = InstrumentSpecification.INSTRUMENT_SPECIFICATION;

    /**
     * The table <code>lease</code>.
     */
    public final Lease LEASE = Lease.LEASE;

    /**
     * The table <code>lesson</code>.
     */
    public final Lesson LESSON = Lesson.LESSON;

    /**
     * The table <code>payment</code>.
     */
    public final Payment PAYMENT = Payment.PAYMENT;

    /**
     * The table <code>payment_description</code>.
     */
    public final PaymentDescription PAYMENT_DESCRIPTION = PaymentDescription.PAYMENT_DESCRIPTION;

    /**
     * The table <code>person</code>.
     */
    public final Person PERSON = Person.PERSON;

    /**
     * The table <code>person_address</code>.
     */
    public final PersonAddress PERSON_ADDRESS = PersonAddress.PERSON_ADDRESS;

    /**
     * The table <code>phone</code>.
     */
    public final Phone PHONE = Phone.PHONE;

    /**
     * The table <code>rent_price</code>.
     */
    public final RentPrice RENT_PRICE = RentPrice.RENT_PRICE;

    /**
     * The table <code>student</code>.
     */
    public final Student STUDENT = Student.STUDENT;

    /**
     * The table <code>student_history</code>.
     */
    public final StudentHistory STUDENT_HISTORY = StudentHistory.STUDENT_HISTORY;

    /**
     * The table <code>student_instype</code>.
     */
    public final StudentInstype STUDENT_INSTYPE = StudentInstype.STUDENT_INSTYPE;

    /**
     * The table <code>time_slot</code>.
     */
    public final TimeSlot TIME_SLOT = TimeSlot.TIME_SLOT;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.asList(
            Sequences.STUDENT_FAMILY_ID_SEQ
        );
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Address.ADDRESS,
            AvailableInstrument.AVAILABLE_INSTRUMENT,
            ContactPersonStudent.CONTACT_PERSON_STUDENT,
            DbSettings.DB_SETTINGS,
            Email.EMAIL,
            Enrollment.ENROLLMENT,
            Instructor.INSTRUCTOR,
            InstructorInstype.INSTRUCTOR_INSTYPE,
            Instrument.INSTRUMENT,
            InstrumentSpecification.INSTRUMENT_SPECIFICATION,
            Lease.LEASE,
            Lesson.LESSON,
            Payment.PAYMENT,
            PaymentDescription.PAYMENT_DESCRIPTION,
            Person.PERSON,
            PersonAddress.PERSON_ADDRESS,
            Phone.PHONE,
            RentPrice.RENT_PRICE,
            Student.STUDENT,
            StudentHistory.STUDENT_HISTORY,
            StudentInstype.STUDENT_INSTYPE,
            TimeSlot.TIME_SLOT
        );
    }
}