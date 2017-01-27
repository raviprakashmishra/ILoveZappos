package com.example.rpmnitp.processing;

import android.app.ListActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.rpmnitp.ilovezappos.IConstant;

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

public class RestAPIProcessing implements Callback<ZappoProducts>{

    private String prod;
    private String products;
    private ListActivity activity;
    private Adapter adapter;

    public RestAPIProcessing(ListActivity activity, Adapter adapter){
        this.activity = activity;
        this.adapter = adapter;
    }
    public void setPrdToSearch(String prod){
        this.prod = prod;
    }


    public void callRestAPI(){
       // https://api.zappos.com/Search?term=nike&key=b743e26728e16b81da139182bb2094357c31d331

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.zappos.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        ZappoAPI zappoAPI = retrofit.create(ZappoAPI.class);

        Call<ZappoProducts> call = zappoAPI.searchProducts(this.prod, IConstant.API_KEY);
        //asynchronous call
        call.enqueue(this);

        String url = call.request().url().toString();
        Log.d("url is",url);
        Log.d("url is",url);
    }


    @Override
    public void onResponse(Call<ZappoProducts> call, Response<ZappoProducts> response) {
        String body = response.body().toString();
        //Log.d("url is",url);

        List<Product> items = response.body().items;
        String[] values = new String[items.size()];


        for (int i=0;i<items.size();i++){
            values[i] = items.get(i).getDisplayName();
        }

        ArrayAdapter<String> adapter = (ArrayAdapter<String>) this.adapter;
        adapter.clear();
        adapter.addAll(values);



    }

    @Override
    public void onFailure(Call<ZappoProducts> call, Throwable t) {
        Log.d("url is","");

    }


    public String getProducts() {
        return products;
    }



}
