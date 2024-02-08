package com.example.kotlinfinalproject.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinfinalproject.db.entities.UserEntity

@Dao
interface UserDao {

    //define other Query
    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user WHERE uid = :userUid")
    fun getOneUserById(userUid: Long) : UserEntity

    @Query("SELECT * FROM user ORDER BY RANDOM() LIMIT 1")
    fun getRandomUser(): UserEntity?

    @Insert
    fun insertNewUser(user: UserEntity)


    //fun updateUser(user: userEntity)

    @Delete
    fun deleteUser(user: UserEntity)
}