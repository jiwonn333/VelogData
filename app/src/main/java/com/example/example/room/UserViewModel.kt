package com.example.example.room

import android.app.Application
import androidx.lifecycle.*
import com.example.example.room.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
 */
class UserViewModel(application: Application) : AndroidViewModel(application) {

    val userAllData: LiveData<List<User>>
    private val repository: RoomRepository

    init {
        val userDao = RoomDatabase.getInstance(application)!!.getUserDao()
        repository = RoomRepository(userDao)
        userAllData = repository.userAllData
    }

    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }
    }

    /**
     *  ViewModel에 파라미터를 넘기기 위해서, 파라미터를 포함한 Factory 객체를 생성하기 위한 클래스
     */
    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(application) as T

        }
    }

}