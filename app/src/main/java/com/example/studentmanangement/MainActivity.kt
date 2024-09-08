package com.example.studentmanangement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.studentmanangement.navigation.MyApp
import com.example.studentmanangement.reppositories.UserRepository
import com.example.studentmanangement.room.AppDatabase
import com.example.studentmanangement.ui.theme.StudentManangementTheme
import com.example.studentmanangement.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database = Room.databaseBuilder(this,AppDatabase::class.java,"db_user").build()
            val dao = database.userDao()
            val repo = UserRepository(database)
            val viewModel = UserViewModel(repo,dao)
            MyApp(vm = viewModel)
        }
    }
}