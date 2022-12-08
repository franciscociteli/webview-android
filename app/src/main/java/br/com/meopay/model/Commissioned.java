package br.com.meopay.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Commissioned {

    @SerializedName("commisioned_id")
    private Integer id;


    private String document;
    private String name;
    private Double fee;

    @SerializedName("commission_type")
    private String commissionedType;

    public Commissioned(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getCommissionedType() {
        return commissionedType;
    }

    public void setCommissionedType(String commissionedType) {
        this.commissionedType = commissionedType;
    }
}
