package com.yamlin.BO;

import com.yamlin.DAO.TraderDAO;
import com.yamlin.parsec_generated.Trader;
import com.yamlin.parsec_generated.TraderList;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yamlin on 2017/2/11.
 */
public class TraderBO {
    @Inject
    private TraderDAO traderDAO;

    TraderBO(TraderDAO dao) {
        this.traderDAO = dao;
    }

    public List<Trader> getTrader(String q, Long offset, Integer count, String orderBy) {
        if (q.equals("city=Singapore")) {
            List<Trader> result = traderDAO.getTraderFrom("Singapore");
            // do order by...
            return result;
        }
        return new ArrayList<>();
    }

}
