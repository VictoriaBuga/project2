package com.example.project.retrofit;


import com.example.project.model.UsersDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsersDetailsApi
{
    @GET("/usersDetails/get-all")
    Call<List<UsersDetails>> getAllUsersDetails();

    @POST("/usersDetails/save")
    Call<UsersDetails> createPost(@Body UsersDetails users);

    @POST("/usersDetails/save")
    Call<UsersDetails> save(@Body UsersDetails users);


}

