/**
 * Created by yamlin on 2017/2/11.
 */
package com.yamlin.BO;

import com.yamlin.BO.TraderBO
import com.yamlin.DAO.TraderDAO
import com.yamlin.DAO.TransactionDAO
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
        def result = traderBo.getTrader("city=Singapore", null, null, null)
        result != null
        result.getTraders().size() == 2
    }

    def "test Trader return null"() {
        expect:
        traderBo.getTrader("    ", null, null, null) == null
    }

    def "test getTransactions"() {
        expect:
        def result = transactionBo.getTransactions("startTs=1451606400000+endTs=1483228799000")
        result.getTransactions().size() == 1
        result.getTransactions().get(0).getValue() == 205
    }
}