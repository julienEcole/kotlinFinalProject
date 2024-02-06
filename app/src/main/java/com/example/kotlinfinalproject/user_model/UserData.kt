package com.example.kotlinfinalproject.user_model



data class UserData(
    val id: String,
    val profilePicture: Int,
    val isPremium: Boolean,
    val lastName: String,
    val lastSeenDate: String,
    val name: String,
    val phoneNumber: String,
    val statusDescription: String,
)
