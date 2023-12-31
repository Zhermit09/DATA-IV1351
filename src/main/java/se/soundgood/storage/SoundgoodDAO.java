package se.soundgood.storage;

import org.jooq.*;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.types.YearToSecond;
import se.soundgood.jooq.enums.Instype;
import se.soundgood.jooq.tables.records.AvailableInstrumentRecord;
import se.soundgood.jooq.tables.records.LeaseRecord;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static se.soundgood.jooq.Tables.*;


public class SoundgoodDAO {

    private final DSLContext jooq;

    public SoundgoodDAO() throws RuntimeException {
        try {
            this.jooq = connectToSoundgoodDB();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("[ERROR] Could Not Connect To Database", e);
        }
    }

    public void transaction(TransactionalRunnable runnable) throws DataAccessException {
        jooq.transaction(runnable);
    }

    public <T> T transactionResult(TransactionalCallable<T> runnable) throws DataAccessException {
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


    public List<AvailableInstrumentRecord> listAvailableInstruments(Configuration tx, Instype type) {
        if (type == null) {
            return tx.dsl().selectFrom(AVAILABLE_INSTRUMENT).fetch();
        }
        return tx.dsl().selectFrom(AVAILABLE_INSTRUMENT).where(AVAILABLE_INSTRUMENT.TYPE.eq(type)).fetch();
    }


    public void lockInstrument(Configuration tx, Long iId) {
        tx.dsl().selectFrom(INSTRUMENT).where(INSTRUMENT.INSTRUMENT_ID.eq(iId)).forUpdate().fetch();
    }

    public Integer countInstrumentActiveLeases(Configuration tx, Long iId) {
        return tx.dsl().fetchCount(tx.dsl().selectFrom(LEASE)
                .where(LEASE.INSTRUMENT_ID.eq(iId)
                        .and(currentLocalDate().le(LEASE.RETURN_DATE))));
    }

    public Integer getStudentActiveLeases(Configuration tx, Long sId) {
        return tx.dsl().fetchCount(tx.dsl().selectFrom(LEASE)
                .where(LEASE.STUDENT_ID.eq(sId)
                        .and(currentLocalDate().le(LEASE.RETURN_DATE))));
    }

    public Integer getMaxLeaseCount(Configuration tx) {
        return tx.dsl().select(DB_SETTINGS.MAX_LEASE_COUNT).from(DB_SETTINGS).fetchSingle(DB_SETTINGS.MAX_LEASE_COUNT);
    }

    public YearToSecond getMaxRentPeriod(Configuration tx) {
        return tx.dsl().select(DB_SETTINGS.MAX_RENT_PERIOD).from(DB_SETTINGS).fetchSingle(DB_SETTINGS.MAX_RENT_PERIOD);
    }

    public Long getInstrumentRentPriceId(Configuration tx, Long iId) {
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


    public List<LeaseRecord> listActiveLeases(Configuration tx, Long sId) {
        if (sId == null) {
            return tx.dsl().selectFrom(LEASE)
                    .where(currentLocalDate().le(LEASE.RETURN_DATE))
                    .fetch();
        }
        return tx.dsl().selectFrom(LEASE)
                .where(currentLocalDate().le(LEASE.RETURN_DATE)
                        .and(LEASE.STUDENT_ID.eq(sId)))
                .fetch();
    }


    public Integer lockLease(Configuration tx, Long lId) {
        return tx.dsl().selectOne().from(LEASE)
                .where(LEASE.LEASE_ID.eq(lId)
                        .and(currentLocalDate().lt(LEASE.RETURN_DATE)))
                .forNoKeyUpdate().fetchOneInto(Integer.class);
    }

    public void terminateLease(Configuration tx, Long lId) {
        tx.dsl().update(LEASE).set(LEASE.RETURN_DATE, currentLocalDate()).where(LEASE.LEASE_ID.eq(lId)).execute();
    }
}