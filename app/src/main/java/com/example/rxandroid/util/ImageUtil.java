package com.example.rxandroid.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rxandroid.model.MarsPhoto;

import java.util.Random;

public class ImageUtil {

    /*
    * CRIO UM PROGRESS DRAWABLE
    * */
    public static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(50f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }

    /*
    * SETO NA TELA COM O PROGRESS DRAWABLE
    * */
    public static void setImageView(String url, ImageView image) {
        Random random = new Random();

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(getProgressDrawable(image.getContext()))
                .fitCenter();

        Glide.with(image.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(image);
    }

    /*
    * Binding adapter
    */
    //A tag @Binding adapter automaticamente irá automaticamente setar em todos os elementos imageview com a tag
    //android:imageUrl setada, example => android:imageUrl="@{marsPhotos.img_src}"
    //poderia ser qualquer tag disponivel, ou uma tag minha criada
    //é do databinding
    @BindingAdapter("android:imageUrl")
    public static void bindingImageSource(ImageView v, String url) {
        setImageView(url, v);
    }
}
