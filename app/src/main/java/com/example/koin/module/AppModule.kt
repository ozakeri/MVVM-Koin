package com.example.koin.module

import android.content.Context
import com.example.koin.BuildConfig
import com.example.koin.api.IHelper
import com.example.koin.api.IService
import com.example.koin.api.IServiceImpl
import com.example.koin.util.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


    val appModule = module {
        single { provideOkHttpClient() }
        single { provideApiService(get()) }
        single { provideNetworkHelper(get()) }
        single { provideRetrofit(get(),BuildConfig.BASE_URL) }

        single<IHelper> {
            return@single IServiceImpl(get())
        }
    }


    private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    private fun provideApiService(retrofit: Retrofit): IService =
        retrofit.create(IService::class.java)

    private fun provideNetworkHelper(context: Context) = NetworkHelper(context)
