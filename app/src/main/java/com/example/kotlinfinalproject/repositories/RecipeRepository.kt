package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.services.RecipeLocalService
import com.example.kotlinfinalproject.services.enums.Type
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class RecipeRepository: KoinComponent {
    private val recipeService: RecipeLocalService = get()

    fun getRandomRecipes(type: Type, random: Boolean): Flowable<List<RecipeCard>> {
        return Flowable.fromArray(recipeService.getRandomRecipes())
            .subscribeOn(Schedulers.io())
    }
}