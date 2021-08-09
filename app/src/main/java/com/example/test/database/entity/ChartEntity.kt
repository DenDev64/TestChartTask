package com.example.test.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chart")
data class ChartEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val type: String,

    val symbol: String,
    val timestamps: List<Int>,
    val opens: List<Float>,
    val closures: List<Float>,
    val highs: List<Float>,
    val lows: List<Float>,
    val volumes:List<Int>

)
