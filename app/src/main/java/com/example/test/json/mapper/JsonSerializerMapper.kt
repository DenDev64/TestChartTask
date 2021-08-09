package com.example.test.json.mapper

import com.example.test.json.datas.RootJsonObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader

fun mapJsonFromInputStream(input: InputStream): RootJsonObject {
    val reader = InputStreamReader(input)
    return Gson().fromJson(reader, object : TypeToken<RootJsonObject>() {}.type)
}