package com.example.kotlinfinalproject.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfinalproject.model.Recipe
import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.services.enums.Type
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject

class RecipeCardViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    private val disposeBag = CompositeDisposable()
    private val recipeCardsObserved: BehaviorSubject<List<RecipeCard>> = BehaviorSubject.createDefault(listOf())
    private val recipeCardDetailsObserved: BehaviorSubject<Recipe> = BehaviorSubject.create()
    val recipeCardsData: MutableLiveData<List<RecipeCard>> = MutableLiveData()
    val recipeDetailsData: MutableLiveData<Recipe> = MutableLiveData()
    lateinit var recipeId: String

    init {
        this.observeRandomRecipeCards()
        this.observeRecipeDetails()
    }
    fun getRandomRecipeCards(q: String="anything") {
        val random : Boolean = q == "anything"

        this.recipeRepository.getRandomRecipesAll(type=Type.PUBLIC, random=random, q=q).subscribe({ recipeCards ->
            this.recipeCardsObserved.onNext(recipeCards)
        }, { error ->
            Log.e("Error in function getFixedSizeOfRandomRecipeCards while fetching recipes data", error.message ?: "Default error message")
        }).addTo(disposeBag)
    }

    fun getRecipeDetails(id: String?) {
        this.recipeRepository.getOneRecipe(id=id ?: this.recipeId, type=Type.PUBLIC).subscribe({ recipe ->
            this.recipeCardDetailsObserved.onNext(recipe)
        }, { error ->
            Log.e("getRecipeDetails ErrMsg", error.message ?: "Default error message")
        }).addTo(disposeBag)
    }

    private fun observeRandomRecipeCards() {
        this.getRandomRecipeCards()
        this.recipeCardsObserved
            .observeOn(Schedulers.io())
            .subscribe { recipeCards ->
                this.recipeCardsData.postValue(recipeCards)
            }.addTo(disposeBag)
    }

    private fun observeRecipeDetails() {
        this.recipeCardDetailsObserved
            .observeOn(Schedulers.io())
            .subscribe{ recipe ->
                this.recipeDetailsData.postValue(recipe)
            }.addTo(disposeBag)
    }
}