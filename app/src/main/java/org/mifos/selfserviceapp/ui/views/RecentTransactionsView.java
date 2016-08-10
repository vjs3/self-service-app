package org.mifos.selfserviceapp.ui.views;

import org.mifos.selfserviceapp.data.Transaction;
import org.mifos.selfserviceapp.data.accounts.LoanAccount;
import org.mifos.selfserviceapp.ui.views.base.MVPView;

import java.util.List;

/**
 * Created by vjs3 on 10/8/16.
 */

public interface RecentTransactionsView extends MVPView {
    void showErrorFetchingRecentTransactions(String message);

    void showRecentTransactions(List<Transaction> recentTransactionsList);}
