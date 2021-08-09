package com.example.test.utils

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.github.mikephil.charting.formatter.ValueFormatter
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class AxisFormatter(
    private val timestamps: List<Int>
) : ValueFormatter() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getFormattedValue(value: Float): String = dateConvertor(timestamps[value.toInt()])

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateConvertor(time : Int): String {
        val dateTime = LocalDateTime.ofEpochSecond(time.toLong(), 0, ZoneOffset.UTC)
        val formatter = DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH)
        return dateTime.format(formatter)
    }
}