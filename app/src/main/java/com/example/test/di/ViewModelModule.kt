package com.example.test.di

import androidx.annotation.Keep
import com.example.test.view_model.MainChartViewModel
import com.example.test.view_model.SelectedChartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Keep
val viewModelModule = module(override = true) {
    viewModel { MainChartViewModel(get()) }
    viewModel { SelectedChartViewModel(get()) }
}