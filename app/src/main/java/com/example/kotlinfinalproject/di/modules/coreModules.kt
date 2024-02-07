package com.example.kotlinfinalproject.di.modules

import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.services.RecipeApiService
import com.example.kotlinfinalproject.viewModel.RecipeCardViewModel
import org.koin.dsl.module


internal val coreModules = module {
    //region Api Services
    single { createApiService<RecipeApiService>(get()) }
    //endregion

    //region Respositories
    single { RecipeRepository(get()) }
    //endregion

    //region ViewModels
    single { RecipeCardViewModel(get()) }
    //endregion
}

