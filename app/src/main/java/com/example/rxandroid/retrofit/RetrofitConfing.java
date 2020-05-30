package com.example.rxandroid.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfing {
    private final Retrofit retrofit;
    private String baseURL = "https://api.mars.spacexcompanion.app/v1/";

    public RetrofitConfing() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public MarsApi getMarsApi() {
        return this.retrofit.create(MarsApi.class);
    }
}
