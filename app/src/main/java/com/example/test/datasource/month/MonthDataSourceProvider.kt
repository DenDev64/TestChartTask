package com.example.test.datasource.month

import android.content.Context
import com.example.test.R
import com.example.test.json.mapper.mapJsonFromInputStream
import com.example.test.utils.extensions.asSingle

class MonthDataSourceProvider(
    private val context: Context
) : MonthDataSource {

    override fun getMonthData() = mapJsonFromInputStream(
        context.resources.openRawResource(R.raw.response_quotes_month)
    ).asSingle()
}