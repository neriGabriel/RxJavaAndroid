package com.example.rxandroid.dependencyinjection;

import com.example.rxandroid.retrofit.RetrofitConfing;
import com.example.rxandroid.viewmodel.MainActivityViewModel;

import dagger.Component;
import dagger.Provides;

@Component(modules = {RetrofitModule.class, RetrofitPhotoModule.class})
public interface RetrofitComponent {

    void inject(MainActivityViewModel mainActivityViewModel);
}
