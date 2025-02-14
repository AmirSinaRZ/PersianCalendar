package com.amirsinarz.persiancalendar.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.PersianCalendarDefaults
import com.amirsinarz.persiancalendar.model.JalaliDate
import com.amirsinarz.persiancalendar.sample.ui.theme.SampleTheme
import com.amirsinarz.persiancalendar.view.PersianCalendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        var text by remember { mutableStateOf("") }
                        var today by remember { mutableIntStateOf(1) }

                        PersianCalendar(
                            modifier = Modifier.padding(8.dp),
                            elevation = 5.dp,
                            initDate = JalaliDate(1397, 4, today),
                            colors = PersianCalendarDefaults.getPersianCalendarColors(
                                headerColor = Color(0xFF007776),
                                headerDaysOfWeekColor = Color(0xFF007776),
                                dayColor = Color(0xFFf8f8f8),
                                dayOffColor = Color(0xFFFFF3E7),
                                cellTextColor = Color(0xFF637253),
                                offCellTextColor = Color(0xFFCA6700),
                                todayColor = Color(0xFF007776),
                                containerColor = Color.White
                            )
                        ) { jalaliDate, localDate ->
                            text = "${jalaliDate.format()} ${jalaliDate.getMonth()} ${
                                jalaliDate.dayOfWeek(jalaliDate.day)
                            }\n $localDate"
                            today = jalaliDate.day
                        }

                        Spacer(Modifier.height(60.dp))

                        Text(
                            text = text,
                            textAlign = TextAlign.Center
                        )

//                        PersianCalendar(
//                            modifier = Modifier.padding(8.dp),
//                            elevation = 5.dp,
//                            colors = PersianCalendarDefaults.getPersianCalendarColors(
//                                headerColor = Color(0xFF007776),
//                                headerDaysOfWeekColor = Color(0xFF007776),
//                                dayColor = Color(0xFFf8f8f8),
//                                dayOffColor = Color(0xFFFFF3E7),
//                                cellTextColor = Color(0xFF637253),
//                                offCellTextColor = Color(0xFFCA6700),
//                                todayColor = Color(0xFF007776),
//                                containerColor = Color.White
//                            )
//                        ) { jalaliDate, localDate ->
//                            text = "${jalaliDate.format()} ${jalaliDate.getMonth()} ${
//                                jalaliDate.dayOfWeek(jalaliDate.day)
//                            }\n $localDate"
//                            today = jalaliDate.day
//                        }

                    }
                }
            }
        }
    }
}