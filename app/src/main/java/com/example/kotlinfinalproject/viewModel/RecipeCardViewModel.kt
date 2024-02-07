package com.example.kotlinfinalproject.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.services.enums.Type
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class RecipeCardViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {

    private val disposeBag = CompositeDisposable();
    val recipeCardsData: MutableLiveData<List<RecipeCard>> = MutableLiveData()

    init {
        this.getRandomRecipeCards()
    }

    fun getRandomRecipeCards() {
        this.recipeRepository.getRandomRecipes(type=Type.PUBLIC, random=true).subscribe({ recipeCards ->
            this.recipeCardsData.postValue(recipeCards)
            Log.d("Recipe cards loaded", "Loaded recipe card in getFixedSizeOfRandomRecipeCards")
        }, { error ->
            Log.d("Error in fuction getFixedSizeOfRandomRecipeCards while fetching recipes data", error.message ?: "Default error message")
        }).addTo(disposeBag)
    }
}