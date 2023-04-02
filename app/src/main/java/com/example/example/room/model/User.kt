package com.example.example.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * table 정의
 */
@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    var num:Int,

    @ColumnInfo
    var userid: String?,

    @ColumnInfo
    var password: String?,

//    @ColumnInfo
//    var username: String?,
//
//    @ColumnInfo
//    var phone: String?
)
