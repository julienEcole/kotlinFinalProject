package com.example.kotlinfinalproject.repositories

import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.db.entities.userEntity

class UsersRepository (private val userDao: UserDao){

    fun getRandomUser(): userEntity {
        return userDao.getRandomUser()
    }
}
