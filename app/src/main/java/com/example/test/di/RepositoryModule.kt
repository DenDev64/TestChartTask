package com.example.test.di

import androidx.annotation.Keep
import com.example.test.repository.ChartRepository
import com.example.test.repository.ChartRepositoryProvider
import org.koin.dsl.module

@Keep
val repositoryModule = module {
    single<ChartRepository> { ChartRepositoryProvider(get(), get(), get()) }
}