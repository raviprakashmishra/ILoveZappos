package com.example.rpmnitp.processing;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rpmnitp on 1/26/2017.
 */

public class Product {
    private String brandName;

    public Product(String productId) {
        this.brandName = productId;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String productId) {
        this.brandName = productId;
    }

    @Override
    public String toString() {
        return(brandName);
    }
}
