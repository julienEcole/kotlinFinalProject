package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class RecipeCardsResponse(
    val count: Int,
    val from: Int,
    val hits: List<Hit>,
    @SerializedName("_links")
    val links: Links,
    val to: Int
)