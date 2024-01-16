package com.example.project.retrofit;


import com.example.project.model.Calculator;
import com.example.project.model.RateUs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RateUsApi {
    @GET("/rateus/get-all")
    Call<List<RateUs>> getAllRateUs();

    @POST("/rateus/save")
    Call<RateUs> createPost(@Body RateUs rateUs);

    @POST("/rateus/save")
    Call<RateUs> save(@Body RateUs rateUs);

}
