package com.example.studentmanangement.views

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentmanangement.models.User
import com.example.studentmanangement.viewModel.UserViewModel

@Composable
fun RegisterScreen(vm:UserViewModel,navController: NavController) {
    var gmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Information", fontSize = 30.sp)
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Email")},
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = gmail,
            onValueChange = { gmail = it },
            label = { Text(text = "Email")},
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                if (validate(gmail,password)) {
                    val user = User(userName = name, gmail = gmail, password = password)
                    vm.insertUser(user)
                    navController.navigate("login")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }
    }
}