package com.example.koin.api

import com.example.koin.model.User
import retrofit2.Response

interface IHelper {

    suspend fun getUsers(): Response<List<User>>
}