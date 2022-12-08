package br.com.meopay.util;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.meopay.model.OrderData;

@SuppressWarnings("serial")
public class TransactionToken implements Serializable {

    private Boolean automaticPrice;
    private Boolean split;
    private String splitMode;
    private String commissioned;
    private String commissionedType;
    private Double fee;
    private OrderData orderData;
    private BigDecimal freePrice;

    public BigDecimal getFreePrice() {
        return freePrice;
    }

    public void setFreePrice(BigDecimal freePrice) {
        this.freePrice = freePrice;
    }

    public String getCommissionedType() {
        return commissionedType;
    }

    public void setCommissionedType(String commissionedType) {
        this.commissionedType = commissionedType;
    }

    public String getSplitMode() {
        return splitMode;
    }

    public void setSplitMode(String splitMode) {
        this.splitMode = splitMode;
    }

    public Boolean getAutomaticPrice() {
        return automaticPrice;
    }

    public void setAutomaticPrice(Boolean automaticPrice) {
        this.automaticPrice = automaticPrice;
    }

    public Boolean getSplit() {
        return split;
    }

    public void setSplit(Boolean split) {
        this.split = split;
    }

    public String getCommissioned() {
        return commissioned;
    }

    public void setCommissioned(String commissioned) {
        this.commissioned = commissioned;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }

    public boolean isSplit() {
        return this.split != null && this.split;
    }

    public boolean isAutomaticPrice() {
        return this.automaticPrice != null && this.automaticPrice;
    }
}
