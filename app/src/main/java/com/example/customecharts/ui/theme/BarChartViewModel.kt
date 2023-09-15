package com.example.customecharts.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.customecharts.model.BarChartItems
import com.example.customecharts.model.DeliveredStatus

class BarChartViewModel : ViewModel() {

    val totalDays = 100
    val totalRows = 5
    val totalBars = 6
    val totalChartHeight = 300
    val singleChartRowHeight = totalChartHeight / 5
    var percent: Double = 0.0
    val deliveredStatus = mutableListOf<BarChartItems>()
    val deliveredItems = listOf(
        DeliveredStatus(
            barTitle = "Completed",
            deliveredSessions = 50,
            color = Color(0xFF16A34A)
        ), DeliveredStatus(
            barTitle = "InProgress",
            deliveredSessions = 70,
            color = Color(0xFF4F46E5)
        ), DeliveredStatus(
            barTitle = "NotStarted",
            deliveredSessions = 30,
            color = Color(0xFFD97706)
        ), DeliveredStatus(
            barTitle = "Missed",
            deliveredSessions = 60,
            color = Color(0xFF850000)
        ), DeliveredStatus(
            barTitle = "Cancelled",
            deliveredSessions = 100,
            color = Color(0xFFDC2626)
        ), DeliveredStatus(
            barTitle = "UpComing",
            deliveredSessions = 35,
            color = Color(0xFF4B5563)
        )
    )

    val curriculumDeliveryIssues = listOf<CurricularDeliveryItem>(
        CurricularDeliveryItem(
            title = "Not Started",
            count = 10,
            color = Color(0xFFF59E0B)
        ),CurricularDeliveryItem(
            title = "Missed",
            count = 10,
            color = Color(0xCC850000)

        ),CurricularDeliveryItem(
            title = "Cancelled",
            count = 10,
            color = Color(0xFFF59E0B)

        ),
    )

    init {
        calculateBarDetails()
    }

    private fun calculateBarDetails() {
        for (i in 0 until totalBars) {
            percent = (deliveredItems[i].deliveredSessions.toDouble() / totalDays.toDouble()) * 100
            deliveredStatus.add(
                BarChartItems(
                    barIndex = i,
                    barHeight = (percent / 100.0) * (totalChartHeight - singleChartRowHeight),
                    barPercentage = percent.toInt(),
                    barItem = DeliveredStatus(
                        barTitle = deliveredItems[i].barTitle,
                        deliveredSessions = deliveredItems[i].deliveredSessions,
                        color = deliveredItems[i].color
                    )
                )
            )
        }
    }
}

data class CurricularDeliveryItem(
    val title: String,
    val count: Int,
    val color: Color
)

enum class BarStatus {
    START,
    FINISH
}