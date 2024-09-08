package com.example.studentmanangement.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentmanangement.models.User
import com.example.studentmanangement.reppositories.UserRepository
import com.example.studentmanangement.room.UserDao
import com.example.studentmanangement.states.UserState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository,
    val userDao: UserDao
):ViewModel() {
    var dataUser by mutableStateOf(UserState())
        private set

    init {
        viewModelScope.launch {
            userDao.getAllUser().collectLatest {
                dataUser = dataUser.copy(
                    listUsers = it
                )
            }
        }
    }
    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }
    fun deleteUser(user: User) = viewModelScope.launch {
        repository.deleteUser(user)
    }
    fun updateUser(user: User) = viewModelScope.launch {
        repository.updateUser(user)

    }
    fun getUserById(id:Int) = viewModelScope.launch {
        repository.getUserById(id)
    }
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("current-user")
    val GMAIL = stringPreferencesKey("gmail")
    val PASSWORD = stringPreferencesKey("password")
    fun auth(gmail:String,password:String,context: Context) = viewModelScope.launch {
        context.dataStore.edit {
            it[GMAIL] = gmail
            it[PASSWORD] = password
        }
        repository.auth(gmail, password)
    }
}
