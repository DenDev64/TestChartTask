package com.example.test.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DbConverter {

    @TypeConverter
    fun timestampsToJson(timestamps: List<Int>): String {
        return Gson().toJson(timestamps)
    }

    @TypeConverter
    fun jsonToTimestamps(json: String): List<Int> {
        return Gson().fromJson(json, object : TypeToken<List<Int>>() {}.type)
    }

    @TypeConverter
    fun opensToJson(opens: List<Float>): String {
        return Gson().toJson(opens)
    }

    @TypeConverter
    fun jsonToOpens(json: String): List<Float> {
        return Gson().fromJson(json, object : TypeToken<List<Float>>() {}.type)
    }
}