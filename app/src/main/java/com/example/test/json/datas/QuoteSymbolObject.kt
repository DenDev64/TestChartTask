package com.example.test.json.datas

import com.google.gson.annotations.SerializedName

data class QuoteSymbolObject(
    @SerializedName("closures")
    val closures: List<Double>,
    @SerializedName("highs")
    val highs: List<Double>,
    @SerializedName("lows")
    val lows: List<Double>,
    @SerializedName("opens")
    val opens: List<Double>,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("timestamps")
    val timestamps: List<Int>,
    @SerializedName("volumes")
    val volumes: List<Int>
)