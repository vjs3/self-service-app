package org.mifos.selfserviceapp.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.mifos.selfserviceapp.R;
import org.mifos.selfserviceapp.presenters.LoanAccountsListPresenter;
import org.mifos.selfserviceapp.ui.activities.BaseActivity;
import org.mifos.selfserviceapp.ui.views.LoanAccountsListView;
import org.mifos.selfserviceapp.utils.Constants;
import org.mifos.selfserviceapp.utils.RecyclerItemClickListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Vishwajeet
 * @since 18/07/16
 */
public class LoanAccountsListFragment extends Fragment implements RecyclerItemClickListener.OnItemClickListener, LoanAccountsListView{

    @Inject
    LoanAccountsListPresenter mLoanAccountsListPresenter;

    private View rootView;
    private LinearLayoutManager layoutManager;
    private int clientId;

    @BindView(R.id.rv_loan_accounts_list)
    RecyclerView rvLoanAccountsList;
    @BindView(R.id.swipe_loan_container)
    SwipeRefreshLayout swipeLoanContainer;



    public static LoanAccountsListFragment newInstance(int clientId) {
        LoanAccountsListFragment loanAccountsListFragment = new LoanAccountsListFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.CLIENT_ID, clientId);
        loanAccountsListFragment.setArguments(args);
        return loanAccountsListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            clientId = getArguments().getInt(Constants.CLIENT_ID);
        setHasOptionsMenu(true);
        ((BaseActivity) getActivity()).getActivityComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_loan_accounts_list, container, false);
        ButterKnife.bind(this, rootView);

        mLoanAccountsListPresenter.attachView(this);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvLoanAccountsList.setLayoutManager(layoutManager);
        rvLoanAccountsList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), this));
        rvLoanAccountsList.setHasFixedSize(true);

        swipeLoanContainer.setColorSchemeResources(R.color.blue_light, R.color.green_light, R
                .color.orange_light, R.color.red_light);
        swipeLoanContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mLoanAccountsListPresenter.fetchLoanAccountsList(clientId);
            }
        });

        mLoanAccountsListPresenter.fetchLoanAccountsList(clientId);

        return rootView;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onItemClick(View childView, int position) {

    }

    @Override
    public void onItemLongPress(View childView, int position) {

    }
}
