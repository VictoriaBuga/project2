package com.example.project.retrofit;




import com.example.project.model.Calculator;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CalculatorApi {
    @GET("/calculator/get-all")
    Call<List<Calculator>> getAllCalculator();

    @POST("/calculator/save")
    Call<Calculator> createPost(@Body Calculator calculator);

    @POST("/calculator/save")
    Call<Calculator> save(@Body Calculator calculator);

}
