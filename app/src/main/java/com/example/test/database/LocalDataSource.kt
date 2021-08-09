package com.example.test.database

import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface LocalDataSource {
    fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity>
    fun showAllChart(type: ChartType): Single<List<ChartEntity>>
    fun insertCharts(charts: List<ChartEntity>): Completable
    fun deleteCharts(): Completable

}

class LocalDataSourceProvider(
    private val database: ChartDataBase
): LocalDataSource {

    override fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity> {
        return Single.just(database.getChartDao().showSelectedChart(symbol, type.key))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun showAllChart(type: ChartType): Single<List<ChartEntity>> {
        return Single.just(database.getChartDao().showAllChart(type.key))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun insertCharts(charts: List<ChartEntity>): Completable {
        return Completable.fromAction { database.getChartDao().insertCharts(charts) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun deleteCharts(): Completable {
        return Completable.fromAction { database.getChartDao().deleteCharts() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}