package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.user_model.UserData
import com.example.kotlinfinalproject.network.UserApiService
import io.reactivex.rxjava3.core.Flowable

class UsersRepository (private val userService: UserApiService){

    fun getRandomListOfUsers(size: Int): Flowable<List<UserData>> {
        return userService.getOneRandomUserData(
            "fr_FR",
            size,
            "uuid",
            "counter",
            "name",
            "lastName",
            "date",
            "text",
            "0606060606",
            "false"
        ).map {
            it.data
        }
    }

}