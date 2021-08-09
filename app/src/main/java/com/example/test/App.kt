package com.example.test

import android.app.Application
import com.example.test.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ChartApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() = startKoin {
        androidLogger(Level.NONE)
        androidContext(this@ChartApp)
        modules(appModule)
    }
}