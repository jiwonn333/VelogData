package com.example.example

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.example.api.RetrofitApiService
import com.example.example.model.example1.Post
import com.example.example.navigation.BottomNavigationActivity
import com.example.example.recyclerview.GitActivity
import com.example.example.retrofit.RetrofitApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var context: Context? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        val gifView = findViewById<ImageView>(R.id.iv_gif)
//        Glide.with(this).load(R.drawable.gif).into(gifView);
        Glide.with(this)
            .asGif()
            .load(R.raw.gif)
            .listener(object : RequestListener<GifDrawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: Target<GifDrawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any,
                    target: Target<GifDrawable?>,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    if (resource != null) {
                        Log.d("test", "gif 실행")
                        resource.setLoopCount(1)
                    }
                    return false
                }
            })
            .into(gifView)
        /**
         * Retrofit 객체 생성
         */
        val retrofitApiService = RetrofitApiManager.Build().create(
            RetrofitApiService::class.java
        )
        retrofitApiService.getData("1").enqueue(object : Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                if (response.isSuccessful) {
                    val userInfo = response.body()
                    if (userInfo != null) {
                        Log.e("test", "isSuccesful~~!!")
                        Log.e("test", userInfo[0].title)
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                Log.e("test", "실패~~!!")
                Log.e("test", t.toString())
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_bottom_navigation -> {
                val intent = Intent(context, BottomNavigationActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_github_retrofit -> {
                val intent = Intent(context, GitActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_room_db -> {
                val intent = Intent(context, RoomDatabaseActivity::class.java)
                startActivity(intent)
            }

        }
    }
}