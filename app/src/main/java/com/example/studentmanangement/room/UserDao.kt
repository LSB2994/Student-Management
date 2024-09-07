package com.example.studentmanangement.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.studentmanangement.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAllUser(): Flow<List<User>>
    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUserById(id:Int):Flow<User>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    @Query("SELECT * FROM user_table WHERE gmail = :gmail AND password = :password")
    fun authUser(gmail:String,password:String):Flow<User>
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
}