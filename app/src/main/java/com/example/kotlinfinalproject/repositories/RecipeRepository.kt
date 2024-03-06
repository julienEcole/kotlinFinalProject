package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.model.Recipe
import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.services.RecipeApiService
import com.example.kotlinfinalproject.services.enums.Type
import io.reactivex.rxjava3.core.Flowable

class RecipeRepository(private val apiService: RecipeApiService) {
    fun getRandomRecipesAll(type: Type, random: Boolean, q: String): Flowable<List<RecipeCard>> {
        return this.apiService.getRandomRecipes(type.value, random, q).map {
                it.hits.map { hit -> hit.recipe.toRecipeCard() }
            }
    }

    fun getOneRecipe(id: String, type: Type): Flowable<Recipe> {
        return this.apiService.getOneRecipe(id, type.value).map {
            it.recipe.toRecipe()
        }
    }
}