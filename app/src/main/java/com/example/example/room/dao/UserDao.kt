package com.example.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.example.room.model.User

@Dao
interface UserDao {
    /**
     *  새로 들어온 user 정보 저장
     *  onConflict = OnConflictStrategy.IGNORE -> 동일한 아이디가 있을 경우 무시한다.
     *
     */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun userAllData(): LiveData<List<User>>

}