package org.mifos.selfserviceapp.presenters;

import android.content.Context;

import org.mifos.selfserviceapp.api.DataManager;
import org.mifos.selfserviceapp.injection.ActivityContext;
import org.mifos.selfserviceapp.presenters.base.BasePresenter;
import org.mifos.selfserviceapp.ui.views.LoanAccountsListView;

import javax.inject.Inject;

/**
 * @author Vishwajeet
 * @since 18/07/16
 */
public class LoanAccountsListPresenter extends BasePresenter<LoanAccountsListView>{
    private DataManager dataManager;

    /**
     * Initialises the LoanAccountsListPresenter by automatically injecting an instance of
     * {@link DataManager} and {@link Context}.
     *
     * @param dataManager DataManager class that provides access to the data
     *                    via the API.
     * @param context     Context of the view attached to the presenter. In this case
     *                    it is that of an {@link android.support.v7.app.AppCompatActivity}
     */
    @Inject
    public LoanAccountsListPresenter(DataManager dataManager, @ActivityContext Context context) {
        super(context);
        this.dataManager = dataManager;
    }

    public void fetchLoanAccountsList(int clientId) {

    }
}
