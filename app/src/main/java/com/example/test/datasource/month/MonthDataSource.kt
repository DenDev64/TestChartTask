package com.example.test.datasource.month

import com.example.test.json.datas.RootJsonObject
import io.reactivex.Single

interface MonthDataSource {
    fun getMonthData(): Single<RootJsonObject>
}