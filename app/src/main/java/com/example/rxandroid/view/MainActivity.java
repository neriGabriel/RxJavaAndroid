package com.example.rxandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rxandroid.R;
import com.example.rxandroid.databinding.ActivityMainBinding;
import com.example.rxandroid.model.Mars;
import com.example.rxandroid.model.MarsPhoto;
import com.example.rxandroid.viewmodel.MainActivityViewModel;

import java.util.Random;


//Base da programação reativa é definir observadores e observaveis.
//Ler mais sobre RxJava
public class MainActivity extends AppCompatActivity {
    //Crio um objeto do data binding
    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inicio o objeto do data binding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Acesso a variavel na view
        activityMainBinding.setMarsStatus(null);
        //Se quiser ter acesso ao componente é só usar activityMainBinding.getRoot()...
        activityMainBinding.getRoot();

        //Acessando minha viewmodel
        this.mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        this.mainActivityViewModel.getLatestMarsWheater();
        reciveMarsStatus();
        this.mainActivityViewModel.getMarsPhoto();
        reciveMarsPhoto();
    }

    private void reciveMarsStatus() {
        this.mainActivityViewModel.marsMutableLiveData.observe(this, new Observer<Mars>() {
            @Override
            public void onChanged(Mars mars) {
                activityMainBinding.setMarsStatus(mars);
            }
        });
    }

    private void reciveMarsPhoto() {
        this.mainActivityViewModel.marsPhotoMutableLiveData.observe(this, new Observer<MarsPhoto>() {
            @Override
            public void onChanged(MarsPhoto marsPhoto) {
                Random random = new Random();
                int randomNumber = random.nextInt(marsPhoto.getPhotos().size());
                //Esquema de espera enquanto carrega
                RequestOptions requestOptions = new RequestOptions()
                        .placeholder(android.R.drawable.btn_plus)
                        .fitCenter();

                Glide.with(getApplicationContext())
                        .setDefaultRequestOptions(requestOptions)
                        .load(marsPhoto.getPhotos().get(randomNumber).getImg_src())
                        .into(activityMainBinding.imageView);
            }
        });
    }
}
