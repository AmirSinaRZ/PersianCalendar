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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.PersianCalendarDefaults
import com.amirsinarz.persiancalendar.sample.ui.theme.SampleTheme
import com.amirsinarz.persiancalendar.view.PersianCalendar
import java.time.format.DateTimeFormatter

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

                        PersianCalendar(
                            modifier = Modifier.padding(8.dp),
                            elevation = 5.dp,
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
                        ) { day ->
                            val format = DateTimeFormatter.ofPattern("yyyy, MMM d")
                            val g = day.gregorianDate.format(format)
                            val h = day.hijrahDate.format(format)
                            val j = "${day.jalaliDate.year}/${day.jalaliDate.month}/${day.jalaliDate.day}"
                            text = "$g\n$h\n$j"
                        }

                        Spacer(Modifier.height(60.dp))

                        Text(
                            text = text,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}