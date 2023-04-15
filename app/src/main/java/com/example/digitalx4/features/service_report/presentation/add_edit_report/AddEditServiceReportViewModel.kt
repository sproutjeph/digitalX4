package com.example.digitalx4.features.service_report.presentation.add_edit_report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalx4.features.service_report.domain.model.InvalidReportException
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.use_case.ServiceReportUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditServiceReportViewModel @Inject constructor(
    private val serviceReportUseCases: ServiceReportUseCases,
):ViewModel() {

    private val _showSnackbar = MutableStateFlow(false)
    val showSnackbar: StateFlow<Boolean> = _showSnackbar

    fun addServiceReport(serviceReport: ServiceReport) =
        viewModelScope.launch {
            try {
                serviceReportUseCases.addServiceReport(serviceReport)
            } catch (e: InvalidReportException) {
                _showSnackbar.value = true
            }
        }

    fun updateServiceReport(serviceReport: ServiceReport) = viewModelScope.launch {
        serviceReportUseCases.upDateServiceReport(serviceReport)
    }


}