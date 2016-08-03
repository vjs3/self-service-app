package org.mifos.selfserviceapp.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import org.mifos.selfserviceapp.utils.Constants;
import org.mifos.selfserviceapp.utils.RecyclerItemClickListener;

/**
 * Created by vjs3 on 1/8/16.
 */

public class SavingAccountsListFragment extends Fragment implements RecyclerItemClickListener.OnItemClickListener{

    public static SavingAccountsListFragment newInstance(int clientId) {
        SavingAccountsListFragment fragment = new SavingAccountsListFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.CLIENT_ID, clientId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onItemClick(View childView, int position) {

    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }

}
