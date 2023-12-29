package se.soundgood.controller;

import se.soundgood.storage.SoundgoodDAO;
import java.sql.SQLTransactionRollbackException;

public class Controller {

    private final SoundgoodDAO dao;

    public Controller() throws RuntimeException {
        dao = new SoundgoodDAO();
    }

    public void listInstruments() {
        var res = dao.transactionResult(dao::listAvailableInstruments);
        System.out.println(res);
    }

    public void rentInstrument(Long sId, Long iId) {
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


}
