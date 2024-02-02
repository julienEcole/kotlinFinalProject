package com.example.kotlinfinalproject.model

data class Recipe(
    val label: String,
    val url: String,    // lien de l'image représenté par la recette
    val ingredients: List<Ingredient>,
    val source: String,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val cautions: List<String>,
    val ingredientLines: List<String>
)
