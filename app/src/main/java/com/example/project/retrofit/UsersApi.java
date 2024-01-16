package com.example.project.retrofit;

import com.example.project.model.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsersApi
{
    @GET("/user/get-all")
    Call<List<Users>> getAllUsers();

    @POST("/user/save")
    Call<Users> createPost(@Body Users users);

    @POST("/user/save")
    Call<Users> save(@Body Users users);
}
