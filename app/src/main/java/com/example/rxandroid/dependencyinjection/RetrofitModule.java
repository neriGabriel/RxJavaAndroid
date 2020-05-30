package com.example.rxandroid.dependencyinjection;

import com.example.rxandroid.retrofit.MarsApi;
import com.example.rxandroid.retrofit.RetrofitConfing;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private String marsBaseURL  = "https://api.mars.spacexcompanion.app/v1/";


    @Provides
    public MarsApi getRetrofitConfig() {
        return new Retrofit.Builder()
                .baseUrl(this.marsBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MarsApi.class);
    }
}
