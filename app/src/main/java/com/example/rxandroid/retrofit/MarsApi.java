package com.example.rxandroid.retrofit;

import com.example.rxandroid.model.Mars;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MarsApi {
    @GET("weather/latest")
    Observable<Mars> getLatestUpdate();
}
