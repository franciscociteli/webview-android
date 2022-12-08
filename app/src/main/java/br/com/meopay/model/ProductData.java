package br.com.meopay.model;


import com.google.gson.annotations.SerializedName;

public class ProductData {

    @SerializedName("_id")
    private String id;

    @SerializedName("product_key")
    private String productKey;

    private String url;

    @SerializedName("product_name")
    private String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
