package com.example.digitalx4.features.service_report.presentation.service_reports

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.domain.use_case.ServiceReportUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ServiceReportViewModel @Inject constructor(
    private val serviceReportUseCases: ServiceReportUseCases,
) : ViewModel(){
    private val _serviceReports = MutableStateFlow<List<ServiceReport>>(emptyList())

    val serviceReports = _serviceReports.asStateFlow()



    init {
        viewModelScope.launch (Dispatchers.IO){
            serviceReportUseCases.getAllServiceReports().distinctUntilChanged()
                .collect{
                    listOfServiceReports ->
                    if(listOfServiceReports.isEmpty()){
                        Log.d("Empty", "Empty List ")
                    }else{
                        _serviceReports.value = listOfServiceReports
                    }
                }


        }

           serviceReportUseCases.getAllServiceReports().distinctUntilChanged()




    }

    fun onEvent(event: ServiceReportsEvents){
        when(event){
            is ServiceReportsEvents.DeleteServiceReport -> {
                viewModelScope.launch {

                    serviceReportUseCases.deleteServiceReport(event.serviceReport)
                }
            }

            is ServiceReportsEvents.GetServiceReportById -> {
                viewModelScope.launch {
                    serviceReportUseCases.getServiceReport(event.id)
                }
            }
        }
    }

//    fun deleteServiceReport(serviceReport: ServiceReport) =
//        viewModelScope.launch { serviceReportUseCases.deleteServiceReport(serviceReport) }


}
