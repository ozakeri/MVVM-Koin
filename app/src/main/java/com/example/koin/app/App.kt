package com.example.koin.app

import android.app.Application
import com.example.koin.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}