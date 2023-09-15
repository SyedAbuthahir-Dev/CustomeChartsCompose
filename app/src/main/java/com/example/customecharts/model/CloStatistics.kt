package com.example.customecharts.model

import androidx.compose.ui.graphics.Color

//data class CloStatistics(
//    val cloPercentage:Int,
//    val cloTitle:Int,
//)

fun toUiCloStatistics(
    totalSessions: Int,
    cloPercentages: List<Int>,
): List<CloStatistics> {
    return cloPercentages.map { cloPercentage ->
        CloStatistics(
            cloPercentage = cloPercentage,
            cloTitle = (cloPercentage / totalSessions) * 100,
        )
    }
}


data class CloStatistics(
    val cloPercentage: Int,
    val cloTitle: Int
)


data class BarChartItems(
    val barIndex: Int,
    val barHeight: Double,
    val barPercentage: Int,
    val barItem:DeliveredStatus,
)

data class DeliveredStatus(
    val barTitle:String,
    val deliveredSessions:Int,
    val color:Color
)