package com.example.kotlinfinalproject.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinfinalproject.R
import com.example.kotlinfinalproject.model.Recipe

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    private val imageViewRecipe: ImageView = itemView.findViewById(R.id.imageViewRecipe)
    private val textViewSource: TextView = itemView.findViewById(R.id.textViewSource)
    private val textViewLabels: TextView = itemView.findViewById(R.id.textViewLabels)

    fun bind(recipe: Recipe) {
        textViewName.text = recipe.label
        Glide.with(itemView.context)
            .load(recipe.url)
            .into(imageViewRecipe)
        textViewSource.text = recipe.source

        val labelsText = buildString {
            append("Diet Labels: ")
            append(recipe.dietLabels.joinToString(", "))
            append("\nHealth Labels: ")
            append(recipe.healthLabels.joinToString(", "))
            append("\nCautions: ")
            append(recipe.cautions.joinToString(", "))
        }
        textViewLabels.text = labelsText
    }
}