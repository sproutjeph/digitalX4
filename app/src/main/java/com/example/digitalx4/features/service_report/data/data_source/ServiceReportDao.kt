package com.example.digitalx4.features.service_report.data.data_source

import androidx.room.*
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import kotlinx.coroutines.flow.Flow


@Dao
interface ServiceReportDao {
    @Query("SELECT * from report_tbl")
    fun getAllServiceReports(): Flow<List<ServiceReport>>

    @Query("SELECT * from report_tbl where id =:id")
    suspend fun getServiceReportById(id:String): ServiceReport

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addServiceReport(report: ServiceReport)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateServiceReportData(report: ServiceReport)

    @Query("DELETE from report_tbl")
    suspend  fun deleteAllServiceReports()

    @Delete
    suspend fun deleteServiceReport(report: ServiceReport)

    @Query("SELECT * FROM report_tbl ORDER BY month ASC")
    fun getServiceReportsOrderedByMonth(): Flow<List<ServiceReport>>

    @Query("SELECT * FROM report_tbl ORDER BY report_entry_date ASC")
    fun getServiceReportsOrderedByEntryDate(): Flow<List<ServiceReport>>
}