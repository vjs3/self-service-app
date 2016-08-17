package org.mifos.selfserviceapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vjs3 on 17/8/16.
 */

public class ChargeListResponse {
    private List<Charge> pageItems = new ArrayList<>();

    public List<Charge> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Charge> transactions) {
        this.pageItems = transactions;
    }
}
