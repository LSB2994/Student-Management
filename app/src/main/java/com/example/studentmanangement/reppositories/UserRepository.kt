package com.example.studentmanangement.reppositories

import com.example.studentmanangement.models.User
import com.example.studentmanangement.room.AppDatabase
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDB: AppDatabase) {
    suspend fun insertUser(user: User) {
        userDB.userDao().insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDB.userDao().deleteUser(user)
    }

    suspend fun updateUser(user: User) {
        userDB.userDao().updateUser(user)
    }
    suspend fun auth(gmail:String,password:String){
        userDB.userDao().authUser(gmail,password)
    }
    suspend fun getAllUser() {
        userDB.userDao().getAllUser()
    }
    suspend fun getUserById(userId: Int){
        userDB.userDao().getUserById(userId)
    }
}