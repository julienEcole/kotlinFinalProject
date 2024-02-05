package com.example.kotlinfinalproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
class userEntity {
    @Entity(tableName = "user")
    data class ConversationEntity(
        @PrimaryKey(autoGenerate = true) val uid: Int,
        @ColumnInfo(name = "user_name") val userName: String,
        @ColumnInfo(name = "user_last_name") val userLastName: String,
    )
}