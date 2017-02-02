package com.example.rpmnitp.processing;

import android.app.ListActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.rpmnitp.ilovezappos.IConstant;
import com.example.rpmnitp.ilovezappos.ProductListActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by rpmnitp on 1/26/2017.
 */

public class RestAPIProcessingBuilder implements Callback<ZappoProducts>{

    private String prodName;
    private String products;
    private ListActivity activity;
    private Adapter adapter;
    private String[] prods;



    public RestAPIProcessingBuilder(ListActivity activity){

        this.activity = activity;
    }
    public RestAPIProcessingBuilder setPrdToSearch(String prod){
        this.prodName = prod;
        return this;
    }


    public RestAPIProcessingBuilder callRestAPI(){
       // https://api.zappos.com/Search?term=nike&key=b743e26728e16b81da139182bb2094357c31d331




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();






        // prepare call in Retrofit 2.0
        ZappoAPI zappoAPI = retrofit.create(ZappoAPI.class);

        Call<ZappoProducts> call = zappoAPI.searchProducts("nike", IConstant.API_KEY);
        //asynchronous call
        call.enqueue(this);


        String url = call.request().url().toString();
        return this;
    }


    @Override
    public void onResponse(Call<ZappoProducts> call, Response<ZappoProducts> response) {
        String body = response.body().toString();
        //Log.d("url is",url);
        boolean isSuccess = response.raw().isSuccessful();
        List<Product> products = new ArrayList<>();

        if(isSuccess){
            products = response.body().getProducts();
        }

         prods = new String[products.size()];


        String raw = response.raw().toString();
        System.out.println(body);
        //Log.d("response", raw);

        for (int i=0;i<products.size();i++){
            prods[i] = products.get(i).toString();
        }

        ((ProductListActivity)activity).updateListView(products);



    }

    @Override
    public void onFailure(Call<ZappoProducts> call, Throwable t) {
        Log.d("url is","");

    }


    public String[] getProducts() {

        return this.prods;
    }



}
