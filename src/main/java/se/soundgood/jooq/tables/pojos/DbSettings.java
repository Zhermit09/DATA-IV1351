/*
 * This file is generated by jOOQ.
 */
package se.soundgood.jooq.tables.pojos;


import org.jooq.types.YearToSecond;

import se.soundgood.jooq.enums.Settings;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public record DbSettings(
    Settings id,
    Integer maxLeaseCount,
    YearToSecond maxRentPeriod
) {

}