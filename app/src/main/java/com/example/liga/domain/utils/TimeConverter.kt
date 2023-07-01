package com.example.liga.domain.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class TimeConverter {
    fun dateConverterDay(utcDateTime: String?):String{

        val utcFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val utcDate = LocalDateTime.parse(utcDateTime, utcFormatter)
        val utcZone = ZoneId.of("UTC")
        val utcZoned = ZonedDateTime.of(utcDate, utcZone)

        // Преобразование даты и времени в часовой пояс +5
        val kazakhstanZone = ZoneId.of("Asia/Aqtobe")
        val kazakhstanZoned = utcZoned.withZoneSameInstant(kazakhstanZone)

        // Форматирование даты и времени в строку "HH:mm"
        val formatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())
        return kazakhstanZoned.format(formatter)
    }
}