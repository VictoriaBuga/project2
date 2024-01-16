package com.example.project.retrofit;

import com.example.project.model.RateUs;
import com.example.project.model.Tasks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TasksApi {
    @GET("/tasks/get-all")
    Call<List<Tasks>> getAllTasks();

    @POST("/tasks/save")
    Call<Tasks> createPost(@Body Tasks tasks);

    @POST("/tasks/save")
    Call<Tasks> save(@Body Tasks tasks);

}
