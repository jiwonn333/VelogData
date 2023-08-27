package com.example.example.recyclerview

import androidx.recyclerview.widget.RecyclerView

interface ItemTouchHelperListener {
    fun onItemSwipe(position: Int)
    fun onLeftClick(position: Int, viewHolder: RecyclerView.ViewHolder?)
    fun onRightClick(position: Int, viewHolder: RecyclerView.ViewHolder?)
}