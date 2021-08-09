package com.example.test.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity

@Dao
interface ChartDao {

    @Query("SELECT * FROM chart WHERE symbol=:symbol AND type=:type")
    fun showSelectedChart(symbol: String, type: String): ChartEntity

    @Query("SELECT * FROM chart WHERE type=:type")
    fun showAllChart(type: String): List<ChartEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharts(charts: List<ChartEntity>)

    @Query("DELETE FROM chart")
    fun deleteCharts()
}