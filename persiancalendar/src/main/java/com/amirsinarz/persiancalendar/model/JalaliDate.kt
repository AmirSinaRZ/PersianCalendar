package com.amirsinarz.persiancalendar.model

import com.amirsinarz.persiancalendar.Constants
import com.amirsinarz.persiancalendar.exception.IllegalMonthException
import com.amirsinarz.persiancalendar.util.jalaliToGregorian
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

data class JalaliDate(
    val year: Int,
    val month: Int,
    val day: Int
) {
    fun getMonth(): String {
        val month = when (this.month) {
            1 -> Constants.JALALI_MONTH[0]
            2 -> Constants.JALALI_MONTH[1]
            3 -> Constants.JALALI_MONTH[2]
            4 -> Constants.JALALI_MONTH[3]
            5 -> Constants.JALALI_MONTH[4]
            6 -> Constants.JALALI_MONTH[5]
            7 -> Constants.JALALI_MONTH[6]
            8 -> Constants.JALALI_MONTH[7]
            9 -> Constants.JALALI_MONTH[8]
            10 -> Constants.JALALI_MONTH[9]
            11 -> Constants.JALALI_MONTH[10]
            12 -> Constants.JALALI_MONTH[11]
            else -> throw IllegalMonthException("Incorrect month: ${this.month}, month should be between 1..12")
        }
        return month
    }

    private fun daysInMonth(): Int {
        val count = when (month) {
            1, 2, 3, 4, 5, 6 -> 31
            7, 8, 9, 10, 11 -> 30
            12 -> if (isLeapYear()) 30 else 29
            else -> throw IllegalMonthException("Incorrect month: $month, month should be between 1..12")
        }
        return count
    }

    internal fun listOfDays(): List<JalaliDay> {
        return (1..daysInMonth()).map { day ->
            JalaliDay(
                dayOfWeek = day.dayOfWeek(),
                isDayOff = day.isFriDay(),
                dayOfMonth = day,
                isToday = day.isToday()
            )
            //TODO: add holidays for day off
        }
    }

    private fun Int.isToday(): Boolean {
        return this == day
    }

    fun format(c: Char = '-'): String {
        return "$year$c$month$c$day"
    }

    private fun isLeapYear(): Boolean {
        val r = year % 33
        return r in listOf(1, 5, 9, 13, 17, 22, 26, 30)
    }

    private fun Int.dayOfWeek(): DayOfWeek {
        val greg = jalaliToGregorian(year, month, this)
        val date = LocalDate.of(greg[0], greg[1], greg[2])
        return date.dayOfWeek
    }

    fun dayOfWeek(day: Int): String = day.dayOfWeek().getDisplayName(TextStyle.FULL, Locale("fa", "IR"))

    private fun Int.isFriDay(): Boolean {
        return this.dayOfWeek() == DayOfWeek.FRIDAY
    }

    fun firstDayOfWeek(): DayOfWeek {
        val greg = jalaliToGregorian(year, month, 1)
        val date = LocalDate.of(greg[0], greg[1], greg[2] + 1)
        return date.dayOfWeek
    }
}