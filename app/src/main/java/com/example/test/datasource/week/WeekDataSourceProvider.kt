package com.example.test.datasource.week

import android.content.Context
import com.example.test.R
import com.example.test.json.mapper.mapJsonFromInputStream
import com.example.test.utils.extensions.asSingle

class WeekDataSourceProvider(
    private val context: Context
): WeekDataSource {

    override fun getWeekData() = mapJsonFromInputStream(
        context.resources.openRawResource(R.raw.response_quotes_week)
    ).asSingle()
}