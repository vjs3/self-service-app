package org.mifos.selfserviceapp.api.services;

import org.mifos.selfserviceapp.api.ApiEndPoints;
import org.mifos.selfserviceapp.data.ChargeListResponse;
import org.mifos.selfserviceapp.data.TransactionsListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vjs3 on 17/8/16.
 */
public interface ClientChargeService {
    @GET(ApiEndPoints.CLIENTS + "/{clientId}/charges")
    Call<ChargeListResponse> getClientChargeList(@Path("clientId") int clientId);
}
