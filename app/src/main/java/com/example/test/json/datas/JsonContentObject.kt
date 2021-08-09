package com.example.test.json.datas

import com.google.gson.annotations.SerializedName

data class JsonContentObject(
    @SerializedName("quoteSymbols")
    val quoteSymbols: List<QuoteSymbolObject>
)