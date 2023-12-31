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


    public void rentInstrument(Long sId, Long iId) throws DataAccessException {
        dao.transaction((tx) -> {
            dao.lockInstrument(tx, iId);
            if (dao.countInstrumentActiveLeases(tx, iId) != 0) {
                throw new SQLTransactionRollbackException("Chosen Instrument Is No Longer Available");
            }

            Integer max = dao.getMaxLeaseCount(tx);
            if (dao.countStudentActiveLeases(tx, sId) >= max) {
                throw new SQLTransactionRollbackException(String.format("The Student Has Already Reached The Maximum Number Of Leases (%d)", max));
            }

            dao.createLease(tx, sId, iId, dao.getMaxRentPeriod(tx), dao.getInstrumentRentPriceId(tx, iId));
        });
    }

    public List<LeaseRecord> listLeases(Long sId) throws DataAccessException {
        return dao.transactionResult((tx) -> dao.listActiveLeases(tx, sId));
    }

    public void terminateRental(Long lId) throws DataAccessException {
        dao.transaction((tx) -> {

            if (dao.lockLease(tx, lId) == null) {
                throw new SQLTransactionRollbackException("The Lease Period Has Already Ended Or Could Not Find Lease (id = " + lId + ")");
            }
            dao.terminateLease(tx, lId);
        });
    }
}
