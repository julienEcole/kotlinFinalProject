package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class Nutrient(
    val label: String,
    val quantity: Double,
    val unit: String
)