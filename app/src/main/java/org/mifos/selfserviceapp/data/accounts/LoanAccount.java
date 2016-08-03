package org.mifos.selfserviceapp.data.accounts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishwajeet
 * @since 22/06/16.
 */
public class LoanAccount {
    private int id;
    private String accountNo;
    private String productName;
    private List<LoanAccount> pageItems = new ArrayList<LoanAccount>();

    public List<LoanAccount> getPageItems() {
        return pageItems;
    }

    public void setLoanAccounts(List<LoanAccount> loanAccounts) {
        this.pageItems = loanAccounts;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
