package com.yamlin.BO;

import com.yamlin.DAO.TraderDAO;
import com.yamlin.parsec_generated.TraderList;

import javax.inject.Inject;

/**
 * Created by yamlin on 2017/2/11.
 */
public class TraderBO {
    @Inject
    private TraderDAO traderDAO;

    TraderBO(TraderDAO dao) {
        this.traderDAO = dao;
    }

    public TraderList getTrader(String q, String sinceId, Integer count, String orderBy) {
        if (q.equals("city=Singapore")) {
            TraderList l = new TraderList();
            l.setTraders(traderDAO.getTraderFrom("Singapore"));
            return l;
        }

        return null;
    }

}
