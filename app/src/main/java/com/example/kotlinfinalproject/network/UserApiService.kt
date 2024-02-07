package com.example.kotlinfinalproject.network

import com.example.kotlinfinalproject.user_model.UserData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET("user")
    fun getOneRandomUserData(
        @Query("id") id: Int,
        @Query("profilePicture") profilePicture: String,
        @Query("lastName") userLastName: String,
        @Query("name") userName: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("mail") userMail: String
    ): Single<UserData>
}