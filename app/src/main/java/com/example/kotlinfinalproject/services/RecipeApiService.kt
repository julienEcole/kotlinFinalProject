package com.example.kotlinfinalproject.services

import com.example.kotlinfinalproject.model.RecipeCard
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface RecipeApiService {
    @GET("/")
    fun getRandomRecipes(@Query("type") type: String, @Query("random") random: Boolean): Call<List<RecipeCard>>;
}