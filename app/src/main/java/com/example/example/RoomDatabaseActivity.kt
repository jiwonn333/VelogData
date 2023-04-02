package com.example.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.example.databinding.ActivityRoomDbBinding
import com.example.example.room.MyAdapter
import com.example.example.room.RoomDatabase
import com.example.example.room.UserViewModel
import com.example.example.room.dialog.CustomDialog
import com.example.example.room.dialog.CustomDialogInterface
import com.example.example.room.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RoomDatabaseActivity : AppCompatActivity(), CustomDialogInterface {

    private lateinit var customDialog: CustomDialog
    private lateinit var btnFab: FloatingActionButton
    private lateinit var binding: ActivityRoomDbBinding
    private lateinit var userViewModel: UserViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_db)
        userViewModel = ViewModelProvider(this, UserViewModel.Factory(application)).get(UserViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_db)
        binding.recyclerView.layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)

        // 어댑터 연결
        val adapter = MyAdapter()
        binding.recyclerView.adapter = adapter


        userViewModel.userAllData.observe(this, Observer {
            adapter.setData(it as ArrayList<User>)
        })


        btnFab = findViewById(R.id.floatingActionButton)
        btnFab.setOnClickListener {
            customDialog = CustomDialog(this, this)
            customDialog.show()

        }
    }

    override fun onAddButtonClicked(userId: String, userPw: String) {
        val user = User(0, userId, userPw)
        userViewModel.insertUser(user)
        Toast.makeText(this, "이름 : $userId , 비밀번호 : $userPw 추가", Toast.LENGTH_SHORT).show()
    }

    override fun onCancelButtonClicked() {
        Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show()
    }
}