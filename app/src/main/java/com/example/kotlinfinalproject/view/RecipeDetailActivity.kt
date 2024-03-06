package com.example.kotlinfinalproject.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.model.Recipe
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecipeDetailActivity : AppCompatActivity() {
    private val recipeViewModel: RecipeCardViewModel by viewModel()
    private lateinit var recipeDetail: Recipe
    private lateinit var photoIv: ImageView
    private lateinit var titleTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_detail)

        this.photoIv = findViewById(R.id.recipe_detail_photo_iv)
        this.titleTv = findViewById(R.id.recipe_detail_label_tv)

        this.observeCardDetails()
    }

    private fun observeCardDetails() {
        this.recipeViewModel.recipeDetailsData.observe(this@RecipeDetailActivity){ recipeDetail ->
            this.recipeDetail = recipeDetail
            this.fillRecipeWithDetails(recipeDetail)
        }
    }

    private fun fillRecipeWithDetails(recipe: Recipe) {
        this.titleTv.text = recipe.label
        Glide.with(this@RecipeDetailActivity)
            .load(recipe.imageUrl)
            .placeholder(R.drawable.recipe_photo)
            .into(this@RecipeDetailActivity.photoIv)
    }
}
