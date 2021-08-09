package com.example.test.repository

import com.example.test.database.LocalDataSource
import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity
import com.example.test.database.mapper.mapToLocal
import com.example.test.datasource.month.MonthDataSource
import com.example.test.datasource.week.WeekDataSource
import io.reactivex.Completable
import io.reactivex.Single

interface ChartRepository {

    fun fetchData(): Completable

    fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity>
    fun showAllChart(type: ChartType): Single<List<ChartEntity>>
    fun insertCharts(charts: List<ChartEntity>): Completable
    fun deleteCharts(): Completable

}

class ChartRepositoryProvider(
    private val localDataSource: LocalDataSource,
    private val monthDataSource: MonthDataSource,
    private val weekDataSource: WeekDataSource
): ChartRepository {

    override fun fetchData() = localDataSource
        .deleteCharts()
        .andThen(saveWeekData())
        .andThen(saveMonthData())

    override fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity> {
        return localDataSource.showSelectedChart(symbol, type)
    }

    override fun showAllChart(type: ChartType): Single<List<ChartEntity>> {
        return localDataSource.showAllChart(type)
    }

    override fun insertCharts(charts: List<ChartEntity>): Completable {
        return localDataSource.insertCharts(charts)
    }

    override fun deleteCharts(): Completable = localDataSource.deleteCharts()

    private fun saveMonthData(): Completable = monthDataSource.getMonthData()
        .map { it.mapToLocal(ChartType.MONTH) }
        .flatMapCompletable(::insertCharts)

    private fun saveWeekData(): Completable = weekDataSource.getWeekData()
        .map { it.mapToLocal(ChartType.WEEK) }
        .flatMapCompletable(::insertCharts)
}