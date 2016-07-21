package org.mifos.selfserviceapp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.mifos.selfserviceapp.R;
import org.mifos.selfserviceapp.ui.adapters.ViewPagerAdapter;
import org.mifos.selfserviceapp.ui.fragments.LoanAccountsListFragment;
import org.mifos.selfserviceapp.ui.fragments.SavingAccountsListFragment;
import org.mifos.selfserviceapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Vishwajeet
 * @since 17/07/16
 */

public class ClientAccountsActivity extends BaseActivity {


    private int clientId;

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_accounts);
        ButterKnife.bind(this);

        clientId = getIntent().getExtras().getInt(Constants.CLIENT_ID);

        setUpViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(SavingAccountsListFragment.newInstance(clientId), getString(R.string.saving_accounts));
        viewPagerAdapter.addFragment(LoanAccountsListFragment.newInstance(clientId), getString(R.string.loan_accounts));
        viewPager.setAdapter(viewPagerAdapter);
    }
}
