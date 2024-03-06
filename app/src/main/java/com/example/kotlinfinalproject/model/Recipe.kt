package com.example.kotlinfinalproject.model

data class Recipe(
    val label: String?,
    val uri: String?,
    val imageUrl: String?,
    val ingredients: List<Ingredient>?,
    val source: String?,
    val dietLabels: List<String>?,
    val healthLabels: List<String>?,
    val cautions: List<String>?,
    val ingredientLines: List<String>?
)
