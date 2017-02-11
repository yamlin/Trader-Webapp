package com.yamlin.BO;

import com.yamlin.DAO.TransactionDAO;
import com.yamlin.parsec_generated.Transaction;
import com.yamlin.parsec_generated.TransactionList;
import com.yamlin.parsec_generated.TransactionSummary;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by yamlin on 2017/2/11.
 */
public class TransactionBO {
    @Inject private TransactionDAO dao;

    TransactionBO(TransactionDAO dao) {
        this.dao = dao;
    }

    public TransactionList getTransactions(String q) {
        if (q.contains("startTs=1451606400000") && q.contains("endTs=1483228799000")) {
            List<Transaction> l = dao.searchTransactionTsInterval(
                    new Long(1451606400000L), new Long(1483228799000L));
            return new TransactionList().setTransactions(l);
        }
        return null;
    }

    public TransactionSummary getTransactions(String q, String op) {
        TransactionSummary summary = new TransactionSummary();
        if (op == null || op.isEmpty()) {
            summary.setSummary(0);
        } else if ("highest".equals(op)) {
            summary.setSummary(dao.findHighestTransaction()).setOp(op);
        } else if ("average".equals(op)) {
            double average = dao.findAverageTransaction(q);
            summary.setSummary(average).setOp(op);
        }
        return summary;
    }
}
