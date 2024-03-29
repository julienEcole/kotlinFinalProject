package com.example.kotlinfinalproject.view

import com.example.kotlinfinalproject.view.adapter.RecipeCardAdapter
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.di.injectDependencies
import com.example.kotlinfinalproject.view.adapter.OnRecipeClickedHandler
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class RecipesListingActivity : AppCompatActivity(), OnRecipeClickedHandler {

    private val recipeCardsViewModel: RecipeCardViewModel by viewModel()
    private lateinit var recipeCardsRv: RecyclerView
    private lateinit var searchBarEditText: EditText
    private lateinit var recipeCardAdapter: RecipeCardAdapter
    private lateinit var userProfileIv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.recipes_listing)

        injectDependencies(this@RecipesListingActivity)

        this.bindViews()
        this.setOnEditListener()
        this.setOnClickListener()
        this.observeRecipeCardsListing()
    }

    private fun bindViews() {
        this.recipeCardsRv = findViewById(R.id.recipe_cards_list)
        this.searchBarEditText = findViewById(R.id.search_bar_edit_text)
        this.userProfileIv = findViewById(R.id.recipes_listing_user_profile_iv)
    }

    private fun setOnClickListener() {
        this.userProfileIv.setOnClickListener {
            this.displayUserProfile()
        }
    }

    private fun setOnEditListener() {
        return this.searchBarEditText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH && v.text.isNotBlank()) {
                v.text?.let {
                    this.recipeCardsViewModel.getRandomRecipeCards(it.toString())
                }
            }

            true
        }
    }

    private fun observeRecipeCardsListing() {
        recipeCardsRv.layoutManager = LinearLayoutManager(this)
        this.recipeCardsViewModel.recipeCardsData.observe(this@RecipesListingActivity){ recipeCards ->
            this.recipeCardAdapter = RecipeCardAdapter(this.recipeCardsViewModel,this@RecipesListingActivity)
            recipeCardsRv.adapter = this.recipeCardAdapter
            this.recipeCardAdapter.fillRecipeCards(recipeCards)
        }
    }

    override fun displayRecipeDetails(id: String) {
        Intent(
            this,
            RecipeDetailActivity::class.java
        ).also {
            this.recipeCardsViewModel.recipeId = id
            this.recipeCardsViewModel.getRecipeDetails(id)
            startActivity(it)
        }
    }

    private fun displayUserProfile() {
        Intent(
            this,
            UserProfileActivity::class.java
        ).also {
            startActivity(it)
        }
    }
}