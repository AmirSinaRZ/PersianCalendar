package com.amirsinarz.persiancalendar.viewmodel

import android.icu.util.Calendar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.amirsinarz.persiancalendar.model.GregDate
import com.amirsinarz.persiancalendar.model.JalaliDate
import com.amirsinarz.persiancalendar.util.gregorianToJalali
import com.amirsinarz.persiancalendar.util.jalaliToGregorian
import java.time.LocalDate
import java.time.Month

class PersianCalendarViewModel : ViewModel() {

    private val calendar: Calendar = Calendar.getInstance()

    private fun getDefaultDate(
        year: Int = calendar.get(Calendar.YEAR),
        month: Int = calendar.get(Calendar.MONTH) + 1,
        day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    ): LocalDate {
        return LocalDate.of(year, month, day)
    }

    var jalaliDate by mutableStateOf(
        gregorianToJalali(getDefaultDate().year, getDefaultDate().month.value, getDefaultDate().dayOfMonth)
    )
        private set

    private val tempGregDate = jalaliToGregorian(jalaliDate.year, jalaliDate.month, jalaliDate.day)
    val gregDate: GregDate get() {
        return GregDate(tempGregDate[0], tempGregDate[1], tempGregDate[2], getGregMonthOfJalaliMonth())
    }

    private fun getGregMonthOfJalaliMonth(): List<Month> {
        val gregMonthOfFirstDay = jalaliToGregorian(jalaliDate.year, jalaliDate.month, 1)
        return listOf(
            Month.of(gregMonthOfFirstDay[1]),
            Month.of(gregMonthOfFirstDay[1] + 1)
        )
    }

    fun setDate(
        year: Int,
        month: Int,
        day: Int
    ) {
        jalaliDate = JalaliDate(year, month, day)
    }
}