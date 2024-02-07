package com.example.kotlinfinalproject.services

import com.example.kotlinfinalproject.services.dtos.OneRecipeResponse
import com.example.kotlinfinalproject.services.dtos.RecipeCardsResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

public interface RecipeApiService {
    @GET("/api/recipes/v2")
    fun getRandomRecipes(@Query("type") type: String, @Query("random") random: Boolean, @Query("q") q: String): Flowable<RecipeCardsResponse>

    @GET("api/recipes/v2/{id}")
    fun getOneRecipe(
        @Path("id") id: String,
        @Query("type") type: String
    ): Flowable<OneRecipeResponse>
}