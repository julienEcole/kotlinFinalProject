package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class Hit(
    @SerializedName("_links")
    val links: Links,
    val recipe: Recipe
)