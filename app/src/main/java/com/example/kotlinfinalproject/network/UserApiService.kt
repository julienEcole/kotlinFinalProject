package com.example.kotlinfinalproject.network

import FakeUserDto
import io.reactivex.rxjava3.core.Flowable
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
    ): Single<FakeUserDto>


    @GET("user")
    fun getAllUserData(
        @Query("id") id: Int,
        @Query("profilePicture") profilePicture: String,
        @Query("lastName") userLastName: String,
        @Query("name") userName: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("mail") userMail: String
    ): Flowable<FakeUserDto>
}