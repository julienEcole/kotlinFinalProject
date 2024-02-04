package com.example.kotlinfinalproject

import RecipeAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfinalproject.di.injectDependencies
import com.example.kotlinfinalproject.viewModel.RecipeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesListingActivity : AppCompatActivity() {

    private val recipeCardsViewModel: RecipeViewModel by viewModel()
    private lateinit var recipeCardsRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipes_listing)

        injectDependencies(this@RecipesListingActivity)

        this.recipeCardsRv = findViewById(R.id.recipe_cards_list)

        observeRecipeCardsListing()
    }

    private fun observeRecipeCardsListing() {
        this.recipeCardsViewModel.recipeCardsData.observe(this@RecipesListingActivity){ recipeCards ->
            recipeCardsRv.adapter = RecipeAdapter(recipeCards = recipeCards)
            recipeCardsRv.layoutManager = LinearLayoutManager(this@RecipesListingActivity)
        }
    }

}