package com.example.test.datasource.week

import com.example.test.json.datas.RootJsonObject
import io.reactivex.Single

interface WeekDataSource {
    fun getWeekData(): Single<RootJsonObject>
}