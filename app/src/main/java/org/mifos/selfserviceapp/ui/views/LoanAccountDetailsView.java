package org.mifos.selfserviceapp.ui.views;

import org.mifos.selfserviceapp.data.accounts.LoanAccount;
import org.mifos.selfserviceapp.ui.views.base.MVPView;

/**
 * @author Vishwajeet
 * @since 19/08/16
 */

public interface LoanAccountDetailsView extends MVPView {
        /**
         * Should be called when loan account object can successfully accessed
         * from the server to display loan account details on the screen.
         *
         * @param loanAccount object containing details of each loan account,
         *                      received from server.
         */
        void showLoanAccountsDetail(LoanAccount loanAccount);

        /**
         * Should be called if there is any error from client side in getting
         * loan account object from server.
         *
         * Reason for error should be mentioned clearly to the user.
         *
         * @param message Error message to display showing reason of failure in getting
         *                loan account object
         */
        void showErrorFetchingLoanAccountsDetail(String message);
    }
