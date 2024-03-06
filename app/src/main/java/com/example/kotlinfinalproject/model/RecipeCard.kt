package com.example.kotlinfinalproject.model

data class RecipeCard (
    val label: String,
    val uri: String,
    val thumbnailUrl: String,
) {
    fun getId() : String {
        return this.uri.substringAfter("#")
    }
}