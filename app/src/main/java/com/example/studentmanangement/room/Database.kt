package com.example.studentmanangement.room

import androidx.room.Database
import com.example.studentmanangement.models.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class Database {
    abstract fun UserDao():UserDao
}