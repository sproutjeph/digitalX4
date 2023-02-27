package com.example.digitalx4.features.service_report.domain.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date):Long{

        return date.time
    }

    @TypeConverter
    fun dateFromTimestamp(timestamp:Long): Date?{

        return Date(timestamp)

    }
}