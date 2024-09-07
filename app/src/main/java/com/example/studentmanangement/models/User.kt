package com.example.studentmanangement.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "user_name")
    val userName:String,
    @ColumnInfo(name = "gmail")
    val gmail:String,
    @ColumnInfo(name = "password")
    val password:String
)
