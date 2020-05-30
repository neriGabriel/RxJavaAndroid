package com.example.rxandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rxandroid.R;
import com.example.rxandroid.model.Mars;
import com.example.rxandroid.retrofit.RetrofitConfing;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


//Base da programação reativa é definir observadores e observaveis.
//Ler mais sobre RxJava
public class MainActivity extends AppCompatActivity {

    private RetrofitConfing retrofitConfing;
    TextView textView;
    TextView textTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.retrofitConfing = new RetrofitConfing();
        textView = findViewById(R.id.textView3);
        textTemp = findViewById(R.id.tempAvarage);

        this.retrofitConfing.getMarsApi()
                .getLatestUpdate()
                //PARA NÃO RODAR NA MAIN THREAD SENÃO DA B.O DE MAIN THREA || faço inscriçam em uma thread || inscreve uma nova thread
                .subscribeOn(Schedulers.newThread())
                //OBSERVO EM OUTRA || recebo na main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Mars>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("MainActivity", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Mars mars) {
                Log.d("MainActivity", mars.getSeason());
                textView.setText( mars.getSeason());
                textTemp.setText( String.valueOf(mars.getAir().getTemperature().getAverage()));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("MainActivity", e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("MainActivity", "onComplete");
            }
        });

    }
}
