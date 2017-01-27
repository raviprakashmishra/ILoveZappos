package com.example.rpmnitp.processing;

/**
 * Created by rpmnitp on 1/26/2017.
 */

public class Product {
    private String brandName;

    private String productUrl;


    public Product(String brandName, String productUrl){
        this.brandName = brandName;
        this.productUrl = productUrl;
    }

    public String getDisplayName() {
        return brandName;
    }

    public String getUrl() {
        return productUrl;
    }


    public void setDisplayName(String brandName) {
        this.brandName = brandName;
    }

    public void setUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
