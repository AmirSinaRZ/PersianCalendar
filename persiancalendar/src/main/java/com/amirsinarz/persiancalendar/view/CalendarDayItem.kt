package com.amirsinarz.persiancalendar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.model.PersianCalendarColors
import com.amirsinarz.persiancalendar.util.farsiDigits

@Composable
internal fun DayItem(
    modifier: Modifier = Modifier,
    isDayOff: Boolean = false,
    dayOfMonth: Int,
    gregorianDay: Int,
    colors: PersianCalendarColors,
    fontFamily: FontFamily,
    today: Boolean,
    onClick: ()->Unit
) {
    val bgColor = if (isDayOff) colors.dayOffColor else colors.dayColor
    val textColor = if (isDayOff) colors.offCellTextColor else colors.cellTextColor
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(bgColor)
            .aspectRatio(1f)
            .clickable { onClick() }
            .then(
                if (today) Modifier.border(width = 1.dp, color = colors.todayColor, shape = RoundedCornerShape(15.dp)) else Modifier
            )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                dayOfMonth.farsiDigits(),
                color = textColor,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = fontFamily
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            Text(
                gregorianDay.toString(),
                color = textColor.copy(alpha = .6f),
                style = MaterialTheme.typography.bodySmall,
                fontFamily = fontFamily
            )
            Text(
                gregorianDay.farsiDigits(),
                color = textColor.copy(alpha = .6f),
                style = MaterialTheme.typography.bodySmall,
                fontFamily = fontFamily
            )
        }
    }
}

@Composable
internal fun EmptyDayCell() {
    Box(
        modifier = Modifier.aspectRatio(1f).padding(4.dp)
    )
}