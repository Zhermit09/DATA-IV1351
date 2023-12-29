package se.soundgood.storage;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.YearToSecond;
import se.soundgood.storage.jooq.enums.Instype;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static se.soundgood.storage.jooq.Tables.*;


public class SoundgoodDAO {

    private final DSLContext jooq;

    public SoundgoodDAO() throws RuntimeException {
        try {
            this.jooq = connectToSoundgoodDB();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Could not connect to database", e);
        }
    }

    public void transaction(TransactionalRunnable runnable) {
        jooq.transaction(runnable);
    }

    public <T> T transactionResult(TransactionalCallable<T> runnable) {
        return jooq.transactionResult(runnable);
    }

    private DSLContext connectToSoundgoodDB() throws ClassNotFoundException, SQLException {
        String userName = "postgres";
        String pwd = "1";
        String url = "jdbc:postgresql://localhost:5432/soundgood";

        var connection = DriverManager.getConnection(url, userName, pwd);
        connection.setAutoCommit(false);

        return DSL.using(connection, SQLDialect.POSTGRES);
    }

    /*

select instrument.instrument_id, instrument_specification.type, instrument_specification.brand, instrument.description, rent_price.price
from instrument
inner join rent_price ON instrument.instrument_id = rent_price.instrument_id
inner join instrument_specification ON instrument.instrument_specification_id = instrument_specification.instrument_specification_id
where (rent_price.from_date <= CURRENT_DATE AND CURRENT_DATE <= COALESCE(rent_price.to_date,CURRENT_DATE))
AND NOT EXISTS
(select 1 from lease
 where lease.rent_date <= CURRENT_DATE AND CURRENT_DATE <= lease.return_date
 and lease.instrument_id = instrument.instrument_id)
 order by instrument_id;

    */

    public record AvailableInstrument(Long instrumentId, Instype type, String brand, String description,
                                      Integer price) {
    }

    public List<AvailableInstrument> listAvailableInstruments(Configuration tx) {
        return  tx.dsl().select(INSTRUMENT.INSTRUMENT_ID, INSTRUMENT_SPECIFICATION.TYPE, INSTRUMENT_SPECIFICATION.BRAND, INSTRUMENT.DESCRIPTION, RENT_PRICE.PRICE)
                .from(INSTRUMENT)
                .innerJoin(RENT_PRICE).on(INSTRUMENT.INSTRUMENT_ID.eq(RENT_PRICE.INSTRUMENT_ID))
                .innerJoin(INSTRUMENT_SPECIFICATION).on(INSTRUMENT.INSTRUMENT_SPECIFICATION_ID.eq(INSTRUMENT_SPECIFICATION.INSTRUMENT_SPECIFICATION_ID))
                .where(RENT_PRICE.FROM_DATE.le(currentLocalDate())
                        .and(currentLocalDate().le(coalesce(RENT_PRICE.TO_DATE, currentLocalDate())))
                        .and(notExists(selectOne().from(LEASE)
                                .where(LEASE.RENT_DATE.le(currentLocalDate())
                                        .and(currentLocalDate().le(LEASE.RETURN_DATE))
                                        .and(INSTRUMENT.INSTRUMENT_ID.eq(LEASE.INSTRUMENT_ID))))))
                .orderBy(INSTRUMENT.INSTRUMENT_ID)
                .fetchInto(AvailableInstrument.class);
    }

    public void lockInstrument(Configuration tx, Long iId){
        tx.dsl().selectFrom(INSTRUMENT).where(INSTRUMENT.INSTRUMENT_ID.eq(iId)).forUpdate().fetch();
    }

    public Integer getInstrumentActiveLeases(Configuration tx, Long iId){
        return  tx.dsl().fetchCount(tx.dsl().selectFrom(LEASE).where(LEASE.INSTRUMENT_ID.eq(iId).and(LEASE.RENT_DATE.le(currentLocalDate())
                .and(currentLocalDate().le(LEASE.RETURN_DATE)))));
    }

    public Integer getStudentActiveLeases(Configuration tx, Long sId){
        return  tx.dsl().fetchCount(tx.dsl().selectFrom(LEASE).where(LEASE.STUDENT_ID.eq(sId).and(LEASE.RENT_DATE.le(currentLocalDate())
                .and(currentLocalDate().le(LEASE.RETURN_DATE)))));
    }

    public Integer getMaxLeaseCount(Configuration tx){
        return  tx.dsl().select(DB_SETTINGS.MAX_LEASE_COUNT).from(DB_SETTINGS).fetchSingle(DB_SETTINGS.MAX_LEASE_COUNT);
    }

    public YearToSecond getMaxRentPeriod(Configuration tx){
        return  tx.dsl().select(DB_SETTINGS.MAX_RENT_PERIOD).from(DB_SETTINGS).fetchSingle(DB_SETTINGS.MAX_RENT_PERIOD);
    }

    public Long getInstrumentRentPriceId(Configuration tx, Long iId){
        return tx.dsl().select(RENT_PRICE.RENT_PRICE_ID).from(RENT_PRICE)
                .where(RENT_PRICE.INSTRUMENT_ID.eq(iId)
                        .and(RENT_PRICE.FROM_DATE.le(currentLocalDate()))
                        .and(currentLocalDate().le(coalesce(RENT_PRICE.TO_DATE, currentLocalDate()))))
                .fetchSingle(RENT_PRICE.RENT_PRICE_ID);
    }
    public void createLease(Configuration tx, Long sId, Long iId, YearToSecond period, Long pId) {

        tx.dsl().insertInto(LEASE)
                .values(defaultValue(LEASE.LEASE_ID), currentLocalDate(), dateAdd(currentDate(), period), iId, sId, pId)
                .execute();
    }
}