package com.example.liga.domain.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TimeConverter {
    fun dateConverterToTime(utcDateTime: String?): String {
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

    fun dateConverterToDate(utcDateTime: String?): String {
        val utcFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val utcDate = LocalDateTime.parse(utcDateTime, utcFormatter)
        val utcZone = ZoneId.of("UTC")
        val utcZoned = ZonedDateTime.of(utcDate, utcZone)

        // Format date to zone +5
        val kazakhstanZone = ZoneId.of("Asia/Aqtobe")
        val kazakhstanZoned = utcZoned.withZoneSameInstant(kazakhstanZone)

        // Format to String "HH:mm"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
        return kazakhstanZoned.format(formatter)
    }

    fun getDayImmediate(dayPlus: Int): String {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()

        calendar.time = Date()
        calendar.add(Calendar.DAY_OF_MONTH, dayPlus)
        val newDate = calendar.time
        val immediateDay = dateFormat.format(newDate)

        return immediateDay
    }

    fun getConvertRecycler(utcDate:String?):String{
        val utcFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val utcDate = LocalDateTime.parse(utcDate, utcFormatter)
        val utcZone = ZoneId.of("UTC")
        val utcZoned = ZonedDateTime.of(utcDate, utcZone)

        val formatter = DateTimeFormatter.ofPattern("dd/MM", Locale.getDefault())
        return utcZoned.format(formatter)
    }

    fun getYYYYMMDDfromDate():String{
        val currentDate = Date()
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(currentDate)
        return today
    }
}