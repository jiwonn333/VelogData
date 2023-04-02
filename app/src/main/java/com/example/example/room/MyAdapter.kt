package com.example.example.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.example.databinding.ActivityRoomDbBinding
import com.example.example.databinding.ItemListBinding
import com.example.example.room.model.User

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var userList = ArrayList<User>()

    class MyViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = userList[position]
        holder.binding.tvId.text = currentItem.userid.toString()
        holder.binding.tvPw.text = currentItem.password.toString()
    }

    // 유저 리스트 갱신
    fun setData(user : ArrayList<User>){
        userList = user
        notifyDataSetChanged()
    }

}