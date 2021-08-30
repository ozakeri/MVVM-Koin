package com.example.koin.module

import com.example.koin.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val viewModelModule = module {
        viewModel{
            MainViewModel(get(), get())
        }
    }
