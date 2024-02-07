package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class THUMBNAIL(
    val height: Int,
    val url: String,
    val width: Int
)