/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.pojos;


import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public record Payment(
    Long paymentId,
    Long paymentDescriptionId,
    LocalDate fromDate,
    LocalDate toDate,
    Integer instructorPay,
    Integer studentPrice,
    BigDecimal siblingDiscount
) {

}