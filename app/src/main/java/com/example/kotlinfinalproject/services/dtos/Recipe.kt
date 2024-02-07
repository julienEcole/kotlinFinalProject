package com.example.kotlinfinalproject.services.dtos


import com.example.kotlinfinalproject.model.RecipeCard
import com.google.gson.annotations.SerializedName

data class Recipe(
    val calories: Double,
    val cautions: List<String>,
    val co2EmissionsClass: String,
    val cuisineType: List<String>,
    val dietLabels: List<String>,
    val digest: List<Digest>,
    val dishType: List<String>,
    val healthLabels: List<String>,
    val image: String,
    val images: Images,
    val ingredientLines: List<String>,
    val ingredients: List<Ingredient>,
    val label: String,
    val mealType: List<String>,
    val shareAs: String,
    val source: String,
    val tags: List<String>,
    val totalCO2Emissions: Double,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalTime: Double,
    val totalWeight: Double,
    val uri: String,
    val url: String,
    val yield: Double
) {
    fun toRecipeCard(): RecipeCard {
        return RecipeCard(label, this.images.tHUMBNAIL.url)
    }
}