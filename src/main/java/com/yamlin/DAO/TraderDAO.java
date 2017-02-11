package com.yamlin.DAO;

import com.yamlin.parsec_generated.Trader;
import com.yamlin.parsec_generated.TraderList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yamlin on 2017/2/11.
 */
public class TraderDAO {

    public List<Trader> getTraderFrom(String city) {
        if (city.equals("Singapore")) {
            List<Trader> traderList = new ArrayList<>();
            traderList.add(new Trader().setCity("Singapore").setId("1").setName("user1"));
            traderList.add(new Trader().setCity("Singapore").setId("2").setName("user2"));
            return traderList;
        }

        return null;
    }
}
