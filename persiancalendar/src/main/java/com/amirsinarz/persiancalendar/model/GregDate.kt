package com.amirsinarz.persiancalendar.model

import com.amirsinarz.persiancalendar.util.jalaliToGregorian
import java.time.Month
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

data class GregDate(
    val year: Int,
    val month: Int,
    val day: Int,
    val startAndEnd: List<Month>
) {
    fun currentMonthFormat(): String = "${startAndEnd[0].getDisplayName(TextStyle.SHORT, Locale.ENGLISH)}-${startAndEnd[1].getDisplayName(TextStyle.SHORT, Locale.ENGLISH)}"

    private fun daysInPreMonth(): Int {
        return YearMonth.of(year, month-1).lengthOfMonth()
    }

    private fun daysInMonth(): Int {
        return YearMonth.of(year, month).lengthOfMonth()
    }

    private fun firstDayOfMonth(jDate: JalaliDate): Int {
        val date = jalaliToGregorian(jDate.year, jDate.month, 1)
        return date[2]
    }

    fun listOfDays(
        jDate: JalaliDate
    ): List<Int> {
        val firstList = (firstDayOfMonth(jDate)..daysInPreMonth()).toList()
        val secondList = (1..daysInMonth()).toList()
        return firstList + secondList
    }
}
