package com.example.kotlinfinalproject.user_model

data class FakeUserDto(
    val code: Int,
    val data: List<UserData>,
    val status: String,
    val total: Int
)
