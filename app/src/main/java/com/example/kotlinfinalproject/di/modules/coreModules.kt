package com.example.kotlinfinalproject.di.modules

import com.example.kotlinfinalproject.db.daos.UserDao
import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.repositories.UsersRepository
import com.example.kotlinfinalproject.services.RecipeApiService
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import com.example.kotlinfinalproject.viewModel.UserViewModel
import org.koin.dsl.module


internal val coreModules = module {

    //region Api Services
    single { createApiService<RecipeApiService>(get()) }
    single { createUserDao<UserDao>(get())}
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

