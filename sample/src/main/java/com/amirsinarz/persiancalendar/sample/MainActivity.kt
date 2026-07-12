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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amirsinarz.persiancalendar.model.CalendarEvent
import com.amirsinarz.persiancalendar.model.JalaliDate
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
                            events = getEvents()
                        ) { day ->
                            val format = DateTimeFormatter.ofPattern("yyyy, MMM d")
                            val g = day.gregorianDate.format(format)
                            val h = day.hijrahDate.format(format)
                            val j =
                                "${day.jalaliDate.year}/${day.jalaliDate.month}/${day.jalaliDate.day}"
                            val events: String = ((day.event?.data ?: emptyList<List<String>>()) as List<String>).joinToString()


                            text = "$g\n$h\n$j\n$events"
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

    fun getEvents(): List<CalendarEvent<List<String>>> =
        listOf(
            CalendarEvent(
                JalaliDate(1405, 1, 1),
                null,
                listOf("عید نوروز", "عید سعید فطر")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 2),
                null,
                listOf("عید نوروز", "تعطیل عید سعید فطر")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 3),
                null,
                listOf("عید نوروز")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 4),
                null,
                listOf("عید نوروز")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 12),
                null,
                listOf("روز جمهوری اسلامی ایران")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 13),
                null,
                listOf("روز طبیعت")
            ),
            CalendarEvent(
                JalaliDate(1405, 1, 24),
                null,
                listOf("شهادت امام جعفر صادق (ع)")
            ),
            CalendarEvent(
                JalaliDate(1405, 3, 11),
                null,
                listOf("عید سعید قربان")
            ),
            CalendarEvent(
                JalaliDate(1405, 3, 19),
                null,
                listOf("عید سعید غدیر خم", "رحلت حضرت امام خمینی (ره)")
            ),
            CalendarEvent(
                JalaliDate(1405, 3, 20),
                null,
                listOf("قیام ۱۵ خرداد")
            ),
            CalendarEvent(
                JalaliDate(1405, 4, 3),
                null,
                listOf("تاسوعای حسینی")
            ),
            CalendarEvent(
                JalaliDate(1405, 4, 4),
                null,
                listOf("عاشورای حسینی")
            ),
            CalendarEvent(
                JalaliDate(1405, 5, 14),
                null,
                listOf("اربعین حسینی")
            ),
            CalendarEvent(
                JalaliDate(1405, 5, 22),
                null,
                listOf("رحلت حضرت رسول اکرم (ص)", "شهادت امام حسن مجتبی (ع)")
            ),
            CalendarEvent(
                JalaliDate(1405, 5, 23),
                null,
                listOf("شهادت امام رضا (ع)")
            ),
            CalendarEvent(
                JalaliDate(1405, 6, 8),
                null,
                listOf("میلاد حضرت رسول اکرم (ص)", "میلاد امام جعفر صادق (ع)")
            ),
            CalendarEvent(
                JalaliDate(1405, 8, 22),
                null,
                listOf("شهادت حضرت فاطمه زهرا (س)")
            ),
            CalendarEvent(
                JalaliDate(1405, 10, 2),
                null,
                listOf("ولادت امام علی (ع)", "روز پدر")
            ),
            CalendarEvent(
                JalaliDate(1405, 10, 16),
                null,
                listOf("مبعث حضرت رسول اکرم (ص)")
            ),
            CalendarEvent(
                JalaliDate(1405, 11, 4),
                null,
                listOf("ولادت حضرت قائم (عج)", "نیمه شعبان")
            ),
            CalendarEvent(
                JalaliDate(1405, 11, 22),
                null,
                listOf("پیروزی انقلاب اسلامی")
            ),
            CalendarEvent(
                JalaliDate(1405, 12, 9),
                null,
                listOf("شهادت حضرت علی (ع)")
            ),
            CalendarEvent(
                JalaliDate(1405, 12, 19),
                null,
                listOf("عید سعید فطر")
            ),
            CalendarEvent(
                JalaliDate(1405, 12, 20),
                null,
                listOf("تعطیل عید سعید فطر")
            ),
            CalendarEvent(
                JalaliDate(1405, 12, 29),
                null,
                listOf("ملی شدن صنعت نفت ایران")
            )
        )
}