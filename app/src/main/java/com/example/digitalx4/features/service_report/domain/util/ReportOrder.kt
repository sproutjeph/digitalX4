package com.example.digitalx4.features.service_report.domain.util

sealed class ReportOrder(val orderType: OrderType){
    class Date(orderType: OrderType) : ReportOrder(orderType)

    fun copy(orderType: OrderType):ReportOrder{
        return Date(orderType)
    }

}
