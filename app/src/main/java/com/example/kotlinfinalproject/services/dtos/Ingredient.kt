package com.example.kotlinfinalproject.services.dtos


import com.example.kotlinfinalproject.model.Ingredient

data class Ingredient(
    val food: String?,
    val foodCategory: String?,
    val foodId: String?,
    val image: String?,
    val measure: String?,
    val quantity: Double?,
    val text: String?,
    val weight: Double?,
) {
    fun toIngredient(): Ingredient {
        return Ingredient(
            this.text,
            this.quantity,
            this.measure,
        )
    }
}