package com.example.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperListener {
    void onItemSwipe(int position);

    void onLeftClick(int position, RecyclerView.ViewHolder viewHolder);

    void onRightClick(int position, RecyclerView.ViewHolder viewHolder);
}
