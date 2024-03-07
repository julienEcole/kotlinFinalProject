package com.example.kotlinfinalproject.di

import android.content.Context
import com.example.kotlinfinalproject.di.modules.remoteModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.error.ApplicationAlreadyStartedException
import com.example.kotlinfinalproject.di.modules.getCoreModules

private val modules = mutableListOf(remoteModules)

fun injectDependencies(context: Context) {
    modules.add(getCoreModules(context))

    try {
        startKoin {
            androidContext(context)
            modules(modules)
        }
    } catch (alreadyStart: ApplicationAlreadyStartedException) {
        loadKoinModules(modules)
    }
}
