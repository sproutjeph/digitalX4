package com.example.digitalx4.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.service_reports.ServiceReportViewModel
import com.example.digitalx4.features.service_timer.presentation.ServiceTimer
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.ServiceReportScreens
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.rememberCoroutineScope
import com.example.digitalx4.features.service_report.presentation.service_reports.component.ServiceReportPreviewItem
import com.example.digitalx4.features.service_timer.presentation.ServiceTimerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    serviceReportViewModel: ServiceReportViewModel = hiltViewModel(),
    serviceTimerViewModel: ServiceTimerViewModel = hiltViewModel(),


    ){
    val serviceReports = serviceReportViewModel.serviceReports.collectAsState().value
    val scope = rememberCoroutineScope()


    Scaffold(
        modifier = Modifier,
        topBar = {
            ServiceReportTopAppBar(
                title = R.string.home,
                navController = navController,
                isMainScreen = true,
            )
        },
        bottomBar = { ServiceReportBottomAppBar(navController = navController) },
        floatingActionButton = {
            ServiceReportFAB(){
                navController.navigate(ServiceReportScreens.AddEditReportScreen.name+"?reportId=")
            }
        }

    ) {
         contentPadding -> Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(contentPadding)
         ) {

            ServiceTimer(
                isTimerRuning = serviceTimerViewModel.isTimerRunning,
                seconds = serviceTimerViewModel.seconds,
                minutes = serviceTimerViewModel.minutes,
                hours = serviceTimerViewModel.hours,
                onStart = {serviceTimerViewModel.start()},
                onPause = {serviceTimerViewModel.pause()},
                onStop = {serviceTimerViewModel.stop()}

            )

        LazyColumn(modifier = Modifier){
            items(serviceReports){ serviceReport ->
                ServiceReportPreviewItem(serviceReport = serviceReport){
                    navController.navigate(ServiceReportScreens.ReportsScreen.name)
                }
            }
        }


    }
    }

}









