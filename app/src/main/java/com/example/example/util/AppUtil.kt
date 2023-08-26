package com.example.example.util

import android.content.Context
import android.widget.Toast

object AppUtil {
    @JvmStatic
    fun showToast(context: Context?, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}