package com.example.kotlinfinalproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)  //define the entity used by DAO here
abstract class AppDatabase : RoomDatabase()   {
    abstract fun userDao() : UserDao    //add the other DAO in here

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                }
            }
            return instance!!
        }
    }
}