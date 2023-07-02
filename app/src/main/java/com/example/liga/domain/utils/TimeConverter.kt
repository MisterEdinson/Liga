package com.example.liga.domain.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TimeConverter {
    fun dateConverterDay(utcDateTime: String?): String {

        val utcFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val utcDate = LocalDateTime.parse(utcDateTime, utcFormatter)
        val utcZone = ZoneId.of("UTC")
        val utcZoned = ZonedDateTime.of(utcDate, utcZone)

        // Format date to zone +5
        val kazakhstanZone = ZoneId.of("Asia/Aqtobe")
        val kazakhstanZoned = utcZoned.withZoneSameInstant(kazakhstanZone)

        // Format to String "HH:mm"
        val formatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())
        return kazakhstanZoned.format(formatter)
    }

    fun getDayImmediate(today:Date, dayPlus:Int):String{

        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.time = today
        calendar.add(Calendar.DAY_OF_MONTH, dayPlus)
        val newDate = calendar.time
        val immediateDay = dateFormat.format(newDate)

        return immediateDay

    }
}