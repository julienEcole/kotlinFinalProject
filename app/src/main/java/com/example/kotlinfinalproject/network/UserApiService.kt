package com.example.kotlinfinalproject.network

import com.example.kotlinfinalproject.user_model.FakeUserDto
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET("custom")
    fun getOneRandomUserData(
        @Query("_locale") randomDataLang: String,
        @Query("_quantity") responseLength: Int,
        @Query("id") id: String,
        @Query("profilePicture") profilePicture: String,
        @Query("name") userName: String,
        @Query("lastName") userLastName: String,
        @Query("lastSeenDate") userLastSeenDate: String,
        @Query("statusDescription") status: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("isPremium") isPremium: String
    ): Flowable<FakeUserDto>
}