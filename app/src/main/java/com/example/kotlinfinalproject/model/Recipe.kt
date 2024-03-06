package com.example.kotlinfinalproject.model

import com.example.kotlinfinalproject.services.dtos.Nutrient

data class Recipe(
    val label: String?,
    val uri: String?,
    val imageUrl: String?,
    val ingredients: List<Ingredient>?,
    val source: String?,
    val dietLabels: List<String>?,
    val healthLabels: List<String>?,
    val cautions: List<String>?,
    val ingredientLines: List<String>?,
    val calories: Double?,
    val prepTime: Double?,
    val totalNutrients: List<Nutrient>?,
)
