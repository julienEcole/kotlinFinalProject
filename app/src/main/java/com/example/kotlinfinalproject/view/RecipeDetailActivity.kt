package com.example.kotlinfinalproject.view

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.model.Recipe
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.ceil


class RecipeDetailActivity : AppCompatActivity() {
    private val recipeViewModel: RecipeCardViewModel by viewModel()
    private lateinit var recipe: Recipe
    private lateinit var photoIv: ImageView
    private lateinit var titleTv: TextView
    private lateinit var prepTimeTv: TextView
    private lateinit var numCaloriesTv: TextView
    private lateinit var numIngredientsTv: TextView
    private lateinit var instructionsLly: LinearLayout
    private lateinit var instructionsTitleTv: TextView
    private lateinit var totalNutrientsLly: LinearLayout
    private lateinit var totalNutrientsTitleTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_detail)

        this.bindViews()
        this.observeCardDetails()
    }

    private fun bindViews() {
        this.photoIv = findViewById(R.id.recipe_detail_photo_iv)
        this.titleTv = findViewById(R.id.recipe_detail_label_tv)
        this.prepTimeTv = findViewById(R.id.recipe_detail_timer_time_tv)
        this.numCaloriesTv = findViewById(R.id.recipe_detail_calories_count_tv)
        this.numIngredientsTv = findViewById(R.id.recipe_detail_ingredients_count_tv)
        this.instructionsLly = findViewById(R.id.recipe_detail_ingredients_list_lly)
        this.instructionsTitleTv = findViewById(R.id.recipe_detail_ingredients_list_title)
        this.totalNutrientsLly = findViewById(R.id.recipe_detail_total_nutrients_lly)
        this.totalNutrientsTitleTv = findViewById(R.id.recipe_detail_total_nutrients_title)
    }

    private fun observeCardDetails() {
        this.recipeViewModel.recipeDetailsData.observe(this@RecipeDetailActivity){ recipeDetail ->
            this.recipe = recipeDetail
            this.fillRecipeWithData()
        }
    }

    private fun fillRecipeWithData() {
        Glide.with(this@RecipeDetailActivity)
            .load(this.recipe.imageUrl)
            .placeholder(R.drawable.pot)
            .into(this@RecipeDetailActivity.photoIv)
        this.titleTv.text = this.recipe.label

        this.fillOverviewData()
        this.fillRecipeInstructions()
        this.fillTotalNutrients()
    }

    private fun fillOverviewData() {
        val prepTime = if (this.recipe.prepTime === null) "All the time you need!" else "${ceil(this.recipe.prepTime!!).toInt()} Minutes"
        this.prepTimeTv.text = prepTime

        val numIngredients = if (this.recipe.ingredients === null || this.recipe.ingredients!!.isEmpty()) {
            "None hehe"
        } else {
            "${this.recipe.ingredients!!.count()} Ingredients"
        }
        this.numIngredientsTv.text = numIngredients

        val numCalories = if (this.recipe.calories === null) "Who cares!" else "${ceil(this.recipe.calories!!).toInt()} KCal"
        this.numCaloriesTv.text = numCalories
    }

    private fun fillRecipeInstructions() {
        this.instructionsTitleTv.text = getString(R.string.recipe_detail_ingredients_list_title)
        this.instructionsTitleTv.setTextColor(Color.BLACK)
        var ingredientTextView: TextView

        this.recipe.ingredients?.forEach {
            ingredientTextView = TextView(this)
            ingredientTextView.text = getString(R.string.recipe_detail_ingredient_item_text, it.text)
            ingredientTextView.setTextColor(Color.BLACK)
            ingredientTextView.setPadding(4, 0, 0,0)
            this.instructionsLly.addView(ingredientTextView)
        }
    }

    private fun fillTotalNutrients() {
        this.totalNutrientsTitleTv.text = getString(R.string.recipe_detail_total_nutrients_title)
        this.totalNutrientsTitleTv.setTextColor(Color.BLACK)
        var healthLabelTextView: TextView

        this.recipe.totalNutrients?.forEach {
            healthLabelTextView = TextView(this)
            healthLabelTextView.text = getString(R.string.recipe_detail_total_nutrients_item_text, it.label, ceil(it.quantity).toInt(), it.unit)
            healthLabelTextView.setTextColor(Color.BLACK)
            this.totalNutrientsLly.addView(healthLabelTextView)
        }
    }
}
