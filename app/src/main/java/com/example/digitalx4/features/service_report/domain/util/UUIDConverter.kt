package com.example.digitalx4.features.service_report.domain.util

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID):String?{
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?): UUID?{
        return UUID.fromString(string)
    }
}