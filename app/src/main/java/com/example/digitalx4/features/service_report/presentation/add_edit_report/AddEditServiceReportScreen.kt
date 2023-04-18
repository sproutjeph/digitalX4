package com.example.digitalx4.features.service_report.presentation.add_edit_report

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.presentation.add_edit_report.components.EnterEditReport
import com.example.digitalx4.ui.components.AppNavigationType
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.Screen
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun AddEditServiceReportScreen(
    navController: NavController,
    homeScreenState: MutableState<AppNavigationType>,
    viewModel: AddEditServiceReportViewModel = hiltViewModel(),
    serviceReportInputTextFieldStateState: ServiceReportInputTextFieldState =
        ServiceReportInputTextFieldState(
            name = remember { mutableStateOf("") },
            month = remember { mutableStateOf("") },
            placement = remember { mutableStateOf("") },
            videoShowing = remember { mutableStateOf("") },
            hours = remember { mutableStateOf("") },
            returnVisits = remember { mutableStateOf("") },
            bibleStudies = remember { mutableStateOf("") },
            comments = remember { mutableStateOf("") },
        ),
    id: UUID? = null,
) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val showSnackbar by viewModel.showSnackbar.collectAsState()



    Scaffold(
        topBar = {
            ServiceReportTopAppBar(
                title = R.string.enter_report,
                isMainScreen = false,
                navController = navController,
                onMenuClicked = {}
            )
        },
        bottomBar = {
            ServiceReportBottomAppBar(
                navController = navController,
                homeScreenState = homeScreenState
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        floatingActionButton = {
            ServiceReportFAB(icon = Icons.Default.Done) {

                if (id != null && !showSnackbar) {
                    viewModel.updateServiceReport(
                        ServiceReport(
                            id = id,
                            name = serviceReportInputTextFieldStateState.name.value,
                            month = serviceReportInputTextFieldStateState.month.value,
                            placement = serviceReportInputTextFieldStateState.placement.value,
                            videoShowing = serviceReportInputTextFieldStateState.videoShowing.value,
                            hours = serviceReportInputTextFieldStateState.hours.value,
                            returnVisits = serviceReportInputTextFieldStateState.returnVisits.value,
                            bibleStudies = serviceReportInputTextFieldStateState.bibleStudies.value,
                            comments = serviceReportInputTextFieldStateState.comments.value,
                        )
                    )

                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Report Updated View Report?",
                            actionLabel = "Yes",
                            withDismissAction = true
                        )

                        if (result == SnackbarResult.ActionPerformed) navController.navigate(
                            Screen.Home.route
                        )

                    }


                } else if (showSnackbar) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Name and Month are required",
                            withDismissAction = true
                        )
                    }
                } else {
                    viewModel.addServiceReport(
                        ServiceReport(
                            name = serviceReportInputTextFieldStateState.name.value,
                            month = serviceReportInputTextFieldStateState.month.value,
                            placement = serviceReportInputTextFieldStateState.placement.value,
                            videoShowing = serviceReportInputTextFieldStateState.videoShowing.value,
                            hours = serviceReportInputTextFieldStateState.hours.value,
                            returnVisits = serviceReportInputTextFieldStateState.returnVisits.value,
                            bibleStudies = serviceReportInputTextFieldStateState.bibleStudies.value,
                            comments = serviceReportInputTextFieldStateState.comments.value,
                        )
                    )
                }



                serviceReportInputTextFieldStateState.name.value = ""
                serviceReportInputTextFieldStateState.month.value = ""
                serviceReportInputTextFieldStateState.placement.value = ""
                serviceReportInputTextFieldStateState.videoShowing.value = ""
                serviceReportInputTextFieldStateState.hours.value = ""
                serviceReportInputTextFieldStateState.returnVisits.value = ""
                serviceReportInputTextFieldStateState.bibleStudies.value = ""
                serviceReportInputTextFieldStateState.comments.value = ""


            }
        }
    ) { contentPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
        ) {
            EnterEditReport(
                serviceReportInputTextFieldStateState = serviceReportInputTextFieldStateState,
            )
        }

    }

}




