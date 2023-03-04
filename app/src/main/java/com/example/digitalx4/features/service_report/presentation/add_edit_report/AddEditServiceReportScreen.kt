package com.example.digitalx4.features.service_report.presentation.add_edit_report

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.domain.model.InvalidReportException
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.features.service_report.presentation.add_edit_report.components.EnterEditReport
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.ServiceReportScreens
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditServiceReportScreen(
    navController: NavController,
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
    id: UUID? = null
) {


    Scaffold(
        topBar = {
            ServiceReportTopAppBar(
                title = R.string.enter_report,
                navController = navController,
                isMainScreen = false
            )
        },
        bottomBar = {
            ServiceReportBottomAppBar(navController = navController)
        },
        floatingActionButton = {
            ServiceReportFAB(icon = Icons.Default.Done) {
                if (id != null) {
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

                navController.navigate(ServiceReportScreens.HomeScreen.name)


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



