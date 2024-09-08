package com.example.studentmanangement.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.studentmanangement.viewModel.UserViewModel

@Composable
fun LoginScreen(vm:UserViewModel,navController: NavController){
    var gmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
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
                    vm.auth(gmail,password,context)
                    navController.navigate("home")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
           Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate("register") }) {
            Text(text = "No account? Register here")
        }
    }
}
fun validate(email:String,password:String):Boolean{
    return email.isNotEmpty() && password.isNotEmpty()
}