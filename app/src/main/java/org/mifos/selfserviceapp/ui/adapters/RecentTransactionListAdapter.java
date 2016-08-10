package org.mifos.selfserviceapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mifos.selfserviceapp.R;
import org.mifos.selfserviceapp.data.Transaction;
import org.mifos.selfserviceapp.data.accounts.LoanAccount;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vjs3 on 10/8/16.
 */
public class RecentTransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private final LayoutInflater layoutInflater;
    private List<Transaction> transactionsList = new ArrayList<>();

    public RecentTransactionListAdapter(Context context, List<Transaction> transactionsList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.transactionsList = transactionsList;
    }

    public Transaction getItem(int position) {
        return transactionsList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.row_recent_transaction, parent, false);
        vh = new RecentTransactionListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerView.ViewHolder) {

            Transaction transaction = getItem(position);
            ((ViewHolder) holder).tvAmount.setText(String.valueOf(transaction.getAmount()));
            ((ViewHolder) holder).tvTransactionsDate.setText(transaction.getSubmittedOnDate().get(2).toString() +
                    "/" + transaction.getSubmittedOnDate().get(1).toString()+
                    "/" + transaction.getSubmittedOnDate().get(0).toString());
        }

    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_transactionDate)
        TextView tvTransactionsDate;
        @BindView(R.id.tv_amount)
        TextView tvAmount;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
