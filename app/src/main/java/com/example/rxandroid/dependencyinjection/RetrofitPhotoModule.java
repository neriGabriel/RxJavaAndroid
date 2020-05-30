package com.example.rxandroid.dependencyinjection;

import com.example.rxandroid.retrofit.PhotoApi;
import com.example.rxandroid.retrofit.RetrofitConfing;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class RetrofitPhotoModule {

    private String photoBaseURL = "http://mars-photos.herokuapp.com/api/v1/";

    @Provides
    public PhotoApi getRetrofitConfig() {
        return new Retrofit.Builder()
                .baseUrl(this.photoBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PhotoApi.class);
    }
}
