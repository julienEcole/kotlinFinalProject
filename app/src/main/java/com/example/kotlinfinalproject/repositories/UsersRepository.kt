package com.example.kotlinfinalproject.repositories

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
        ).map {
            it.data
        }
    }

}