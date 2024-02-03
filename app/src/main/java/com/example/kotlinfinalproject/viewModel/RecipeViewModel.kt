package com.example.kotlinfinalproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinfinalproject.model.Recipe

class RecipeViewModel : ViewModel(){
    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    init {
        // Initialisation des données (peut provenir d'un appel API, d'une base de données, etc.)
        val dummyRecipes = listOf<Recipe>()/*listOf(
            Recipe("Recipe 1", "https://example.com/recipe1.jpg"),
            Recipe("Recipe 2", "https://example.com/recipe2.jpg"),
            Recipe("Recipe 3", "https://example.com/recipe3.jpg") //TOSET
            // Ajoutez d'autres recettes au besoin
        )*/
        _recipes.value = dummyRecipes
    }
}