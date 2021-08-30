package com.example.koin.repos

import com.example.koin.api.IHelper

class MainRepository(private val iHelper: IHelper) {
    suspend fun getUsers() = iHelper.getUsers()
}