package com.example.test.di

import androidx.annotation.Keep
import androidx.room.Room
import com.example.test.database.ChartDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

@Keep
val dbModule = module {
    factory<ChartDataBase> {
        Room.databaseBuilder(androidContext(), ChartDataBase::class.java, "chart_Db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}