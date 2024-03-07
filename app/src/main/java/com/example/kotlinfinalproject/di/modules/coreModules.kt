package com.example.kotlinfinalproject.di.modules

import android.content.Context
import com.example.kotlinfinalproject.db.AppDatabase
import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.repositories.UsersRepository
import com.example.kotlinfinalproject.services.RecipeApiService
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import com.example.kotlinfinalproject.viewModel.UserViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.module.Module
import org.koin.dsl.module
fun getCoreModules(context: Context): Module {
        return module {
                single<UserDao> { AppDatabase.getInstance(context).userDao() }
                //region Api Services
                single { createApiService<RecipeApiService>(get()) }
                //endregion

                //region Respositories
                single { RecipeRepository(get()) }
                single { UsersRepository(get()) }
                //endregion

                //region ViewModels
                single { RecipeCardViewModel(get()) }
                single { UserViewModel(get()) }
                //endregion
        }
}
