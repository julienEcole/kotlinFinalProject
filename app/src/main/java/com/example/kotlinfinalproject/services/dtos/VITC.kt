package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class VITC(
    val label: String,
    val quantity: Double,
    val unit: String
)