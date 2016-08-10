package org.mifos.selfserviceapp.data;


import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by vjs3 on 10/8/16.
 */

public class Transaction {
    private int id;
    private List<Transaction> pageItems = new ArrayList<Transaction>();
    private List<Integer> submittedOndate = new ArrayList<Integer>();
    private int amount;

    public List<Transaction> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Transaction> pageItems) {
        this.pageItems = pageItems;
    }

    public List<Integer> getSubmittedOndate() {
        return submittedOndate;
    }

    public void setSubmittedOndate(List<Integer> submittedOndate) {
        this.submittedOndate = submittedOndate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
