package com.example.kotlinfinalproject.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinfinalproject.db.entities.userEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<userEntity>

    @Insert
    fun insertNewUser(user: userEntity)

    @Delete
    fun deleteUser(user: userEntity)
}