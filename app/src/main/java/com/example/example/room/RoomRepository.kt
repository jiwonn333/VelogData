package com.example.example.room

import androidx.lifecycle.LiveData
import com.example.example.room.dao.UserDao
import com.example.example.room.model.User

/**
 * 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할
 */
class RoomRepository(private val userDao: UserDao) {

    val userAllData: LiveData<List<User>> = userDao.userAllData()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }


}