package br.com.meopay.model;

import java.util.List;

public class CommissionedResponse {

    private List<Commissioned> commissioneds;

    public CommissionedResponse() {}

    public List<Commissioned> getCommissioneds() {
        return commissioneds;
    }

    public void setCommissioneds(List<Commissioned> commissioneds) {
        this.commissioneds = commissioneds;
    }
}
