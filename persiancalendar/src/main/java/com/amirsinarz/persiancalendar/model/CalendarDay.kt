package com.amirsinarz.persiancalendar.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.chrono.HijrahDate

data class CalendarDay(
    val dayOfWeek: DayOfWeek,
    val isDayOff: Boolean,
    val dayOfMonth: Int,
    val jalaliDate: JalaliDate,
    val gregorianDate: LocalDate,
    val hijrahDate: HijrahDate,
    val isToday: Boolean
)
//TODO: add desc and events