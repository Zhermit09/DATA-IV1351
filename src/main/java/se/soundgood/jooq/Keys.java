/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import se.soundgood.jooq.tables.Address;
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
import se.soundgood.jooq.tables.records.AddressRecord;
import se.soundgood.jooq.tables.records.ContactPersonStudentRecord;
import se.soundgood.jooq.tables.records.DbSettingsRecord;
import se.soundgood.jooq.tables.records.EmailRecord;
import se.soundgood.jooq.tables.records.EnrollmentRecord;
import se.soundgood.jooq.tables.records.InstructorInstypeRecord;
import se.soundgood.jooq.tables.records.InstructorRecord;
import se.soundgood.jooq.tables.records.InstrumentRecord;
import se.soundgood.jooq.tables.records.InstrumentSpecificationRecord;
import se.soundgood.jooq.tables.records.LeaseRecord;
import se.soundgood.jooq.tables.records.LessonRecord;
import se.soundgood.jooq.tables.records.PaymentDescriptionRecord;
import se.soundgood.jooq.tables.records.PaymentRecord;
import se.soundgood.jooq.tables.records.PersonAddressRecord;
import se.soundgood.jooq.tables.records.PersonRecord;
import se.soundgood.jooq.tables.records.PhoneRecord;
import se.soundgood.jooq.tables.records.RentPriceRecord;
import se.soundgood.jooq.tables.records.StudentHistoryRecord;
import se.soundgood.jooq.tables.records.StudentInstypeRecord;
import se.soundgood.jooq.tables.records.StudentRecord;
import se.soundgood.jooq.tables.records.TimeSlotRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddressRecord> ADDRESS_PKEY = Internal.createUniqueKey(Address.ADDRESS, DSL.name("address_pkey"), new TableField[] { Address.ADDRESS.ADDRESS_ID }, true);
    public static final UniqueKey<ContactPersonStudentRecord> CONTACT_PERSON_STUDENT_PKEY = Internal.createUniqueKey(ContactPersonStudent.CONTACT_PERSON_STUDENT, DSL.name("contact_person_student_pkey"), new TableField[] { ContactPersonStudent.CONTACT_PERSON_STUDENT.STUDENT_ID, ContactPersonStudent.CONTACT_PERSON_STUDENT.CONTACT_PERSON_ID }, true);
    public static final UniqueKey<DbSettingsRecord> DB_SETTINGS_PKEY = Internal.createUniqueKey(DbSettings.DB_SETTINGS, DSL.name("db_settings_pkey"), new TableField[] { DbSettings.DB_SETTINGS.ID }, true);
    public static final UniqueKey<EmailRecord> EMAIL_PKEY = Internal.createUniqueKey(Email.EMAIL, DSL.name("email_pkey"), new TableField[] { Email.EMAIL.PERSON_ID, Email.EMAIL.EMAIL_ }, true);
    public static final UniqueKey<EnrollmentRecord> ENROLLMENT_PKEY = Internal.createUniqueKey(Enrollment.ENROLLMENT, DSL.name("enrollment_pkey"), new TableField[] { Enrollment.ENROLLMENT.LESSON_ID, Enrollment.ENROLLMENT.STUDENT_ID }, true);
    public static final UniqueKey<InstructorRecord> INSTRUCTOR_PKEY = Internal.createUniqueKey(Instructor.INSTRUCTOR, DSL.name("instructor_pkey"), new TableField[] { Instructor.INSTRUCTOR.INSTRUCTOR_ID }, true);
    public static final UniqueKey<InstructorInstypeRecord> INSTRUCTOR_INSTYPE_PKEY = Internal.createUniqueKey(InstructorInstype.INSTRUCTOR_INSTYPE, DSL.name("instructor_instype_pkey"), new TableField[] { InstructorInstype.INSTRUCTOR_INSTYPE.INSTRUCTOR_ID, InstructorInstype.INSTRUCTOR_INSTYPE.INSTRUMENT_TYPE }, true);
    public static final UniqueKey<InstrumentRecord> INSTRUMENT_PKEY = Internal.createUniqueKey(Instrument.INSTRUMENT, DSL.name("instrument_pkey"), new TableField[] { Instrument.INSTRUMENT.INSTRUMENT_ID }, true);
    public static final UniqueKey<InstrumentSpecificationRecord> INSTRUMENT_SPECIFICATION_PKEY = Internal.createUniqueKey(InstrumentSpecification.INSTRUMENT_SPECIFICATION, DSL.name("instrument_specification_pkey"), new TableField[] { InstrumentSpecification.INSTRUMENT_SPECIFICATION.INSTRUMENT_SPECIFICATION_ID }, true);
    public static final UniqueKey<LeaseRecord> LEASE_PKEY = Internal.createUniqueKey(Lease.LEASE, DSL.name("lease_pkey"), new TableField[] { Lease.LEASE.LEASE_ID }, true);
    public static final UniqueKey<LessonRecord> LESSON_PKEY = Internal.createUniqueKey(Lesson.LESSON, DSL.name("lesson_pkey"), new TableField[] { Lesson.LESSON.LESSON_ID }, true);
    public static final UniqueKey<PaymentRecord> PAYMENT_PKEY = Internal.createUniqueKey(Payment.PAYMENT, DSL.name("payment_pkey"), new TableField[] { Payment.PAYMENT.PAYMENT_ID }, true);
    public static final UniqueKey<PaymentDescriptionRecord> PAYMENT_DESCRIPTION_PKEY = Internal.createUniqueKey(PaymentDescription.PAYMENT_DESCRIPTION, DSL.name("payment_description_pkey"), new TableField[] { PaymentDescription.PAYMENT_DESCRIPTION.PAYMENT_DESCRIPTION_ID }, true);
    public static final UniqueKey<PersonRecord> PERSON_PKEY = Internal.createUniqueKey(Person.PERSON, DSL.name("person_pkey"), new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final UniqueKey<PersonRecord> PERSON_SSN_KEY = Internal.createUniqueKey(Person.PERSON, DSL.name("person_ssn_key"), new TableField[] { Person.PERSON.SSN }, true);
    public static final UniqueKey<PersonAddressRecord> PERSON_ADDRESS_PKEY = Internal.createUniqueKey(PersonAddress.PERSON_ADDRESS, DSL.name("person_address_pkey"), new TableField[] { PersonAddress.PERSON_ADDRESS.PERSON_ID, PersonAddress.PERSON_ADDRESS.ADDRESS_ID }, true);
    public static final UniqueKey<PhoneRecord> PHONE_PKEY = Internal.createUniqueKey(Phone.PHONE, DSL.name("phone_pkey"), new TableField[] { Phone.PHONE.PERSON_ID, Phone.PHONE.PHONE_NUMBER }, true);
    public static final UniqueKey<RentPriceRecord> RENT_PRICE_PKEY = Internal.createUniqueKey(RentPrice.RENT_PRICE, DSL.name("rent_price_pkey"), new TableField[] { RentPrice.RENT_PRICE.RENT_PRICE_ID }, true);
    public static final UniqueKey<StudentRecord> STUDENT_PKEY = Internal.createUniqueKey(Student.STUDENT, DSL.name("student_pkey"), new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final UniqueKey<StudentHistoryRecord> STUDENT_HISTORY_PKEY = Internal.createUniqueKey(StudentHistory.STUDENT_HISTORY, DSL.name("student_history_pkey"), new TableField[] { StudentHistory.STUDENT_HISTORY.STUDENT_ID, StudentHistory.STUDENT_HISTORY.TIME_SLOT_ID }, true);
    public static final UniqueKey<StudentInstypeRecord> STUDENT_INSTYPE_PKEY = Internal.createUniqueKey(StudentInstype.STUDENT_INSTYPE, DSL.name("student_instype_pkey"), new TableField[] { StudentInstype.STUDENT_INSTYPE.STUDENT_ID, StudentInstype.STUDENT_INSTYPE.INSTRUMENT_TYPE }, true);
    public static final UniqueKey<TimeSlotRecord> TIME_SLOT_PKEY = Internal.createUniqueKey(TimeSlot.TIME_SLOT, DSL.name("time_slot_pkey"), new TableField[] { TimeSlot.TIME_SLOT.TIME_SLOT_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ContactPersonStudentRecord, PersonRecord> CONTACT_PERSON_STUDENT__CONTACT_PERSON_STUDENT_CONTACT_PERSON_ID_FKEY = Internal.createForeignKey(ContactPersonStudent.CONTACT_PERSON_STUDENT, DSL.name("contact_person_student_contact_person_id_fkey"), new TableField[] { ContactPersonStudent.CONTACT_PERSON_STUDENT.CONTACT_PERSON_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<ContactPersonStudentRecord, StudentRecord> CONTACT_PERSON_STUDENT__CONTACT_PERSON_STUDENT_STUDENT_ID_FKEY = Internal.createForeignKey(ContactPersonStudent.CONTACT_PERSON_STUDENT, DSL.name("contact_person_student_student_id_fkey"), new TableField[] { ContactPersonStudent.CONTACT_PERSON_STUDENT.STUDENT_ID }, Keys.STUDENT_PKEY, new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final ForeignKey<EmailRecord, PersonRecord> EMAIL__EMAIL_PERSON_ID_FKEY = Internal.createForeignKey(Email.EMAIL, DSL.name("email_person_id_fkey"), new TableField[] { Email.EMAIL.PERSON_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<EnrollmentRecord, LessonRecord> ENROLLMENT__ENROLLMENT_LESSON_ID_FKEY = Internal.createForeignKey(Enrollment.ENROLLMENT, DSL.name("enrollment_lesson_id_fkey"), new TableField[] { Enrollment.ENROLLMENT.LESSON_ID }, Keys.LESSON_PKEY, new TableField[] { Lesson.LESSON.LESSON_ID }, true);
    public static final ForeignKey<EnrollmentRecord, StudentRecord> ENROLLMENT__ENROLLMENT_STUDENT_ID_FKEY = Internal.createForeignKey(Enrollment.ENROLLMENT, DSL.name("enrollment_student_id_fkey"), new TableField[] { Enrollment.ENROLLMENT.STUDENT_ID }, Keys.STUDENT_PKEY, new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final ForeignKey<InstructorRecord, PersonRecord> INSTRUCTOR__INSTRUCTOR_INSTRUCTOR_ID_FKEY = Internal.createForeignKey(Instructor.INSTRUCTOR, DSL.name("instructor_instructor_id_fkey"), new TableField[] { Instructor.INSTRUCTOR.INSTRUCTOR_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<InstructorInstypeRecord, InstructorRecord> INSTRUCTOR_INSTYPE__INSTRUCTOR_INSTYPE_INSTRUCTOR_ID_FKEY = Internal.createForeignKey(InstructorInstype.INSTRUCTOR_INSTYPE, DSL.name("instructor_instype_instructor_id_fkey"), new TableField[] { InstructorInstype.INSTRUCTOR_INSTYPE.INSTRUCTOR_ID }, Keys.INSTRUCTOR_PKEY, new TableField[] { Instructor.INSTRUCTOR.INSTRUCTOR_ID }, true);
    public static final ForeignKey<InstrumentRecord, InstrumentSpecificationRecord> INSTRUMENT__INSTRUMENT_INSTRUMENT_SPECIFICATION_ID_FKEY = Internal.createForeignKey(Instrument.INSTRUMENT, DSL.name("instrument_instrument_specification_id_fkey"), new TableField[] { Instrument.INSTRUMENT.INSTRUMENT_SPECIFICATION_ID }, Keys.INSTRUMENT_SPECIFICATION_PKEY, new TableField[] { InstrumentSpecification.INSTRUMENT_SPECIFICATION.INSTRUMENT_SPECIFICATION_ID }, true);
    public static final ForeignKey<LeaseRecord, InstrumentRecord> LEASE__LEASE_INSTRUMENT_ID_FKEY = Internal.createForeignKey(Lease.LEASE, DSL.name("lease_instrument_id_fkey"), new TableField[] { Lease.LEASE.INSTRUMENT_ID }, Keys.INSTRUMENT_PKEY, new TableField[] { Instrument.INSTRUMENT.INSTRUMENT_ID }, true);
    public static final ForeignKey<LeaseRecord, RentPriceRecord> LEASE__LEASE_RENT_PRICE_ID_FKEY = Internal.createForeignKey(Lease.LEASE, DSL.name("lease_rent_price_id_fkey"), new TableField[] { Lease.LEASE.RENT_PRICE_ID }, Keys.RENT_PRICE_PKEY, new TableField[] { RentPrice.RENT_PRICE.RENT_PRICE_ID }, true);
    public static final ForeignKey<LeaseRecord, StudentRecord> LEASE__LEASE_STUDENT_ID_FKEY = Internal.createForeignKey(Lease.LEASE, DSL.name("lease_student_id_fkey"), new TableField[] { Lease.LEASE.STUDENT_ID }, Keys.STUDENT_PKEY, new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final ForeignKey<LessonRecord, InstructorRecord> LESSON__LESSON_INSTRUCTOR_ID_FKEY = Internal.createForeignKey(Lesson.LESSON, DSL.name("lesson_instructor_id_fkey"), new TableField[] { Lesson.LESSON.INSTRUCTOR_ID }, Keys.INSTRUCTOR_PKEY, new TableField[] { Instructor.INSTRUCTOR.INSTRUCTOR_ID }, true);
    public static final ForeignKey<LessonRecord, PaymentDescriptionRecord> LESSON__LESSON_PAYMENT_DESCRIPTION_ID_FKEY = Internal.createForeignKey(Lesson.LESSON, DSL.name("lesson_payment_description_id_fkey"), new TableField[] { Lesson.LESSON.PAYMENT_DESCRIPTION_ID }, Keys.PAYMENT_DESCRIPTION_PKEY, new TableField[] { PaymentDescription.PAYMENT_DESCRIPTION.PAYMENT_DESCRIPTION_ID }, true);
    public static final ForeignKey<PaymentRecord, PaymentDescriptionRecord> PAYMENT__PAYMENT_PAYMENT_DESCRIPTION_ID_FKEY = Internal.createForeignKey(Payment.PAYMENT, DSL.name("payment_payment_description_id_fkey"), new TableField[] { Payment.PAYMENT.PAYMENT_DESCRIPTION_ID }, Keys.PAYMENT_DESCRIPTION_PKEY, new TableField[] { PaymentDescription.PAYMENT_DESCRIPTION.PAYMENT_DESCRIPTION_ID }, true);
    public static final ForeignKey<PersonAddressRecord, AddressRecord> PERSON_ADDRESS__PERSON_ADDRESS_ADDRESS_ID_FKEY = Internal.createForeignKey(PersonAddress.PERSON_ADDRESS, DSL.name("person_address_address_id_fkey"), new TableField[] { PersonAddress.PERSON_ADDRESS.ADDRESS_ID }, Keys.ADDRESS_PKEY, new TableField[] { Address.ADDRESS.ADDRESS_ID }, true);
    public static final ForeignKey<PersonAddressRecord, PersonRecord> PERSON_ADDRESS__PERSON_ADDRESS_PERSON_ID_FKEY = Internal.createForeignKey(PersonAddress.PERSON_ADDRESS, DSL.name("person_address_person_id_fkey"), new TableField[] { PersonAddress.PERSON_ADDRESS.PERSON_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<PhoneRecord, PersonRecord> PHONE__PHONE_PERSON_ID_FKEY = Internal.createForeignKey(Phone.PHONE, DSL.name("phone_person_id_fkey"), new TableField[] { Phone.PHONE.PERSON_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<RentPriceRecord, InstrumentRecord> RENT_PRICE__RENT_PRICE_INSTRUMENT_ID_FKEY = Internal.createForeignKey(RentPrice.RENT_PRICE, DSL.name("rent_price_instrument_id_fkey"), new TableField[] { RentPrice.RENT_PRICE.INSTRUMENT_ID }, Keys.INSTRUMENT_PKEY, new TableField[] { Instrument.INSTRUMENT.INSTRUMENT_ID }, true);
    public static final ForeignKey<StudentRecord, PersonRecord> STUDENT__STUDENT_STUDENT_ID_FKEY = Internal.createForeignKey(Student.STUDENT, DSL.name("student_student_id_fkey"), new TableField[] { Student.STUDENT.STUDENT_ID }, Keys.PERSON_PKEY, new TableField[] { Person.PERSON.PERSON_ID }, true);
    public static final ForeignKey<StudentHistoryRecord, StudentRecord> STUDENT_HISTORY__STUDENT_HISTORY_STUDENT_ID_FKEY = Internal.createForeignKey(StudentHistory.STUDENT_HISTORY, DSL.name("student_history_student_id_fkey"), new TableField[] { StudentHistory.STUDENT_HISTORY.STUDENT_ID }, Keys.STUDENT_PKEY, new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final ForeignKey<StudentHistoryRecord, TimeSlotRecord> STUDENT_HISTORY__STUDENT_HISTORY_TIME_SLOT_ID_FKEY = Internal.createForeignKey(StudentHistory.STUDENT_HISTORY, DSL.name("student_history_time_slot_id_fkey"), new TableField[] { StudentHistory.STUDENT_HISTORY.TIME_SLOT_ID }, Keys.TIME_SLOT_PKEY, new TableField[] { TimeSlot.TIME_SLOT.TIME_SLOT_ID }, true);
    public static final ForeignKey<StudentInstypeRecord, StudentRecord> STUDENT_INSTYPE__STUDENT_INSTYPE_STUDENT_ID_FKEY = Internal.createForeignKey(StudentInstype.STUDENT_INSTYPE, DSL.name("student_instype_student_id_fkey"), new TableField[] { StudentInstype.STUDENT_INSTYPE.STUDENT_ID }, Keys.STUDENT_PKEY, new TableField[] { Student.STUDENT.STUDENT_ID }, true);
    public static final ForeignKey<TimeSlotRecord, InstructorRecord> TIME_SLOT__TIME_SLOT_INSTRUCTOR_ID_FKEY = Internal.createForeignKey(TimeSlot.TIME_SLOT, DSL.name("time_slot_instructor_id_fkey"), new TableField[] { TimeSlot.TIME_SLOT.INSTRUCTOR_ID }, Keys.INSTRUCTOR_PKEY, new TableField[] { Instructor.INSTRUCTOR.INSTRUCTOR_ID }, true);
    public static final ForeignKey<TimeSlotRecord, LessonRecord> TIME_SLOT__TIME_SLOT_LESSON_ID_FKEY = Internal.createForeignKey(TimeSlot.TIME_SLOT, DSL.name("time_slot_lesson_id_fkey"), new TableField[] { TimeSlot.TIME_SLOT.LESSON_ID }, Keys.LESSON_PKEY, new TableField[] { Lesson.LESSON.LESSON_ID }, true);
    public static final ForeignKey<TimeSlotRecord, PaymentRecord> TIME_SLOT__TIME_SLOT_PAYMENT_ID_FKEY = Internal.createForeignKey(TimeSlot.TIME_SLOT, DSL.name("time_slot_payment_id_fkey"), new TableField[] { TimeSlot.TIME_SLOT.PAYMENT_ID }, Keys.PAYMENT_PKEY, new TableField[] { Payment.PAYMENT.PAYMENT_ID }, true);
}