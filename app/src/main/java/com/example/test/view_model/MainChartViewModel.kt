package com.example.test.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.test.database.entity.ChartEntity
import com.example.test.use_case.ChartUseCase
import com.example.test.database.dictionary.ChartType
import io.reactivex.rxkotlin.plusAssign

class MainChartViewModel(
    private val chartUseCase: ChartUseCase
): BaseViewModel() {

    val chartsToShow = MutableLiveData<List<ChartEntity>>()

    fun showCharts(type: ChartType) {
        fetchData {
            compositeDisposable += chartUseCase.showAllChart(type)
                .subscribe({ chartsData ->
                    chartsToShow.value = chartsData
                    Log.d("Chart", "$chartsData")
                }, Throwable::printStackTrace)
        }
    }

    private fun fetchData(onDone: () -> Unit) {
        compositeDisposable += chartUseCase
            .fetchData()
            .subscribe({
                onDone()
            }, Throwable::printStackTrace)
    }

}