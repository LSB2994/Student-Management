package com.example.studentmanangement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentmanangement.viewModel.UserViewModel
import com.example.studentmanangement.views.HomeScreen
import com.example.studentmanangement.views.LoginScreen
import com.example.studentmanangement.views.RegisterScreen

@Composable
fun MyApp(vm: UserViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login") {

        composable("login"){
            LoginScreen(vm, navController)
        }
        composable("register"){
            RegisterScreen(vm, navController)
        }
        composable("home"){
            HomeScreen(vm, navController)
        }
    }
}
