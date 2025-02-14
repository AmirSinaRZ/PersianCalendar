package com.amirsinarz.persiancalendar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.amirsinarz.persiancalendar.PersianCalendarDefaults


val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = PersianCalendarDefaults.persianCalendarFont(),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = PersianCalendarDefaults.persianCalendarFont(),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PersianCalendarDefaults.persianCalendarFont(),
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    bodySmall = TextStyle(
        fontFamily = PersianCalendarDefaults.persianCalendarFont(),
        fontWeight = FontWeight.Thin,
        fontSize = 10.sp
    )
)