package org.mifos.selfserviceapp.presenters;

import android.content.Context;

import org.mifos.selfserviceapp.api.DataManager;
import org.mifos.selfserviceapp.data.accounts.LoanAccount;
import org.mifos.selfserviceapp.presenters.base.BasePresenter;
import org.mifos.selfserviceapp.ui.views.LoanAccountsListView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Vishwajeet
 * @since 30/07/16.
 */
public class LoanAccountsListPresenter extends BasePresenter<LoanAccountsListView>{
    private DataManager dataManager;

    /**
     * Initialises the ClientListPresenter by automatically injecting an instance of
     * {@link DataManager} and {@link Context}.
     *
     * @param dataManager DataManager class that provides access to the data
     *                    via the API.
     * @param context     Context of the view attached to the presenter. In this case
     *                    it is that of an {@link android.support.v7.app.AppCompatActivity}
     */

    @Inject
    public LoanAccountsListPresenter(DataManager dataManager, Context context) {
        super(context);
        this.dataManager = dataManager;
    }

    public void loadLoanAccountsList(int clientId) {
        Call<LoanAccount> call = dataManager.getLoanAccounts(clientId);
        getMvpView().showProgress();

        call.enqueue(new Callback<LoanAccount>() {
            @Override
            public void onResponse(Response<LoanAccount> response) {
                getMvpView().hideProgress();

                if (response.code() == 200) {
                    LoanAccount loanAccount = response.body();
                    List<LoanAccount> loanAccountsList = response.body().getPageItems();
                    if(loanAccount !=null) {
                        getMvpView().showLoanAccounts(loanAccountsList);
                    }

                } else if (response.code() >= 400 && response.code() <500) {
                    getMvpView().showErrorFetchingLoanAccounts(context.getString(R.string.error_loan_accounts_list_loading));
                } else if (response.code() == 500) {
                    getMvpView().showErrorFetchingLoanAccounts(context.getString(R.string.error_internal_server));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                getMvpView().hideProgress();
                getMvpView().showErrorFetchingLoanAccounts(context.getString(R.string.error_message_server));
            }
        });
    }
}
