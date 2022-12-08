package br.com.meopay.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

import io.reactivex.internal.operators.observable.ObservableAll;

@SuppressWarnings("serial")
public class CompanyData implements Serializable {

    private Integer id;
    private String name;
    private String document;
    private String splitMode;
    private Integer splitEnabled;
    private BigDecimal fee;
    private String operationType;
    private Boolean printProducts;

    public Boolean getPrintProducts() {
        return printProducts;
    }

    public void setPrintProducts(Boolean printProducts) {
        this.printProducts = printProducts;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSplitMode() {
        return splitMode;
    }

    public void setSplitMode(String splitMode) {
        this.splitMode = splitMode;
    }

    public Integer getSplitEnabled() {
        return splitEnabled;
    }

    public void setSplitEnabled(Integer splitEnabled) {
        this.splitEnabled = splitEnabled;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
