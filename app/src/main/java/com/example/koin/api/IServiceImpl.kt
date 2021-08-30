package com.example.koin.api

import com.example.koin.model.User
import retrofit2.Response

class IServiceImpl(val iService: IService) : IHelper {
    override suspend fun getUsers(): Response<List<User>> = iService.getUsers()
}