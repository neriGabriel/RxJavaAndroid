package com.example.rxandroid.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rxandroid.R;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

//Base da programação reativa é definir observadores e observaveis.
//Ler mais sobre RxJava
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nome = "Gabriel";

        Observable<String> observable = Observable.just(nome);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
               // Toast.makeText(getApplicationContext(), "onSubscribe", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
               // Toast.makeText(getApplicationContext(), "onNext", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {
               // Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onError");
            }

            @Override
            public void onComplete() {
                // Toast.makeText(getApplicationContext(), "onComplete", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "onComplete");
            }
        };

        //assinatura
        observable.subscribe(observer);
    }
}
