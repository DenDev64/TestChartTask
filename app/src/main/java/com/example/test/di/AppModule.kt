package com.example.test.di

import androidx.annotation.Keep
import com.example.test.di.viewModelModule

@Keep
val appModule = listOf(
    dbModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)