package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class CHOCDF(
    val label: String,
    val quantity: Double,
    val unit: String
)