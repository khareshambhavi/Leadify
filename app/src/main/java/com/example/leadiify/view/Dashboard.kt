package com.example.leadiify.view


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.example.leadiify.R
import com.example.leadiify.adapter.HomeStatsAdapter
import com.example.leadiify.databinding.FragmentDashboardBinding
import com.example.leadiify.model.home_stats_model
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class Dashboard : Fragment() {
    var barChart: BarChart? = null

    // variable for our bar data set.
    var barDataSet1: BarDataSet? = null
    var barDataSet2: BarDataSet? = null

    // array list for storing entries.
    var barEntries: ArrayList<BarEntry>? = null

    // creating a string array for displaying days.
    var days = arrayOf("Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentDashboardBinding.inflate(inflater, container, false)
        var statsData=ArrayList<home_stats_model>()
        extracted(statsData)
        var adapter=HomeStatsAdapter(statsData)
        var layoutManager= StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=layoutManager
         barChart = binding.groupedBarChart

        barCharts()
        val anyChartView=binding.funnelChart
        funnelChart(anyChartView)
        return binding.root
    }

    private fun barCharts() {
        // creating a new bar data set.

        // creating a new bar data set.
        barDataSet1 = BarDataSet(getBarEntriesOne(), "First Set")
        barDataSet1!!.setColor(Color.parseColor("#0095FF"))
        barDataSet2 = BarDataSet(getBarEntriesTwo(), "Second Set")
        barDataSet2!!.setColor(
            Color.parseColor(
                "#00E096"
            )
        )

        // below line is to add bar data set to our bar data.

        // below line is to add bar data set to our bar data.
        val data = BarData(barDataSet1, barDataSet2)

        // after adding data to our bar data we
        // are setting that data to our bar chart.

        // after adding data to our bar data we
        // are setting that data to our bar chart.
        barChart!!.setData(data)

        // below line is to remove description
        // label of our bar chart.

        // below line is to remove description
        // label of our bar chart.
        barChart!!.getDescription().setEnabled(false)

        // below line is to get x axis
        // of our bar chart.

        // below line is to get x axis
        // of our bar chart.
        val xAxis: XAxis = barChart!!.getXAxis()

        // below line is to set value formatter to our x-axis and
        // we are adding our days to our x axis.

        // below line is to set value formatter to our x-axis and
        // we are adding our days to our x axis.
        xAxis.valueFormatter = IndexAxisValueFormatter(days)

        // below line is to set center axis
        // labels to our bar chart.

        // below line is to set center axis
        // labels to our bar chart.
        xAxis.setCenterAxisLabels(true)

        // below line is to set position
        // to our x-axis to bottom.

        // below line is to set position
        // to our x-axis to bottom.
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        // below line is to set granularity
        // to our x axis labels.

        // below line is to set granularity
        // to our x axis labels.
        xAxis.granularity = 1f

        // below line is to enable
        // granularity to our x axis.

        // below line is to enable
        // granularity to our x axis.
        xAxis.isGranularityEnabled = true

        // below line is to make our
        // bar chart as draggable.

        // below line is to make our
        // bar chart as draggable.
        barChart!!.setDragEnabled(true)

        // below line is to make visible
        // range for our bar chart.

        // below line is to make visible
        // range for our bar chart.
        barChart!!.setVisibleXRangeMaximum(3F)

        // below line is to add bar
        // space to our chart.

        // below line is to add bar
        // space to our chart.
        val barSpace = 0.1f

        // below line is use to add group
        // spacing to our bar chart.

        // below line is use to add group
        // spacing to our bar chart.
        val groupSpace = 0.5f

        // we are setting width of
        // bar in below line.

        // we are setting width of
        // bar in below line.
        data.barWidth = 0.15f

        // below line is to set minimum
        // axis to our chart.

        // below line is to set minimum
        // axis to our chart.
        barChart!!.getXAxis().setAxisMinimum(0F)

        // below line is to
        // animate our chart.

        // below line is to
        // animate our chart.
        barChart!!.animate()

        // below line is to group bars
        // and add spacing to it.

        // below line is to group bars
        // and add spacing to it.
        barChart!!.groupBars(0F, groupSpace, barSpace)

        // below line is to invalidate
        // our bar chart.

        // below line is to invalidate
        // our bar chart.
        barChart!!.invalidate()
    }

    private fun extracted(statsData: ArrayList<home_stats_model>) {
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
        statsData.add(
            home_stats_model(
                "Active", R.drawable.group_1000004869, "60",
                "#4478F2"
            )
        )
    }

    private fun funnelChart(anyChartView: AnyChartView) {
        val funnel = AnyChart.funnel()
        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Website Visits", 528756))
        data.add(ValueDataEntry("Downloads", 164052))
        data.add(ValueDataEntry("Valid Contacts", 112167))
        data.add(ValueDataEntry("Interested to Buy", 79128))

        funnel.data(data)

        funnel.margin(arrayOf("10", "20%", "10", "20%"))
        funnel.baseWidth("70%")
            .neckWidth("17%")

        funnel.labels()
            .position("outsideleft")
            .format("{%X} - {%Value}")

        funnel.animation(true)

        anyChartView.setChart(funnel)
    }
    private fun getBarEntriesOne(): ArrayList<BarEntry>? {

        // creating a new array list
        barEntries = ArrayList<BarEntry>()

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntries!!.add(BarEntry(1f, 4f))
        barEntries!!.add(BarEntry(2f, 6f))
        barEntries!!.add(BarEntry(3f, 8f))
        barEntries!!.add(BarEntry(4f, 2f))
        barEntries!!.add(BarEntry(5f, 4f))
        barEntries!!.add(BarEntry(6f, 1f))
        return barEntries
    }

    // array list for second set.
    private fun getBarEntriesTwo(): ArrayList<BarEntry>? {

        // creating a new array list
        barEntries = ArrayList<BarEntry>()

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntries!!.add(BarEntry(1f, 4f))
        barEntries!!.add(BarEntry(2f, 6f))
        barEntries!!.add(BarEntry(3f, 8f))
        barEntries!!.add(BarEntry(4f, 2f))
        barEntries!!.add(BarEntry(5f, 4f))
        barEntries!!.add(BarEntry(6f, 1f))
        return barEntries
    }


}