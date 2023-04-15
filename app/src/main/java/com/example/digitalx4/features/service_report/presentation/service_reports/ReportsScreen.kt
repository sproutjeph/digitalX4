package com.example.digitalx4.features.service_report.presentation.service_reports

import androidx.compose.foundation.layout.Column
import com.example.digitalx4.features.service_report.presentation.service_reports.component.ServiceReportItem
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.service_reports.component.OrderBySection
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun ServiceReportItemScreen(
    navController: NavController,
    serviceReportViewModel: ServiceReportViewModel = hiltViewModel(),
    navigateToAddEditReportScreenWithArgs: (String) -> Unit,

    ){

    val serviceReports = serviceReportViewModel.serviceReports.collectAsState().value

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }



    Scaffold(
        modifier = Modifier,
        topBar = {
            ServiceReportTopAppBar(
                title = R.string.all_reports,
                navController = navController,
                isMainScreen = false
            )
        },
        bottomBar = {
            ServiceReportBottomAppBar(navController= navController)
        },
      snackbarHost = {SnackbarHost(hostState = snackbarHostState)},
        floatingActionButton = {
            ServiceReportFAB{
                navController.navigate(Screen.AddEditReport.route)
            }
        }

    ) {
            contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            OrderBySection()

            LazyColumn(
                modifier = Modifier
            ) {


                if (serviceReports.isEmpty()){
                    item {
                        EmptyListUi()
                    }
                }else{
                    items( serviceReports){ serviceReport ->
                        ServiceReportItem(
                            serviceReport = serviceReport,
                            navigateToAddEditReportScreenWithArgs = {navigateToAddEditReportScreenWithArgs.invoke(serviceReport.id.toString())}
                        ) {
                            scope.launch {
                                val result =  snackbarHostState.showSnackbar(
                                    message = "Delete This Report?",
                                    actionLabel = "Yes",
                                    withDismissAction = true
                                )

                                if(result == SnackbarResult.ActionPerformed){
                                    serviceReportViewModel.onEvent(
                                        ServiceReportsEvents.DeleteServiceReport(serviceReport)
                                    )
                                }
                            }


                        }
                    }
                }

            }

        }

        }


    }




@Composable
fun EmptyListUi(){
    Column(
        modifier = Modifier.padding(16.dp),
    ) {

        Text(text = "You have no reports yet")

    }
}