package com.example.test.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.test.database.entity.ChartEntity
import com.example.test.use_case.ChartUseCase
import com.example.test.database.dictionary.ChartType
import io.reactivex.rxkotlin.plusAssign

class SelectedChartViewModel(
    private val useCase: ChartUseCase
) : BaseViewModel() {

    val currentChart = MutableLiveData<ChartEntity>()

    fun showSelectedChart(symbol: String, type: ChartType) {
        compositeDisposable += useCase.showSelectedChart(symbol, type)
            .subscribe({ chartData ->
                Log.d("Selection", "$chartData")
                currentChart.value = chartData
            }, Throwable::printStackTrace)
    }
}