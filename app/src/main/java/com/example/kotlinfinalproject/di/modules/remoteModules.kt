package com.example.kotlinfinalproject.di.modules

import com.example.kotlinfinalproject.BuildConfig
import com.example.kotlinfinalproject.db.daos.UserDao
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal val remoteModules = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.RECIPE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(get())
            .build()
    }

    single {
        buildOkHttpClientWithDefaultQueryParams()
    }

}

inline fun <reified ApiService> createApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

inline fun <reified UserDao> createUserDao(retrofit: Retrofit): UserDao {
    return retrofit.create(UserDao::class.java)
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
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()
}