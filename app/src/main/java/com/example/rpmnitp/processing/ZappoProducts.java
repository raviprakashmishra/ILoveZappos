package com.example.rpmnitp.processing;

/**
 * Created by rpmnitp on 1/26/2017.
 */


import java.util.ArrayList;
import java.util.List;


/**
 * collection of Products
 */
public class ZappoProducts {
    List<Product> results  = new ArrayList<>();

    public List<Product> getProducts() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p:results){
            sb.append(p.getBrandName()+",");
        }
        return sb.toString();
    }
}