package com.amirsinarz.persiancalendar.model

import java.time.DayOfWeek

data class JalaliDay(
    val dayOfWeek: DayOfWeek,
    val isDayOff: Boolean,
    val dayOfMonth: Int,
    val isToday: Boolean
)
//TODO: add desc and events