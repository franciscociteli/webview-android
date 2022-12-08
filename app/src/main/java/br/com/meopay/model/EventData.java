package br.com.meopay.model;


import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class EventData {

    @SerializedName("event_id")
    private Integer id;

    @SerializedName("company_id")
    private Integer companyId;

    private String name;
    private String status;

    @SerializedName("serial_number")
    private String serialNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
