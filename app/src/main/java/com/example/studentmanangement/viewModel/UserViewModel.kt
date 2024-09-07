package com.example.studentmanangement.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentmanangement.models.User
import com.example.studentmanangement.room.UserDao
import com.example.studentmanangement.states.UserState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(
    private val dao: UserDao
):ViewModel() {
    var dataUser by mutableStateOf(UserState())
        private set
    init {
        viewModelScope.launch {
            dao.getAllUser().collectLatest {
                dataUser = dataUser.copy(
                    listUsers = it
                )
            }
        }
    }
    fun insertUser(user: User) = viewModelScope.launch {
        dao.insertUser(user)
    }
    fun deleteUser(user: User) = viewModelScope.launch {
        dao.deleteUser(user)
    }
    fun updateUser(user: User) = viewModelScope.launch {
        dao.updateUser(user)

    }
    fun getUserById(id:Int) = viewModelScope.launch {
        dao.getUserById(id)
    }
    val Context.dataStore by preferencesDataStore("settings")

    fun authUser(username:String,password:String,context: Context) = viewModelScope.launch {
        context.dataStore.edit {
            it[stringPreferencesKey("gmail")] = username
            it[stringPreferencesKey("password")] = password
        }
        dao.authUser(username, password)
    }
}