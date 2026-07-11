package com.amirsinarz.persiancalendar.model

data class CalendarEvent<T>(
    val date: JalaliDate,
    val title: String?,
    val data: T
)
