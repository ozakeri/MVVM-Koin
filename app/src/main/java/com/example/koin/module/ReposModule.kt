package com.example.koin.module

import com.example.koin.repos.MainRepository
import org.koin.dsl.module


    val repositoryModule = module {
            single {
                MainRepository(get())
            }
    }
