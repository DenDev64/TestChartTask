package com.example.test.utils.chartsStyle

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.example.test.R
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.data.CandleDataSet

class ChartForSelectedData(private  val context: Context) {

    fun styleCandleStickChart(candleStickChart: CandleStickChart) = candleStickChart.apply {

        xAxis.apply {
            isEnabled = true
            setDrawGridLines(false)
            granularity = 1f
            isGranularityEnabled = true
            setAvoidFirstLastClipping(true)
            textColor = ContextCompat.getColor(context, R.color.black)
            textSize = 1f
            yOffset = 5f
        }

        axisRight.apply {
            isEnabled = false
        }

        axisLeft.apply {

            candleStickChart.axisLeft
            candleStickChart.axisRight
            setDrawGridLines(false)
        }

        setBorderColor(resources.getColor(R.color.backGraph))
        legend.isEnabled = false
        requestDisallowInterceptTouchEvent(true)
        setNoDataText("Not Chosen Chart")
    }

    fun styleDataLines(candleDataSet: CandleDataSet) = candleDataSet.apply {
        color = ContextCompat.getColor(context, R.color.colorPrimary)
        shadowColor = ContextCompat.getColor(context, R.color.backGraph)
        shadowWidth = 0.8f
        decreasingColor = ContextCompat.getColor(context, R.color.gold)
        decreasingPaintStyle = Paint.Style.FILL
        increasingColor = ContextCompat.getColor(context, R.color.purple)
        increasingPaintStyle = Paint.Style.FILL
        neutralColor = Color.LTGRAY
        setDrawValues(false)
    }
}