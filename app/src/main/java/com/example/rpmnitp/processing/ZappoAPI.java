package com.example.rpmnitp.processing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rpmnitp on 1/26/2017.
 */


public interface ZappoAPI {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<ZappoProducts> searchProducts(@Query("tagged") String tags);
}
