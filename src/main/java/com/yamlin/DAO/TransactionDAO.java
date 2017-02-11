package com.yamlin.DAO;

import com.yamlin.parsec_generated.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yamlin on 2017/2/11.
 */
public class TransactionDAO {
    public List<Transaction> searchTransactionTsInterval(Long startTs, Long endTs) {
        if (startTs != null && startTs == 1451606400000L
                && endTs != null && endTs == 1483228799000L) {
            List<Transaction> list = new ArrayList<>(2);
            list.add(new Transaction().setId("1")
                    .setTimestamp(startTs+5).setTraderId("1")
                    .setValue(205));
            return list;
        }
        return null;
    }

    public double findHighestTransaction() {
        return 1000.0;
    }

    public double findAverageTransaction(String q) {
        if ("trader.city=Beijing".equals(q)) {
            return 200.5;
        }
        return 203.1;
    }

}
