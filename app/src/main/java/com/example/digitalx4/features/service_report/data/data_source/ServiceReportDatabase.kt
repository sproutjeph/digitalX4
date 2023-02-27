package com.example.digitalx4.features.service_report.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.util.DateConverter
import com.example.digitalx4.features.service_report.domain.util.UUIDConverter

@Database(entities = [ServiceReport::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
 abstract class ServiceReportDatabase: RoomDatabase() {
    abstract val serviceReportDao: ServiceReportDao
    companion object{
        const val DATABASE_NAME = "service_report_db"
    }
}