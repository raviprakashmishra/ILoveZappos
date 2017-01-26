package com.example.rpmnitp.model;

/**
 * Created by rpmnitp on 1/26/2017.
 */

public class Product {
    private String displayName;

    private String url;


    public  Product(String displayName, String url){
        this.displayName = displayName;
        this.url = url;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUrl() {
        return url;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
