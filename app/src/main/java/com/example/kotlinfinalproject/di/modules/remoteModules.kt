package com.example.kotlinfinalproject.di.modules

import com.example.kotlinfinalproject.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal val remoteModules = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.RECIPE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        buildOkHttpClientWithDefaultQueryParams()
    }

}

private fun buildOkHttpClientWithDefaultQueryParams(): OkHttpClient {
    val defaultQueryParamsInterceptor = Interceptor { chain ->
        val originalRequest : Request = chain.request()
        val originalUrl = originalRequest.url

        val urlWithDefaults = originalUrl.newBuilder()
            .addQueryParameter("app_id", BuildConfig.RECIPE_API_APP_ID)
            .addQueryParameter("app_key", BuildConfig.RECIPE_API_APP_KEY)
            .build()

        val requestWithDefaults = originalRequest.newBuilder()
            .url(urlWithDefaults)
            .build()

        chain.proceed(requestWithDefaults)
    }

    return OkHttpClient.Builder()
        .addInterceptor(defaultQueryParamsInterceptor)
        .build()
}