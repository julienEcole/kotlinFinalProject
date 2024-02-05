package com.example.kotlinfinalproject.user_model

class userDto (
    val infos: UserData,
) {
    fun getFormattedFullUserName(): String = this.infos.lastName + " " + this.infos.name
}
