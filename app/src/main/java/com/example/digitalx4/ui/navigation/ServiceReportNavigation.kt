package com.example.digitalx4.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.digitalx4.features.schedule.presentation.ScheduleScreen
import com.example.digitalx4.features.service_report.presentation.add_edit_report.AddEditServiceReportScreen
import com.example.digitalx4.features.service_report.presentation.add_edit_report.ServiceReportInputTextFieldState
import com.example.digitalx4.features.service_report.presentation.service_reports.ServiceReportItemScreen
import com.example.digitalx4.features.service_report.presentation.service_reports.ServiceReportViewModel
import com.example.digitalx4.features.sudents.presentation.add_edit_students.AddEditStudentScreen
import com.example.digitalx4.features.sudents.presentation.intrested_ones.InterestedOnesScreen
import com.example.digitalx4.features.sudents.presentation.students.StudentDetailsScreen
import com.example.digitalx4.features.sudents.presentation.students.StudentsScreen
import com.example.digitalx4.ui.screens.HomeScreen

@Composable
fun ServiceReportNavigation(
    viewModel: ServiceReportViewModel = hiltViewModel()

    ) {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ServiceReportScreens.HomeScreen.name
    ) {
        composable(ServiceReportScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(ServiceReportScreens.AddEditReportScreen.name + "?reportId={reportId}",
            arguments = listOf(
                navArgument(name = "reportId") {
                    type = NavType.StringType
                    defaultValue = "report"
                }
            )
        ) {
            val reportId = it.arguments?.getString("reportId") ?: "report"
            val serviceReports = viewModel.serviceReports.collectAsState().value
            val reportToEdit = serviceReports.find { it.id.toString() == reportId }


            if (reportToEdit?.id != null) {
                AddEditServiceReportScreen(
                    navController = navController,
                    serviceReportInputTextFieldStateState = ServiceReportInputTextFieldState(
                        id = reportToEdit.id,
                        name = remember { mutableStateOf(reportToEdit.name) },
                        month = remember { mutableStateOf(reportToEdit.month) },
                        placement = remember { mutableStateOf(reportToEdit.placement) },
                        videoShowing = remember { mutableStateOf(reportToEdit.videoShowing) },
                        hours = remember { mutableStateOf(reportToEdit.hours) },
                        returnVisits = remember { mutableStateOf(reportToEdit.returnVisits) },
                        bibleStudies = remember { mutableStateOf(reportToEdit.bibleStudies) },
                        comments = remember { mutableStateOf(reportToEdit.comments) },

                        ),
                    id = reportToEdit.id
                )

            } else {
                AddEditServiceReportScreen(
                    navController = navController,
                )
            }


        }

        composable(ServiceReportScreens.ReportsScreen.name) {
            ServiceReportItemScreen(navController = navController)
        }

        composable(ServiceReportScreens.StudentsScreen.name) {
            StudentsScreen(navController = navController)
        }
        composable(ServiceReportScreens.InterestedPersonsScreen.name) {
            InterestedOnesScreen(navController = navController)
        }
        composable(ServiceReportScreens.ScheduleScreen.name) {
            ScheduleScreen(navController = navController)
        }

        composable(ServiceReportScreens.StudentDetailsScreen.name) {
            StudentDetailsScreen(navController = navController)
        }

        composable(ServiceReportScreens.AddEditStudentScreen.name) {
            AddEditStudentScreen(navController = navController)

        }

    }

}

