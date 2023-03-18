package com.example.example;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView gifView = findViewById(R.id.iv_gif);

//        Glide.with(this).load(R.drawable.gif).into(gifView);


        Glide.with(this)
                .asGif()
                .load(R.raw.gif)
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (resource != null) {
                            Log.d("test", "gif 실행");
                            resource.setLoopCount(1);
                        }
                        return false;
                    }
                })
                .into(gifView);


        /**
         * Retrofit 객체 생성
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApiService retrofitApiService = retrofit.create(RetrofitApiService.class);
        retrofitApiService.getData("1").enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> userInfo = (List<Post>) response.body();
                    if (userInfo != null) {
                        Log.e("test", "isSuccesful~~!!");
                        Log.e("test", userInfo.get(0).getTitle());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("test", "실패~~!!");
                Log.e("test", t.toString());
            }
        });

    }
}