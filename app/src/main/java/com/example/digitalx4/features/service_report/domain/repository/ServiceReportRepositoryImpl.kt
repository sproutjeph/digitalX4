package com.example.digitalx4.features.service_report.domain.repository

import com.example.digitalx4.features.service_report.data.data_source.ServiceReportDao
import com.example.digitalx4.features.service_report.data.repository.ServiceReportRepository
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import kotlinx.coroutines.flow.Flow

class ServiceReportRepositoryImpl(
    private val serviceReportDao: ServiceReportDao

):ServiceReportRepository {
    override fun getAllServiceReports(): Flow<List<ServiceReport>> {
        return serviceReportDao.getAllServiceReports()
    }

    override suspend fun addServiceReport(serviceReport: ServiceReport) {
      return  serviceReportDao.addServiceReport(serviceReport)
    }

    override suspend fun deleteAllServiceReports() {
       return serviceReportDao.deleteAllServiceReports()
    }

    override suspend fun deleteServiceReport(serviceReport: ServiceReport) {
       return serviceReportDao.deleteServiceReport(serviceReport)
    }

    override suspend fun getServiceReportById(serviceReportId: String): ServiceReport? {
        return serviceReportDao.getServiceReportById(serviceReportId)
    }

    override suspend fun updateServiceReport(serviceReport: ServiceReport) {
        return serviceReportDao.updateServiceReportData(serviceReport)
    }
}