package com.example.test.di

import androidx.annotation.Keep
import com.example.test.use_case.ChartUseCase
import com.example.test.use_case.ChartUseCaseProvider
import org.koin.dsl.module

@Keep
val useCaseModule = module {
    single<ChartUseCase> { ChartUseCaseProvider(get()) }
}