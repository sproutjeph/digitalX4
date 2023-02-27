package com.example.digitalx4.features.service_report.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
