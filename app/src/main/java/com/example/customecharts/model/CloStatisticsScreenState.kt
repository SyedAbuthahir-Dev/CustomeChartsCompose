package com.example.customecharts.model

data class CloStatisticsScreenState(
    val cloStatisticsState :List<CloStatistics>,
){
    companion object{
        val initialState = CloStatisticsScreenState(
            cloStatisticsState =listOf(
                CloStatistics(0,20),
                CloStatistics(25,40),
                CloStatistics(50,30),
                CloStatistics(75,70),
                CloStatistics(100,90),
            ),
        )
    }
}
