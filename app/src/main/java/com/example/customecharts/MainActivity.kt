package com.example.customecharts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.customecharts.model.BarChartItems
import com.example.customecharts.model.CloStatistics
import com.example.customecharts.model.DeliveredStatus
import com.example.customecharts.model.toUiCloStatistics
import com.example.customecharts.ui.theme.BarChartViewModel
import com.example.customecharts.ui.theme.BarStatus
import com.example.customecharts.ui.theme.CurricularDeliveryItem
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter


class MainActivity : ComponentActivity() {
    val barChartViewModel: BarChartViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                ){
//                    CustomBarChart(
//                        totalChartHeight = barChartViewModel.totalChartHeight,
//                        totalDays = barChartViewModel.totalDays,
//                        totalRows = barChartViewModel.totalRows,
//                        singleChartRowHeight = barChartViewModel.singleChartRowHeight,
//                        deliveredStatus = barChartViewModel.deliveredStatus
//                    )
//
//                    Column(
//                        modifier = Modifier
//                            .height(600.dp)
//                            .verticalScroll(rememberScrollState())
//                    ){
//                        Spacer(modifier = Modifier.padding(20.dp))
//                        AllDeliveriesCard(
//                            allDeliveriesList = listOf(
//                                CurricularDeliveryItem(
//                                    title = "Completed",
//                                    count = 10,
//                                    color = Color(0xFF16A34A)
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "In Progres",
//                                    count = 10,
//                                    color = Color(0xFF4F46E5)
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Not Started",
//                                    count = 10,
//                                    color = Color(0xFFF59E0B)
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Missed",
//                                    count = 10,
//                                    color = Color(0xCC850000)
//
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Cancelled",
//                                    count = 10,
//                                    color = Color(0xFFF59E0B)
//
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Upcoming",
//                                    count = 10,
//                                    color = Color(0xFF4B5563)
//
//                                ),
//                            ),
//                            onAllDeliveriesClicked = {}
//                        )
//                        Spacer(modifier = Modifier.padding(20.dp))
//                        MergedSessionCard(
//                            totalMergedSession = 10,
//                            onMergedSessionsCardClicked = {}
//                        )
//                        Spacer(modifier = Modifier.padding(20.dp))
//                        CurricularDeliveryIssueCard(
//                            curricularDeliveryIssues = listOf(
//                                CurricularDeliveryItem(
//                                    title = "Not Started",
//                                    count = 10,
//                                    color = Color(0xFFF59E0B)
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Missed",
//                                    count = 10,
//                                    color = Color(0xCC850000)
//
//                                ),
//                                CurricularDeliveryItem(
//                                    title = "Cancelled",
//                                    count = 10,
//                                    color = Color(0xFFEF4444)
//
//                                ),
//                            ),
//                            onCurricularDeliveryIssueCardClicked = {}
//                        )
//                        Spacer(modifier = Modifier.padding(20.dp))
//                        SummaryDetails(
//                            programCount = 5,
//                            filtersCount = 5,
//                            onFilterClicked = {}
//                        )
//                        Spacer(modifier = Modifier.padding(20.dp))
//                    }
//                }
            BarchartScreen(
                barChartViewModel = barChartViewModel
            )
        }
    }
}

@Composable
fun BarchartScreen(barChartViewModel: BarChartViewModel) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.padding(20.dp))
                SummaryDetails(
                    programCount = 5,
                    filtersCount = 5,
                    onFilterClicked = {}
                )
                Spacer(modifier = Modifier.padding(20.dp))
                CustomBarChart(
                    totalChartHeight = barChartViewModel.totalChartHeight,
                    totalDays = barChartViewModel.totalDays,
                    totalRows = barChartViewModel.totalRows,
                    singleChartRowHeight = barChartViewModel.singleChartRowHeight,
                    deliveredStatus = barChartViewModel.deliveredStatus
                )
                Spacer(modifier = Modifier.padding(20.dp))
                AllDeliveriesCard(
                    allDeliveriesList = listOf(
                        CurricularDeliveryItem(
                            title = "Completed",
                            count = 10,
                            color = Color(0xFF16A34A)
                        ),
                        CurricularDeliveryItem(
                            title = "In Progres",
                            count = 10,
                            color = Color(0xFF4F46E5)
                        ),
                        CurricularDeliveryItem(
                            title = "Not Started",
                            count = 10,
                            color = Color(0xFFF59E0B)
                        ),
                        CurricularDeliveryItem(
                            title = "Missed",
                            count = 10,
                            color = Color(0xCC850000)

                        ),
                        CurricularDeliveryItem(
                            title = "Cancelled",
                            count = 10,
                            color = Color(0xFFF59E0B)

                        ),
                        CurricularDeliveryItem(
                            title = "Upcoming",
                            count = 10,
                            color = Color(0xFF4B5563)

                        ),
                    ),
                    onAllDeliveriesClicked = {}
                )
                Spacer(modifier = Modifier.padding(20.dp))
                MergedSessionCard(
                    totalMergedSession = 10,
                    onMergedSessionsCardClicked = {}
                )
                Spacer(modifier = Modifier.padding(20.dp))
                CurricularDeliveryIssueCard(
                    curricularDeliveryIssues = listOf(
                        CurricularDeliveryItem(
                            title = "Not Started",
                            count = 10,
                            color = Color(0xFFF59E0B)
                        ),
                        CurricularDeliveryItem(
                            title = "Missed",
                            count = 10,
                            color = Color(0xCC850000)

                        ),
                        CurricularDeliveryItem(
                            title = "Cancelled",
                            count = 10,
                            color = Color(0xFFEF4444)

                        ),
                    ),
                    onCurricularDeliveryIssueCardClicked = {}
                )
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CloChartPreview() {
    CloChart(
        totalDays = 200,
        cloPercentage = listOf(
            75, 35, 15, 65, 50, 50,
        )
    )
}

@Composable
fun CloChart(
    totalDays: Int,
    cloPercentage: List<Int>,
) {

    val cloStatistics = toUiCloStatistics(
        totalSessions = totalDays,
        cloPercentages = cloPercentage
    )
    Log.e("cloData", "CloData : ${cloStatistics.toString()}")
    val context = LocalContext.current
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        factory = { cont ->
            BarChart(cont)
        },
        update = { barchart ->
            val entries = cloStatistics.mapIndexed { index, cloStatistics ->
                BarEntry(
                    index.toFloat(),
                    cloStatistics.cloTitle.toFloat(),
                )
            }

            val dataSet = BarDataSet(entries, "CloData").apply {
                color = ContextCompat.getColor(context, R.color.bluechart)
            }

            val barData = BarData(dataSet).apply {}

            val xAxisLabel = ArrayList<String>()
            xAxisLabel.add("Completed")
            xAxisLabel.add("InProgress")
            xAxisLabel.add("Not Started")
            xAxisLabel.add("Missed")
            xAxisLabel.add("Cancelled")
            xAxisLabel.add("UpComing")

            barchart.apply {
                setFitBars(true)
                setDrawValueAboveBar(true)
                setDrawGridBackground(false)
                setDrawBorders(false)
                setDrawGridBackground(false)
                axisRight.setDrawGridLines(false)
                xAxis.setDrawGridLines(false)
                axisRight.isEnabled = false

                xAxis.setLabelCount(cloStatistics.size, true)
                xAxis.labelCount = cloStatistics.size
                xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabel)
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.granularity = 1f
                xAxis.isGranularityEnabled = true
                description.isEnabled = false
            }
            barData.barWidth = 0.3f
            barchart.data = barData
            barchart.invalidate()
        },
    )
}

@Preview(showBackground = true)
@Composable
fun CloGroupChartPreview() {
    CloGroupChart(
        cloStatistics = listOf(
            CloStatistics(0, 100),
            CloStatistics(25, 40),
            CloStatistics(50, 30),
            CloStatistics(75, 70),
            CloStatistics(100, 90),
            CloStatistics(100, 90),
        ),
        cloStatistics2 = listOf(
            CloStatistics(100, 30),
            CloStatistics(25, 20),
            CloStatistics(50, 80),
            CloStatistics(75, 10),
            CloStatistics(100, 60),
            CloStatistics(100, 60),

            )

    )
}

@Composable
fun CloGroupChart(
    cloStatistics: List<CloStatistics>,
    cloStatistics2: List<CloStatistics>
) {

    val context = LocalContext.current
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        factory = { cont ->
            BarChart(cont)
        },
        update = { barchart ->
            val entries1 = cloStatistics.mapIndexed { index, cloStatistics ->
                BarEntry(
                    index.toFloat(),
                    cloStatistics.cloTitle.toFloat(),
                )
            }
            val entries2 = cloStatistics2.mapIndexed { index, cloStatistics ->
                BarEntry(
                    index.toFloat(),
                    cloStatistics.cloTitle.toFloat(),
                )
            }
            val dataSet1 = BarDataSet(entries1, "CloAttainment").apply {
                color = ContextCompat.getColor(context, R.color.bluechart)
            }
            val dataSet2 = BarDataSet(entries2, "TargetAttainment").apply {
                color = ContextCompat.getColor(context, R.color.greenchart)
            }
            val barData = BarData(dataSet1, dataSet2).apply {}
            val xAxisLabel = ArrayList<String>()
            xAxisLabel.add("Sun")
            xAxisLabel.add("Mon")
            xAxisLabel.add("Tue")
            xAxisLabel.add("Wed")
            xAxisLabel.add("Thu")
            xAxisLabel.add("Fri")
            xAxisLabel.add("Sat")
            barchart.apply {
                setFitBars(true)
                setDrawValueAboveBar(true)
                setDrawGridBackground(false)
                setDrawBorders(false)
                setDrawGridBackground(false)
                axisRight.setDrawGridLines(false)
                xAxis.setDrawGridLines(false)
                axisRight.isEnabled = false
                description.isEnabled = false

                xAxis.setLabelCount(cloStatistics.size, true)
                xAxis.labelCount = cloStatistics.size
                xAxis.valueFormatter = IndexAxisValueFormatter(xAxisLabel)
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.granularity = 1f
                xAxis.isGranularityEnabled = true
                xAxis.setCenterAxisLabels(true)
            }
            barchart.data = barData
            barData.barWidth = 0.3f
            barchart.groupBars(0F, 0.5f, 0f)
            //  barchart.animateXY(3000,3000)
            barchart.invalidate()
        },
    )
}

@Preview
@Composable
fun BarChartPreview() {
    CustomBarChart(
        totalChartHeight = 300,
        totalDays = 200,
        totalRows = 5,
        singleChartRowHeight = 300 / 5,
        deliveredStatus = listOf(
            BarChartItems(
                barIndex = 0,
                barHeight = 30.00,
                barPercentage = 10,
                barItem = DeliveredStatus(
                    barTitle = "",
                    deliveredSessions = 100,
                    color = Color.LightGray
                )
            ),
            BarChartItems(
                barIndex = 0,
                barHeight = 30.00,
                barPercentage = 10,
                barItem = DeliveredStatus(
                    barTitle = "",
                    deliveredSessions = 100,
                    color = Color.LightGray
                )
            ),
            BarChartItems(
                barIndex = 0,
                barHeight = 30.00,
                barPercentage = 10,
                barItem = DeliveredStatus(
                    barTitle = "",
                    deliveredSessions = 100,
                    color = Color.LightGray
                )
            ),
            BarChartItems(
                barIndex = 0,
                barHeight = 30.00,
                barPercentage = 10,
                barItem = DeliveredStatus(
                    barTitle = "",
                    deliveredSessions = 100,
                    color = Color.LightGray
                )
            ),
            BarChartItems(
                barIndex = 0,
                barHeight = 30.00,
                barPercentage = 10,
                barItem = DeliveredStatus(
                    barTitle = "",
                    deliveredSessions = 100,
                    color = Color.LightGray
                )
            ),
        )
    )
}

@Composable
fun CustomBarChart(
    totalChartHeight: Int,
    totalDays: Int,
    totalRows: Int,
    singleChartRowHeight: Int,
    deliveredStatus: List<BarChartItems>
) {
    var remaining = 0
    Card(
        modifier = Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "Total Delivery Status (${totalDays})",
                modifier = Modifier.padding(10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((totalChartHeight + 20).dp)
                    .padding(horizontal = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .height(totalChartHeight.dp)
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    for (i in 0 until totalRows) {
                        if (i >= 1) remaining += (totalDays / 4)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(singleChartRowHeight.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "${totalDays - remaining}",
                                modifier = Modifier
                                    .offset(y = (-10).dp)
                                    .width(30.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(
                                modifier = Modifier
                                    .padding(2.dp)
                            )
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((totalChartHeight + 20).dp)
                            .horizontalScroll(rememberScrollState()),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        deliveredStatus.forEach { deliveryStatusItem ->
                            SingleBar(
                                barHeight = deliveryStatusItem.barHeight,
                                color = deliveryStatusItem.barItem.color,
                                barPercentage = deliveryStatusItem.barPercentage,
                                barTitle = deliveryStatusItem.barItem.barTitle,
                                singleChartRowHeight = singleChartRowHeight
                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun SingleBarPreview() {
    SingleBar(
        barHeight = 100.0,
        color = Color.LightGray,
        barPercentage = 75,
        barTitle = "Completed",
        singleChartRowHeight = 60
    )
}

@Composable
fun SingleBar(
    barHeight: Double,
    color: Color,
    barPercentage: Int,
    barTitle: String,
    singleChartRowHeight: Int
) {
    var barState by remember { mutableStateOf(BarStatus.START) }
    val barHeightAnimation by animateFloatAsState(
        if (barState == BarStatus.START) 0f else barHeight.toFloat(),
        tween(1000),
        label = ""
    )
    LaunchedEffect(key1 = true) {
        barState = BarStatus.FINISH
    }
    Column(
        modifier = Modifier
            .padding(start = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${barPercentage}%",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Box(
            modifier = Modifier
                .height(barHeightAnimation.dp)
                .width(20.dp)
                .background(color)
                .padding(bottom = 5.dp)
        ) {}

        Text(
            text = barTitle,
            fontSize = 12.sp,
            color = color,
            modifier = Modifier
                .rotate(-60f)
                .height(singleChartRowHeight.dp)
                .offset(x = (-10).dp, y = 10.dp)
        )
    }
}

@Preview
@Composable
fun MergedSessionCardPreview() {
    MergedSessionCard(
        totalMergedSession = 10,
        onMergedSessionsCardClicked = {}
    )
}

@Composable
fun MergedSessionCard(
    totalMergedSession: Int,
    onMergedSessionsCardClicked: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onMergedSessionsCardClicked() },
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Merged Session",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF4B5563)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$totalMergedSession",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4B5563)
            )
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "MergedSession",
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp),
                tint = Color(0xFF4B5563)
            )
        }
    }
}

@Preview
@Composable
fun CurricularActivityIssueCardPreview() {
    CurricularDeliveryIssueCard(
        curricularDeliveryIssues = listOf(
            CurricularDeliveryItem(
                title = "Not Started",
                count = 10,
                color = Color(0xFFF59E0B)
            ),
            CurricularDeliveryItem(
                title = "Missed",
                count = 10,
                color = Color(0xCC850000)

            ),
            CurricularDeliveryItem(
                title = "Cancelled",
                count = 10,
                color = Color(0xFFEF4444)
            ),
        ),
        onCurricularDeliveryIssueCardClicked = {}
    )
}

@Composable
fun CurricularDeliveryIssueCard(
    curricularDeliveryIssues: List<CurricularDeliveryItem>,
    onCurricularDeliveryIssueCardClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onCurricularDeliveryIssueCardClicked() },
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Curricular Delivery Issues",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4B5563)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier
                        .weight(.9f),
                ) {
                    curricularDeliveryIssues.forEach { curricularItem ->
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = 2.dp,
                            backgroundColor = Color(0xFFF3F4F6)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = curricularItem.title,
                                    color = curricularItem.color,
                                    fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    text = "${curricularItem.count}",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "MergedSession",
                    modifier = Modifier
                        .size(70.dp)
                        .weight(.1f)
                        .offset(y = (-10).dp),
                    tint = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun AllDeliveriesCardPreview() {
    AllDeliveriesCard(
        allDeliveriesList = listOf(
            CurricularDeliveryItem(
                title = "Completed",
                count = 10,
                color = Color(0xFF16A34A)
            ),
            CurricularDeliveryItem(
                title = "In Progres",
                count = 10,
                color = Color(0xFF4F46E5)
            ),
            CurricularDeliveryItem(
                title = "Not Started",
                count = 10,
                color = Color(0xFFF59E0B)
            ),
            CurricularDeliveryItem(
                title = "Missed",
                count = 10,
                color = Color(0xCC850000)

            ),
            CurricularDeliveryItem(
                title = "Cancelled",
                count = 10,
                color = Color(0xFFEF4444)

            ),
            CurricularDeliveryItem(
                title = "Upcoming",
                count = 10,
                color = Color(0xFF4B5563)

            ),
        ),
        onAllDeliveriesClicked = {}
    )
}

@Composable
fun AllDeliveriesCard(
    allDeliveriesList: List<CurricularDeliveryItem>,
    onAllDeliveriesClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onAllDeliveriesClicked() },
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "All Deliveries",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4B5563)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp, max = 200.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.weight(.9f),
                    columns = GridCells.Fixed(3),
                ) {
                    items(allDeliveriesList) { curricularItem ->
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = 2.dp,
                            backgroundColor = Color(0xFFF3F4F6)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = curricularItem.title,
                                    color = curricularItem.color,
                                    fontSize = 12.sp
                                )
                                Spacer(modifier = Modifier.padding(5.dp))
                                Text(
                                    text = "${curricularItem.count}",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "MergedSession",
                    modifier = Modifier
                        .size(70.dp)
                        .weight(.1f),
                    tint = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun SummaryDetailsPreview() {
    SummaryDetails(
        programCount = 5,
        filtersCount = 5,
        onFilterClicked = {}
    )
}

@Composable
fun SummaryDetails(
    programCount: Int,
    filtersCount: Int,
    onFilterClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Summary of $programCount Program",
            color = Color(0xFF374151),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Box {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.FilterList, contentDescription = "filter")
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .size(25.dp)
                        .border(BorderStroke(1.dp, Color.White), CircleShape),
                ) {
                    drawCircle(
                        color = Color(0xFF147AFC)
                    )
                }
                Text(
                    text = filtersCount.toString(),
                    fontSize = 8.sp,
                    color = Color.White
                )
            }

        }
    }
}