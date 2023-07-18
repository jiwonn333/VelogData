package com.example.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.example.api.RetrofitApiService;
import com.example.example.model.example1.Post;
import com.example.example.navigation.BottomNavigationActivity;
import com.example.example.retrofit.RetrofitApiManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        TextView tvBottomNavigation = findViewById(R.id.tv_bottom_navigation);
        tvBottomNavigation.setOnClickListener(v -> {
            Intent intent = new Intent(context, BottomNavigationActivity.class);
            startActivity(intent);
        });

        Button btnGithub = findViewById(R.id.btn_github_retrofit);
        btnGithub.setOnClickListener(view -> {
            Intent intent = new Intent(context, GitActivity.class);
            startActivity(intent);
        });

        Button btnRoomDB = findViewById(R.id.btn_room_db);
        btnRoomDB.setOnClickListener(view -> {
            Intent intent = new Intent(context, RoomDatabaseActivity.class);
            startActivity(intent);
        });
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
        RetrofitApiService retrofitApiService = RetrofitApiManager.Build().create(RetrofitApiService.class);
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