package com.amirsinarz.persiancalendar.model

import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

data class GregDate(
    val year: Int,
    val month: Int,
    val day: Int,
    val startAndEnd: List<Month>
) {
    fun currentMonthFormat(): String = "${startAndEnd[0].getDisplayName(TextStyle.SHORT, Locale.ENGLISH)}-${startAndEnd[1].getDisplayName(TextStyle.SHORT, Locale.ENGLISH)}"
}
