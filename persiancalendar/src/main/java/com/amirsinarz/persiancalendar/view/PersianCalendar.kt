package com.amirsinarz.persiancalendar.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.amirsinarz.persiancalendar.PersianCalendarDefaults
import com.amirsinarz.persiancalendar.model.JalaliDate
import com.amirsinarz.persiancalendar.model.PersianCalendarColors
import com.amirsinarz.persiancalendar.ui.theme.PersianCalendarTheme
import com.amirsinarz.persiancalendar.util.farsiDigits
import com.amirsinarz.persiancalendar.util.jalaliToGregorian
import com.amirsinarz.persiancalendar.viewmodel.PersianCalendarViewModel
import java.time.LocalDate

@Composable
fun PersianCalendar(
    modifier: Modifier = Modifier,
    colors: PersianCalendarColors = PersianCalendarDefaults.getPersianCalendarColors(),
    fontFamily: FontFamily = PersianCalendarDefaults.persianCalendarFont(),
    viewModel: PersianCalendarViewModel = viewModel(),
    initDate: JalaliDate = viewModel.jalaliDate,
    elevation: Dp = 0.dp,
    contentPadding: Dp = 5.dp,
    cornerRadius: Dp = 8.dp,
    showFullWeekDay: Boolean = false,
    animate: Boolean = true,
    animatePerItem: Boolean = true,
    animationDuration: Int = 200,
    animationDelay: Long = 30L,
    onDateSelected: (JalaliDate, LocalDate)->Unit,
) {
    viewModel.setDate(initDate.year, initDate.month, initDate.day)
    val jalaliDate = viewModel.jalaliDate
    val gregDate = viewModel.gregDate

    PersianCalendarTheme {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = colors.containerColor
            ),
            elevation = CardDefaults.cardElevation(elevation),
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Column(
                modifier = Modifier.padding(contentPadding)
            ) {
                CalHeader(
                    gregorianMonth = gregDate.currentMonthFormat(),
                    jalaliYear = jalaliDate.year.farsiDigits(),
                    jalaliMonth = jalaliDate.getMonth(),
                    colors = colors,
                    showFullWeekDay = showFullWeekDay,
                    fontFamily = fontFamily
                )
                DaysCellGrid(
                    animate = animate,
                    animatePerItem = animatePerItem,
                    animationDuration = animationDuration,
                    animationDelay = animationDelay,
                    colors = colors,
                    fontFamily = fontFamily,
                    skipDays = jalaliDate.firstDayOfWeek().value,
                    days = jalaliDate.listOfDays(),
                    gregDays = gregDate.listOfDays(jalaliDate)
                ) { jDay, gDay ->
                    val date = jalaliToGregorian(jalaliDate.year, jalaliDate.month, jDay.dayOfMonth)
                    onDateSelected(
                        JalaliDate(viewModel.jalaliDate.year, viewModel.jalaliDate.month, jDay.dayOfMonth),
                        LocalDate.of(date[0], date[1], gDay)
                    )
                }
            }
        }
    }
}