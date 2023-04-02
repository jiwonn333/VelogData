package com.example.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.example.room.dao.UserDao
import com.example.example.room.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class RoomDatabase: androidx.room.RoomDatabase() {

    abstract fun getUserDao(): UserDao
    companion object {
        private var instance: RoomDatabase? = null


        /**
         * singleton으로 생성
         * 자주 생성 시 성능 손해로, 이미 존재할 경우 생성하지 않고 바로 반환
         */
        @Synchronized
        fun getInstance(context: Context): RoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    RoomDatabase::class.java, "user_table")
//                    .fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}