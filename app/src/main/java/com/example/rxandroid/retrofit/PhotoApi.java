package com.example.rxandroid.retrofit;

import com.example.rxandroid.model.MarsPhoto;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PhotoApi {
    @GET("rovers/curiosity/photos")
    Observable<MarsPhoto> getLatestsPhotos(@Query("earth_date") String date, @Query("camera") String camera);
}
