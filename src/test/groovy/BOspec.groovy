/**
 * Created by yamlin on 2017/2/11.
 */
package com.yamlin.BO;

import com.yamlin.BO.TraderBO
import com.yamlin.DAO.TraderDAO
import com.yamlin.DAO.TransactionDAO
import com.yamlin.parsec_generated.TransactionSummary
import org.junit.Assert
import spock.lang.*

class BOspec extends Specification {
    @Shared def traderDao = new TraderDAO();
    @Shared def transactionDao = new TransactionDAO();
    @Shared def traderBo = new TraderBO(traderDao)
    @Shared def transactionBo = new TransactionBO(transactionDao);

    def setup() {

    }

    def "test Trader BO"() {
        expect:
        def result = traderBo.getTrader("city=Singapore", 0, 0, "")
        result.size() == 2
    }

    def "test getTransactions"() {
        expect:
        def result = transactionBo.getTransactions(
                "startTs=1451606400000+endTs=1483228799000", "", 0, "")
        result.size() == 1
        result.get(0).getValue() == 205
    }

    def "test getTransactionSummary"() {
        expect:
        TransactionSummary result = transactionBo.getTransactions("trader.city=Beijing", "average")
        result.getSummary() == 200.5
    }
}