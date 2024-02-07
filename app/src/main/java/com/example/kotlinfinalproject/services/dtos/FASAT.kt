package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class FASAT(
    val label: String,
    val quantity: Double,
    val unit: String
)