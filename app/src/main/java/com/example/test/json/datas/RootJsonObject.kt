package com.example.test.json.datas

import com.google.gson.annotations.SerializedName

data class RootJsonObject(
    @SerializedName("content")
    val content: JsonContentObject,
    @SerializedName("status")
    val status: String
)