package com.example.koin.api

import com.example.koin.model.User
import retrofit2.Response
import retrofit2.http.GET

interface IService {

    @GET("users")
    suspend fun getUsers():Response<List<User>>
}