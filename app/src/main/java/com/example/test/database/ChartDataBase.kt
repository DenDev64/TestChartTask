package com.example.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.test.database.converter.DbConverter
import com.example.test.database.dao.ChartDao
import com.example.test.database.entity.ChartEntity

@Database(entities = [ChartEntity::class], version = 1)
@TypeConverters(DbConverter::class)
abstract class ChartDataBase: RoomDatabase() {
    abstract fun getChartDao(): ChartDao

}