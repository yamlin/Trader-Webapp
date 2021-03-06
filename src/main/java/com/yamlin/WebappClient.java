//
// This file is generated by parsec-rdl-gen (development version)
// WILL NOT be auto-generated if file has already existed.
//
package com.yamlin;

import java.util.concurrent.CompletableFuture;
import com.yamlin.parsec_generated.ResourceException;
import com.yamlin.parsec_generated.Trader;
import com.yamlin.parsec_generated.Transaction;
import com.yamlin.parsec_generated.TraderList;
import com.yamlin.parsec_generated.TransactionList;


public interface WebappClient {

    CompletableFuture<TraderList> getInt64(String matric, String city, int offset, int limit, String fieldName, byte isDesc, long createdTsStart, long createdTsEnd) throws ResourceException;
    CompletableFuture<TransactionList> getTransactionList(String matric, int offset, int limit, String fieldName, byte isDesc) throws ResourceException;
    CompletableFuture<String> getString(String matric, String city, int offset, int limit) throws ResourceException;
}
