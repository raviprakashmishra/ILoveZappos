package com.example.rpmnitp.processing;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rpmnitp on 1/26/2017.
 */

public class Product {
    private String productId;

    public Product(String productId) {
        this.productId = productId;
    }


    public String getBrandName() {
        return productId;
    }

    public void setBrandName(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return(productId);
    }
}
