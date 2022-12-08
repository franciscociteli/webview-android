package br.com.meopay.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("serial")
public class OrderData implements Serializable {

    private Integer id;
    private BigDecimal totalValue;
    private String status;
    private String paymentCode;
    private String serialNumber;
    private String phone;
    private CompanyData company;
    private Integer externalId;
    private Boolean printProducts;
    private String tableId;

    private List<ProductOrder> productOrders;

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public CompanyData getCompany() {
        return company;
    }

    public void setCompany(CompanyData company) {
        this.company = company;
    }

    public Boolean getPrintProducts() {
        return printProducts;
    }

    public void setPrintProducts(Boolean printProducts) {
        this.printProducts = printProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public boolean isPrintProducts() {
        return this.printProducts != null && this.printProducts;
    }
}
