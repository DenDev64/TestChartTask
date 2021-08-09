package com.example.test.di

import androidx.annotation.Keep
import com.example.test.database.LocalDataSource
import com.example.test.database.LocalDataSourceProvider
import com.example.test.datasource.month.MonthDataSource
import com.example.test.datasource.month.MonthDataSourceProvider
import com.example.test.datasource.week.WeekDataSource
import com.example.test.datasource.week.WeekDataSourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

@Keep
val dataSourceModule = module {
    factory<LocalDataSource> { LocalDataSourceProvider(get()) }
    factory<MonthDataSource> { MonthDataSourceProvider(androidContext()) }
    factory<WeekDataSource> { WeekDataSourceProvider(androidContext()) }
}