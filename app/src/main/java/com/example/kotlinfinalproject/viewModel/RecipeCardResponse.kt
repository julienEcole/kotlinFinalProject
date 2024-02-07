package com.example.kotlinfinalproject.viewModel

import org.json.JSONObject
import com.example.kotlinfinalproject.model.RecipeCard

data class RecipeCardResponse(
    val label: String,
    val url: String,
)
{
    fun createRecipeCard(data: JSONObject): RecipeCard {
        return RecipeCard(data.get("label") as String, data.get("images") as String);
    }


}
