package com.example.kotlinfinalproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.db.entities.userEntity

@Database(
    entities = [userEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun UserDao(): UserDao

}