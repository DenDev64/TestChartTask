package com.example.test.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.test.database.dictionary.ChartType
import com.example.test.database.entity.ChartEntity
import com.example.test.databinding.MainChartBinding
import com.example.test.utils.AxisFormatter
import com.example.test.utils.chartsStyle.ChartForAllData
import com.example.test.utils.chartsStyle.ChartForSelectedData
import com.example.test.view_model.MainChartViewModel
import com.example.test.view_model.SelectedChartViewModel
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import org.koin.android.ext.android.inject

class MainChartActivity : AppCompatActivity() {

    private lateinit var binding: MainChartBinding

    var typeKey = ChartType.WEEK
    var currentChart = ""

    val mainChartViewModel by inject<MainChartViewModel>()
    val selectedChartViewModel by inject<SelectedChartViewModel>()

    lateinit var styleChart: ChartForAllData
    lateinit var styleCandleChart: ChartForSelectedData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.hide()

        mainChartViewModel.showCharts(typeKey)
        observeMainCharts()
        observerSelectedChart()
        buttonClicker()
    }

    private fun buttonClicker() {

        binding.buttonAAPL.setOnClickListener {
            currentChart = "AAPL"
            selectedChartViewModel.showSelectedChart(currentChart, typeKey)
        }

        binding.buttonMSFT.setOnClickListener {
            currentChart = "MSFT"
            selectedChartViewModel.showSelectedChart(currentChart, typeKey)
        }

        binding.buttonSPY.setOnClickListener {
            currentChart = "SPY"
            selectedChartViewModel.showSelectedChart(currentChart, typeKey)
        }

        binding.buttonMonth.setOnClickListener {
            mainChartViewModel.showCharts(ChartType.MONTH)
        }

        binding.buttonWeek.setOnClickListener {
            mainChartViewModel.showCharts(ChartType.WEEK)
        }

    }

    fun observeMainCharts() {
        mainChartViewModel.chartsToShow.observe(this, Observer<List<ChartEntity>> { chartListData ->
            val firstChart = chartListData[0]
            val secondChart = chartListData[1]
            val thirdChart = chartListData[2]

            val time = firstChart.timestamps

            styleChart = ChartForAllData(this)

            val points1 = mutableListOf<Entry>()
            val points2 = mutableListOf<Entry>()
            val points3 = mutableListOf<Entry>()

            for (i in firstChart.volumes.indices) {
                points1.add(
                    Entry(i.toFloat(), firstChart.volumes[i].toFloat()))
            }

            for (i in secondChart.volumes.indices) {
                points2.add(
                    Entry(
                        i.toFloat(), secondChart.volumes[i].toFloat()))
            }

            for (i in thirdChart.volumes.indices) {
                points3.add(
                    Entry(i.toFloat(), thirdChart.volumes[i].toFloat())
                )
            }

            val set1 = LineDataSet(points1, firstChart.symbol)
            styleChart.styleLineDataSet1(set1)
            val set2 = LineDataSet(points2, firstChart.symbol)
            styleChart.styleLineDataSet2(set2)
            val set3 = LineDataSet(points3, firstChart.symbol)
            styleChart.styleLineDataSet3(set3)

            val dataSets = mutableListOf<ILineDataSet>()
            dataSets.add(set1)
            dataSets.add(set2)
            dataSets.add(set3)

            val data = LineData(dataSets)

            styleChart.styleChart(binding.lineChartForAll)
            binding.lineChartForAll.xAxis.valueFormatter = AxisFormatter(time)
            binding.lineChartForAll.data = data
            binding.lineChartForAll.invalidate()
            binding.lineChartForAll.requestLayout()

        })
    }

    fun observerSelectedChart() {
        selectedChartViewModel.currentChart.observe(this, Observer<ChartEntity> { chartData ->

            val time = chartData.timestamps

            val highs = chartData.highs
            val lows = chartData.lows
            val open = chartData.opens
            val close = chartData.closures

            styleCandleChart = ChartForSelectedData(this)

            val points = arrayListOf<CandleEntry>()

            for (i in highs.indices) {
                points.add(CandleEntry(i.toFloat(), highs[i], lows[i], open[i], close[i]))
            }

            val datas = CandleDataSet(points, currentChart)
            styleCandleChart.styleDataLines(datas)

            val dataSet = mutableListOf<ICandleDataSet>()
            dataSet.add(datas)

            val data = CandleData(dataSet)

            styleCandleChart.styleCandleStickChart(binding.candleStickChartForSelected)
            binding.candleStickChartForSelected.xAxis.valueFormatter = AxisFormatter(time)
            binding.candleStickChartForSelected.setNoDataText("Not Chosen Chart")
            binding.candleStickChartForSelected.data = data
            binding.candleStickChartForSelected.invalidate()
            binding.candleStickChartForSelected.requestLayout()

        })
    }
}