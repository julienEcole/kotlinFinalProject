package com.example.kotlinfinalproject.di

import android.content.Context
import com.example.kotlinfinalproject.di.modules.coreModules
import com.example.kotlinfinalproject.di.modules.remoteModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.error.ApplicationAlreadyStartedException
import com.example.kotlinfinalproject.BuildConfig
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.dsl.module

private val modules = mutableListOf(coreModules, remoteModules)

fun injectDependencies(context: Context) {
    try {
        startKoin {
            androidContext(context)
            modules(modules)
        }
    } catch (alreadyStart: ApplicationAlreadyStartedException) {
        loadKoinModules(modules)
    }
}

fun injectionModuleDependencies(context: Context) {
    try {
        startKoin {
            androidContext(context)
            modules(modules)
        }
    } catch (alreadyStart: KoinAppAlreadyStartedException) {
        loadKoinModules(modules)

    }
}

fun parseAndInjectionConfiguration() {
    val apiConf = FakeJsonConf(baseUrl = BuildConfig.USER_FAKER_API)

    modules.add(
        module {
            single { apiConf }
        }
    )
}

data class FakeJsonConf(val baseUrl: String)
