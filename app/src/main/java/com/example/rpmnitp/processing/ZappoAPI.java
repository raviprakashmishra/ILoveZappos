package com.example.rpmnitp.processing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rpmnitp on 1/26/2017.
 */


public interface ZappoAPI {
    @GET("/Search?")
    Call<ZappoProducts> searchProducts(@Query("term") String tags,@Query("key") String key);




}
