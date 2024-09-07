package com.example.studentmanangement.reppositories

import com.example.studentmanangement.models.User

interface UserRepository {
    fun insertUser(user: User)
    fun deleteUser(user: User)
    fun updateUser(user: User)
}