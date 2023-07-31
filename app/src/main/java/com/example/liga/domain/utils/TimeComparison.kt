package com.example.liga.domain.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class TimeComparison {
    fun dateComparisonNeedUpd(comparison: String?): Boolean {
        val date = Date()
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(date)
        return today != comparison
    }
}