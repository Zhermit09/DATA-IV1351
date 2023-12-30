package se.soundgood.controller;

import org.jooq.exception.DataAccessException;
import se.soundgood.jooq.enums.Instype;
import se.soundgood.jooq.tables.records.AvailableInstrumentRecord;
import se.soundgood.jooq.tables.records.LeaseRecord;
import se.soundgood.storage.SoundgoodDAO;

import java.sql.SQLTransactionRollbackException;
import java.util.List;

public class Controller {

    private final SoundgoodDAO dao;

    public Controller() throws RuntimeException {
        dao = new SoundgoodDAO();
    }

    public List<AvailableInstrumentRecord> listInstruments(Instype type) throws DataAccessException {
        return dao.transactionResult(tx -> dao.listAvailableInstruments(tx, type));
    }


    public void rentInstrument(Long sId, Long iId) throws SQLTransactionRollbackException {
        dao.transaction((tx) -> {
            dao.lockInstrument(tx, iId);
            if (dao.getInstrumentActiveLeases(tx, iId) != 0) {
                throw new SQLTransactionRollbackException("Chosen instrument is no longer available");
            }

            Integer max = dao.getMaxLeaseCount(tx);
            if (dao.getStudentActiveLeases(tx, sId) >= max) {
                throw new SQLTransactionRollbackException("The student has already reached the maximum number of leases ({max})");
            }

            dao.createLease(tx, sId, iId, dao.getMaxRentPeriod(tx), dao.getInstrumentRentPriceId(tx, iId));
        });
    }

    public List<LeaseRecord> listLeases(Long sId) throws DataAccessException {
        var res = dao.transactionResult((tx) -> dao.listActiveLeases(tx, sId));

    }

    public void terminateRental(Long lId) throws SQLTransactionRollbackException {
        dao.transaction((tx) -> {

            if (dao.lockLease(tx, lId) == null) {
                throw new SQLTransactionRollbackException("The lease period has already ended");
            }

            dao.terminateLease(tx, lId);
        });
    }

}
