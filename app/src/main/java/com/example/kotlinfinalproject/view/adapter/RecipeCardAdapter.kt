package com.example.kotlinfinalproject.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.model.RecipeCard
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel

class RecipeCardAdapter(private val recipeCardViewModel: RecipeCardViewModel) : RecyclerView.Adapter<RecipeCardAdapter.RecipeViewHolder>() {

    private lateinit var recipeCards: MutableList<RecipeCard>

    init {
        this.fillRecipeCards()
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTv: TextView
        var thumbnailIv: ImageView
        init {
            this.nameTv = itemView.findViewById(R.id.recipe_card_title_tv)
            this.thumbnailIv = itemView.findViewById(R.id.recipe_card_thumbnail_iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val recipeCardsView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return RecipeViewHolder(recipeCardsView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeCards[position]
        holder.nameTv.text = recipe.label

        Glide.with(holder.itemView)
            .load(recipe.thumbnailUrl)
            .apply(RequestOptions().override(200, 200))
            .into(holder.thumbnailIv)
    }

    override fun getItemCount(): Int {
        return recipeCards.size
    }

    fun fillRecipeCards(newRecipeCards: List<RecipeCard> = listOf()) {
        if (newRecipeCards.isNotEmpty()) {
            this.recipeCards = newRecipeCards.toMutableList()
        } else {
            this.recipeCards = this.recipeCardViewModel
                .recipeCardsData.value
                ?.toMutableList()
                ?: mutableListOf()
        }
    }
}
