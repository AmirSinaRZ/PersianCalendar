package com.amirsinarz.persiancalendar.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.model.JalaliDay
import com.amirsinarz.persiancalendar.model.PersianCalendarColors
import kotlinx.coroutines.delay

@Composable
internal fun DaysCellGrid(
    animate: Boolean,
    animatePerItem: Boolean,
    animationDuration: Int,
    animationDelay: Long,
    colors: PersianCalendarColors,
    fontFamily: FontFamily,
    skipDays: Int,
    days: List<JalaliDay>,
    gregDays: List<Int>,
    onClick: (JalaliDay, Int) -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyGridState()
        ) {
            if (skipDays < 7) {
                items(skipDays) {
                    EmptyDayCell()
                }
            }
            itemsIndexed(days) { index, day ->

                var visible by remember { mutableStateOf(animate.not()) }
                val alpha by animateFloatAsState(
                    targetValue = if (visible) 1f else 0f,
                    animationSpec = tween(animationDuration),
                    label = "alpha"
                )
                val scale by animateFloatAsState(
                    targetValue = if (visible) 1f else .8f,
                    animationSpec = tween(animationDuration),
                    label = "scale"
                )

                LaunchedEffect(Unit) {
                    delay(if (animatePerItem) index*animationDelay else animationDelay)
                    visible = true
                }

                DayItem(
                    modifier = Modifier
                        .scale(scale)
                        .alpha(alpha),
                    colors = colors,
                    isDayOff = day.isDayOff,
                    dayOfMonth = day.dayOfMonth,
                    gregorianDay = gregDays[index],
                    today = day.isToday,
                    fontFamily = fontFamily
                ) {
                    onClick(day, gregDays[index])
                }
            }
        }
    }
}