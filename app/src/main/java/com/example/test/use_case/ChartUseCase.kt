package com.example.test.use_case

import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity
import com.example.test.repository.ChartRepository
import io.reactivex.Completable
import io.reactivex.Single

interface ChartUseCase {
    fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity>
    fun showAllChart(type: ChartType): Single<List<ChartEntity>>
    fun fetchData(): Completable

}

class ChartUseCaseProvider(
    private val repository: ChartRepository
): ChartUseCase {
    override fun showSelectedChart(symbol: String, type: ChartType): Single<ChartEntity> {
        return repository.showSelectedChart(symbol, type)
    }

    override fun showAllChart(type: ChartType): Single<List<ChartEntity>> {
        return repository.showAllChart(type)
    }

    override fun fetchData(): Completable {
        return repository.fetchData()
    }

}