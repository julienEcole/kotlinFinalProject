package com.example.kotlinfinalproject.services.dtos


import com.google.gson.annotations.SerializedName

data class Digest(
    val daily: Double,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: String,
    val sub: List<Sub>,
    val tag: String,
    val total: Double,
    val unit: String
)