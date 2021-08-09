package com.example.test.model

import androidx.room.ColumnInfo
import com.example.test.database.entity.ChartEntity

data class ContentModel(

    @ColumnInfo(name = "quoteSymbols")
    val quoteSymbols: ArrayList<ChartEntity>
)