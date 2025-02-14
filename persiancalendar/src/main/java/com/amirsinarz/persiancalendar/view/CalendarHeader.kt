package com.amirsinarz.persiancalendar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.Constants
import com.amirsinarz.persiancalendar.model.PersianCalendarColors

@Composable
internal fun CalHeader(
    gregorianMonth: String,
    jalaliYear: String,
    jalaliMonth: String,
    showFullWeekDay: Boolean,
    colors: PersianCalendarColors,
    fontFamily: FontFamily
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.headerColor, shape = RoundedCornerShape(5.dp))
                .padding(12.dp)
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Text(
                gregorianMonth,
                color = colors.onHeaderColor,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = fontFamily
            )
            Text(
                "$jalaliMonth $jalaliYear",
                color = colors.onHeaderColor,
                style = MaterialTheme.typography.titleLarge,
                fontFamily = fontFamily
            )
        }
        DayOfWeeks(colors.headerDaysOfWeekColor, showFullWeekDay, fontFamily)
    }
}

@Composable
private fun DayOfWeeks(textColor: Color, showFullWeekDay: Boolean, fontFamily: FontFamily) {
    val days = Constants.DAYS_OF_WEEK
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp)
    ) {
        for (i in days.lastIndex downTo 0) {
            val text = if (showFullWeekDay) days[i] else days[i].first().toString()
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }
    }
}