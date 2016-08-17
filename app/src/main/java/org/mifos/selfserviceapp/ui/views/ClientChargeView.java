package org.mifos.selfserviceapp.ui.views;

import org.mifos.selfserviceapp.data.Charge;
import org.mifos.selfserviceapp.ui.views.base.MVPView;

import java.util.List;

/**
 * @author Vishwajeet
 * @since 17/8/16.
 */
public interface ClientChargeView extends MVPView{
    /**
     * Should be called if there is any error from client side in loading the recent transactions
     * from server.
     * Reason for error should be mentioned clearly to the user.
     *
     * @param message Error message to display showing reason of failure in loading recent
     *                transactions.
     */
    void showErrorFetchingRecentClientCharges(String message);

    /**
     * Use to display List of recent transactions for the respective client.
     *
     * @param recentClientChargesList List containing recent transactions of a particular client
     */
    void showRecentClientCharges(List<Charge> recentClientChargesList);
}
