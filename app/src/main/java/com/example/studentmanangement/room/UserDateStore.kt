package com.example.studentmanangement.room

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("current-user")
class UserDateStore {
    companion object{
        val GMAIL = stringPreferencesKey("gmail")
        val PASSWORD = stringPreferencesKey("password")
    }
    suspend fun saveUser(gmail:String, password:String,context: Context){
        context.dataStore.edit {
            it[GMAIL] = gmail
            it[PASSWORD] = password
        }
    }
}