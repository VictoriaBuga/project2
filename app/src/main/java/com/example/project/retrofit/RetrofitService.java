package com.example.project.retrofit;

import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {


        private Retrofit retrofit;


        public RetrofitService()
        {
            initializeRetrofit();
        }

        private void initializeRetrofit() {
            retrofit =  new Retrofit.Builder()
                    .baseUrl("http://192.168.0.167:8083")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }

        public Retrofit getRetrofit() {
            return retrofit;
        }
    }

