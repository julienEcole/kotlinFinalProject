package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.db.entities.UserEntity
import com.example.kotlinfinalproject.user_model.UserData
import io.reactivex.rxjava3.core.Single

class UsersRepository (private val userDao: UserDao){

    val User = getRandomUser()  //bad practice to change after

    fun getRandomUser(): Single<UserData> {
        val userCollected: UserEntity? = userDao.getRandomUser()
        return if (userCollected is UserEntity) {
            Single.just(
                UserData(
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
                UserData(
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
