package com.simform.glimpses.model

import java.util.Date
import kotlin.random.Random.Default.nextInt

data class WeekDay(
    val day: String,
    var weekTimes: ArrayList<WeekTime> = arrayListOf(WeekTime()),
    val repeatDaily: Boolean = false,
    var isExpanded: Boolean = false
) {
    companion object {
        val days = arrayListOf(
            WeekDay("Monday"),
            WeekDay("Tuesday"),
            WeekDay("Wednesday"),
            WeekDay("Thursday"),
            WeekDay("Friday"),
            WeekDay("Saturday"),
            WeekDay("Sunday"),
        )
    }
}

data class WeekTime(
    val id: Int = nextInt(from = 0, until = 9999),
    var fromTime: Date? = null, var toTime: Date? = null
)
