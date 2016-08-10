package org.mifos.selfserviceapp.api.services;

import org.mifos.selfserviceapp.api.ApiEndPoints;
import org.mifos.selfserviceapp.data.Transaction;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vjs3 on 10/8/16.
 */
public interface RecentTransactionsService {
    @GET(ApiEndPoints.CLIENTS + "/{clientId}/transactions")
    Call<Transaction> getRecentTransactionsList(@Path("clientId") int clientId);

}
