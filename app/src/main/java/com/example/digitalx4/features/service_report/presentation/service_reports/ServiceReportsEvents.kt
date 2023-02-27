package com.example.digitalx4.features.service_report.presentation.service_reports

import com.example.digitalx4.features.service_report.domain.model.ServiceReport

sealed interface ServiceReportsEvents{
    data class DeleteServiceReport(val serviceReport: ServiceReport): ServiceReportsEvents
    data class GetServiceReportById(val id: String): ServiceReportsEvents

}