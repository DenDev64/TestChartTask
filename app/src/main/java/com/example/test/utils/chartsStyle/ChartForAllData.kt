package com.example.test.utils.chartsStyle

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.test.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineDataSet

class ChartForAllData(private  val context: Context) {

    fun styleChart(lineChart: LineChart) = lineChart.apply {

        axisRight.apply{
            isEnabled = false
        }

        axisLeft.apply {
            isEnabled = true
            setDrawGridLines(true)
            gridColor = ContextCompat.getColor(context, R.color.whiteGraph)
            axisLineColor = ContextCompat.getColor(context, R.color.backGraph)
            textColor = ContextCompat.getColor(context, R.color.black)
            textSize = 1f
            xOffset = 16f
        }

        xAxis.apply {
            isEnabled = true
            isGranularityEnabled = true
            setDrawGridLines(false)
            setDrawAxisLine(false)
            position = XAxis.XAxisPosition.BOTTOM
            textColor = ContextCompat.getColor(context, R.color.black)
            textSize = 1f
            yOffset = 5f
        }


        setNoDataText("No data")
        setTouchEnabled(true)
        isDragEnabled = true
//        setScaleEnabled(false)
//        setPinchZoom(false)
        description = null
        legend.isEnabled = false
    }

    fun styleLineDataSet1(lineDataSet: LineDataSet) = lineDataSet.apply {
        color = ContextCompat.getColor(context, R.color.purple)
        valueTextColor = ContextCompat.getColor(context, R.color.black)
        valueTextSize = 12f
        setDrawValues(true)
        lineWidth = 2f
        isHighlightEnabled = true
        setDrawHighlightIndicators(false)
        circleRadius = 6f
        circleHoleRadius = 5f
        this.setCircleColor(ContextCompat.getColor(context, R.color.white))
        circleHoleColor = ContextCompat.getColor(context, R.color.purple)
        mode = LineDataSet.Mode.CUBIC_BEZIER

        setDrawFilled(true)
    }

    fun styleLineDataSet2(lineDataSet: LineDataSet) = lineDataSet.apply {
        color = ContextCompat.getColor(context, R.color.gold)
        valueTextColor = ContextCompat.getColor(context, R.color.black)
        valueTextSize = 12f
        setDrawValues(true)
        lineWidth = 2f
        isHighlightEnabled = true
        setDrawHighlightIndicators(false)
        circleRadius = 6f
        circleHoleRadius = 5f
        this.setCircleColor(ContextCompat.getColor(context, R.color.white))
        circleHoleColor = ContextCompat.getColor(context, R.color.gold)
        mode = LineDataSet.Mode.CUBIC_BEZIER

        setDrawFilled(true)
    }

    fun styleLineDataSet3(lineDataSet: LineDataSet) = lineDataSet.apply {
        color = ContextCompat.getColor(context, R.color.red)
        valueTextColor = ContextCompat.getColor(context, R.color.black)
        valueTextSize = 12f
        setDrawValues(true)
        lineWidth = 2f
        isHighlightEnabled = true
        setDrawHighlightIndicators(false)
        circleRadius = 6f
        circleHoleRadius = 5f
        this.setCircleColor(ContextCompat.getColor(context, R.color.white))
        circleHoleColor = ContextCompat.getColor(context, R.color.red)
        mode = LineDataSet.Mode.CUBIC_BEZIER

        setDrawFilled(true)
    }
}