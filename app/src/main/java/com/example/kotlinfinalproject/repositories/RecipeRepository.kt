package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.services.RecipeApiService
import com.example.kotlinfinalproject.services.RecipeLocalService
import com.example.kotlinfinalproject.services.enums.Type
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecipeRepository(private val apiService: RecipeApiService) {
    fun getRandomRecipesAll(type: Type, random: Boolean, q: String): Flowable<List<RecipeCard>> {
        return this.apiService.getRandomRecipes(type.value, random, q).map {
                it.hits.map { hit -> hit.recipe.toRecipeCard() }
            }
    }

    fun getOneRecipe(id: String, type: Type): Flowable<RecipeCard> {
        return this.apiService.getOneRecipe(id, type.value).map {
            it.toRecipeCard()
        }
    }
}