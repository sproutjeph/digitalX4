package com.example.digitalx4.features.service_report.domain.use_case

import com.example.digitalx4.features.service_report.data.repository.ServiceReportRepository
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.util.OrderType
import com.example.digitalx4.features.service_report.domain.util.ReportOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllServiceReports(
    private val serviceReportRepository: ServiceReportRepository
) {
   operator fun invoke(reportOrder: ReportOrder = ReportOrder.Date(OrderType.Descending)): Flow<List<ServiceReport>>{
        return serviceReportRepository.getAllServiceReports().map{ report->
            when(reportOrder.orderType){
                is OrderType.Ascending -> report.sortedBy { it.entryDate }
                is OrderType.Descending -> report.sortedByDescending { it.entryDate
                }

            }

        }
    }
}

