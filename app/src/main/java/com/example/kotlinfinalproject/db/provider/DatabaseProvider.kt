package com.example.kotlinfinalproject.db.provider
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.kotlinfinalproject.db.AppDatabase

object DatabaseProvider {
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (instance == null) {
            synchronized(RoomDatabase::class) {
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