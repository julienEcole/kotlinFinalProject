package com.example.kotlinfinalproject.di.modules

import com.example.kotlinfinalproject.repositories.RecipeRepository
import com.example.kotlinfinalproject.services.RecipeLocalService
import org.koin.dsl.module


internal val coreModules = module {
    single { RecipeLocalService() }
    single { RecipeRepository() }
}

