package com.example.rpmnitp.processing;

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

    String prod;

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

        Call<ZappoProducts> call = zappoAPI.searchProducts("android");
        //asynchronous call
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<ZappoProducts> call, Response<ZappoProducts> response) {

    }

    @Override
    public void onFailure(Call<ZappoProducts> call, Throwable t) {

    }
}
