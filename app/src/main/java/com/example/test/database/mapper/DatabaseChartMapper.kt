package com.example.test.database.mapper

import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity
import com.example.test.json.datas.QuoteSymbolObject
import com.example.test.json.datas.RootJsonObject

fun RootJsonObject.mapToLocal(type: ChartType): List<ChartEntity> =
    content.quoteSymbols.map { it.mapToChartEntity(type) }

fun QuoteSymbolObject.mapToChartEntity(type: ChartType): ChartEntity = ChartEntity(
    symbol = this.symbol,
    timestamps = this.timestamps,
    opens = this.opens.map { it.toFloat() },
    closures = this.closures.map { it.toFloat() },
    highs = this.highs.map { it.toFloat() },
    lows = this.lows.map { it.toFloat() },
    volumes = this.volumes,
    type = type.key
)