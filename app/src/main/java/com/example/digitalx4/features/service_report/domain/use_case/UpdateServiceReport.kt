package com.example.digitalx4.features.service_report.domain.use_case

import com.example.digitalx4.features.service_report.data.repository.ServiceReportRepository
import com.example.digitalx4.features.service_report.domain.model.ServiceReport





class UpdateServiceReport(
private val serviceReportRepository: ServiceReportRepository
) {
    suspend operator fun invoke(serviceReport: ServiceReport) {
        serviceReportRepository.updateServiceReport(serviceReport)
    }
}