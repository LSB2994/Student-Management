package com.example.studentmanangement.states

import com.example.studentmanangement.models.User

data class UserState(
    var listUsers:List<User> = emptyList()
)
