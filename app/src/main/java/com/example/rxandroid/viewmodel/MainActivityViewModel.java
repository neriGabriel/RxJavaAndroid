package com.example.rxandroid.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxandroid.model.Mars;
import com.example.rxandroid.model.MarsPhoto;
import com.example.rxandroid.retrofit.RetrofitConfing;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<Mars> marsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<MarsPhoto> marsPhotoMutableLiveData = new MutableLiveData<>();

    private RetrofitConfing retrofitConfing;
    private RetrofitConfing retrofitConfingPhoto;

    public MainActivityViewModel() {
        this.retrofitConfing = new RetrofitConfing(false);
        this.retrofitConfingPhoto = new RetrofitConfing(true);
    }

    public void getLatestMarsWheater() {
        this.retrofitConfing.getMarsApi()

                .getLatestUpdate()

                //PARA NÃO RODAR NA MAIN THREAD SENÃO DA B.O DE MAIN THREA || faço inscriçam em uma thread || inscreve uma nova thread
                .subscribeOn(Schedulers.newThread())

                //OBSERVO EM OUTRA || recebo na main thread
                .observeOn(AndroidSchedulers.mainThread())

                //Faz um map dos objetos
                .map(new Function<Mars, Mars>() {
                    @Override
                    public Mars apply(Mars mars) throws Throwable {
                        mars.setSeason(mars.getSeason().toUpperCase());
                        return mars;
                    }
                })


                //O consumer é mais simples, pois é uma unica requisição
                .subscribe(new Consumer<Mars>() {
                    @Override
                    public void accept(Mars mars) throws Throwable {
                        marsMutableLiveData.setValue(mars);
                    }
                });
    }

    public void getMarsPhoto(){
        this.retrofitConfingPhoto.getPhotoApi()
                .getLatestsPhotos("2020-5-29", "fhaz")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MarsPhoto>() {
                    @Override
                    public void accept(MarsPhoto marsPhoto) throws Throwable {
                        marsPhotoMutableLiveData.setValue(marsPhoto);
                    }
                });
    }
}
