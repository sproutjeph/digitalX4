package com.example.digitalx4.features.service_report.presentation.add_edit_report

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.use_case.ServiceReportUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditServiceReportViewModel @Inject constructor(
    private val serviceReportUseCases: ServiceReportUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    fun addServiceReport(serviceReport: ServiceReport) =
        viewModelScope.launch {
            serviceReportUseCases.addServiceReport(serviceReport)
        }

    fun updateServiceReport(serviceReport: ServiceReport) = viewModelScope.launch {
        serviceReportUseCases.upDateServiceReport(serviceReport)
    }

}