package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.db.entities.UserEntity
import com.example.kotlinfinalproject.model.User
import io.reactivex.rxjava3.core.Single

class UsersRepository (private val userDao: UserDao){

    fun getRandomUser(): Single<User> {
        val userCollected: UserEntity? = userDao.getRandomUser()
        return if (userCollected is UserEntity) {
            Single.just(
                User(
                    userCollected.uid,
                    userCollected.profilePicture,
                    userCollected.userName,
                    userCollected.userLastName,
                    userCollected.phoneNumber,
                    userCollected.userMail
                )
            )
        } else {
            Single.just(
                User(
                    uid = 1,
                    profilePicture = "machin.png",
                    userName = "Doe",
                    userLastName = "John",
                    phoneNumber = "0606060606",
                    userMail = "fakeMail@notAMail.mock"
                )
            )
        }
    }
}
