package com.example.studprjck

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.min

interface SecToHours {
    fun map(value: Long) : String
    class Base: SecToHours {
        override fun map(value: Long): String {
            val seconds = value / 1000

            val hours = seconds / 3600
            val minutes = (seconds - hours * 3600) / 60
            val second = (seconds - hours*3600 - minutes*60)
            return "$hours:$minutes:$second"
        }
    }
}