package com.example.digitalx4.features.service_report.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.util.DateConverter
import com.example.digitalx4.features.service_report.domain.util.UUIDConverter
import com.example.digitalx4.features.sudents.data.data_source.StudentDao
import com.example.digitalx4.features.sudents.domain.model.StudentModel

@Database(entities = [ServiceReport::class, StudentModel::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
 abstract class ServiceReportDatabase: RoomDatabase() {
    abstract val serviceReportDao: ServiceReportDao
    abstract val studentDao: StudentDao
    companion object{
        const val DATABASE_NAME = "service_report_db"
    }
}