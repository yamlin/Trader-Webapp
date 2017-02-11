package com.yamlin;

import com.yamlin.BO.TraderBO;
import com.yamlin.BO.TransactionBO;
import com.yamlin.DAO.TraderDAO;
import com.yamlin.DAO.TransactionDAO;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.yamlin.parsec_generated.ParsecApplication;

/**
 * This is the entry point of Jersey, which is defined in web.xml.
 */
@SuppressWarnings("unused")
public class DefaultApplication extends ParsecApplication {

    /**
     * Default constructor.
     */
    public DefaultApplication() {
        // Parsec default bindings and registers
        super();

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                // Add additional binding here
                // bind(<implementation>.class).to(<interface>.class)
                bind(TransactionBO.class).to(TransactionBO.class);
                bind(TraderBO.class).to(TraderBO.class);
                bind(TraderDAO.class).to(TraderDAO.class);
                bind(TransactionDAO.class).to(TransactionDAO.class);
            }
        });

        // Add additional register here
        // register(<resource>.class)
    }
}
