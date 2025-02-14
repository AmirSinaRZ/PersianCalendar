package com.amirsinarz.persiancalendar

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.amirsinarz.persiancalendar.model.PersianCalendarColors

object PersianCalendarDefaults {
    @Composable
    fun getPersianCalendarColors(
        dayOffColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = .25f),
        dayColor: Color = MaterialTheme.colorScheme.onBackground.copy(alpha = .25f),
        offCellTextColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = .75f),
        cellTextColor: Color = MaterialTheme.colorScheme.onBackground.copy(alpha = .75f),
        headerColor: Color = MaterialTheme.colorScheme.primary,
        onHeaderColor: Color = MaterialTheme.colorScheme.onPrimary,
        headerDaysOfWeekColor: Color = MaterialTheme.colorScheme.onBackground.copy(alpha = .75f),
        containerColor: Color = MaterialTheme.colorScheme.surface,
        todayColor: Color = MaterialTheme.colorScheme.primary
    ) = PersianCalendarColors(
        dayOffColor = dayOffColor,
        dayColor = dayColor,
        offCellTextColor = offCellTextColor,
        cellTextColor = cellTextColor,
        headerColor = headerColor,
        onHeaderColor = onHeaderColor,
        headerDaysOfWeekColor = headerDaysOfWeekColor,
        containerColor = containerColor,
        todayColor = todayColor
    )

    fun persianCalendarFont(fontFamily: FontFamily = FontFamily(Font(R.font.iranian_sans))): FontFamily = fontFamily
}