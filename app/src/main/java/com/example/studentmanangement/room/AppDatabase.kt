package com.example.studentmanangement.room

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import com.example.studentmanangement.models.User

@Database(
    entities = [User::class],
    exportSchema = false,
    version = 1
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
}