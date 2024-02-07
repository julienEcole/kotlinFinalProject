package com.example.kotlinfinalproject.services.dtos


import com.example.kotlinfinalproject.model.RecipeCard
import com.google.gson.annotations.SerializedName

data class OneRecipeResponse(
    @SerializedName("_links")
    val links: Links,
    val recipe: Recipe
) {
    fun toRecipeCard(): RecipeCard {
        return RecipeCard(recipe.label, recipe.images.tHUMBNAIL.url)
    }
}