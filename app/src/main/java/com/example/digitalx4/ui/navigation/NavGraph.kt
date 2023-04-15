package com.example.digitalx4.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.digitalx4.features.schedule.presentation.ScheduleScreen
import com.example.digitalx4.features.service_report.presentation.add_edit_report.AddEditServiceReportScreen
import com.example.digitalx4.features.service_report.presentation.add_edit_report.ServiceReportInputTextFieldState
import com.example.digitalx4.features.service_report.presentation.service_reports.ServiceReportItemScreen
import com.example.digitalx4.features.service_report.presentation.service_reports.ServiceReportViewModel
import com.example.digitalx4.features.sudents.presentation.add_edit_students.AddEditStudentScreen
import com.example.digitalx4.features.sudents.presentation.components.StudentInputState
import com.example.digitalx4.features.sudents.presentation.intrested_ones.InterestedOnesScreen
import com.example.digitalx4.features.sudents.presentation.students.StudentDetailsScreen
import com.example.digitalx4.features.sudents.presentation.students.StudentViewModel
import com.example.digitalx4.features.sudents.presentation.students.StudentsScreen
import com.example.digitalx4.ui.screens.HomeScreen

@Composable
fun SetupNavigation(
    startDestination: String,
    navController: NavHostController,
    widthSizeClass: WindowWidthSizeClass,
    ){
    val studentViewModel:StudentViewModel = hiltViewModel()


    NavHost(
        startDestination = startDestination,
        navController = navController,
    ){
        homeRoute(
            navController = navController,
            navigateToAddEditReportScreen = {
                navController.navigate(Screen.AddEditReport.route)
            },

        )


        studentsRoute(
            navController = navController
        )

        scheduleRoute(
            navController = navController
        )

        interestedPersonRoute(
            navController = navController
        )

        serviceReportItemRoute(
            navController = navController,
            navigateToAddEditReportScreenWithArgs = {
                navController.navigate(Screen.AddEditReport.passReportId(reportId = it))
            }
        )

        addEditServiceReportRoute(
            navController = navController,
        )

        addEditStudentRoute(
            navController = navController,
            studentViewModel = studentViewModel
        )

        studentDetailsRoute(
            navController = navController,
            studentViewModel = studentViewModel
        )
    }

}




fun NavGraphBuilder.homeRoute(
    navController: NavController,
    navigateToAddEditReportScreen: () -> Unit,
    ){

    composable(route = Screen.Home.route){
        HomeScreen(
            navController = navController,
            navigateToAddEditReportScreen = navigateToAddEditReportScreen,
        )

    }
}


fun NavGraphBuilder.studentsRoute(
    navController: NavController
){

    composable(route = Screen.Students.route){
        StudentsScreen(navController = navController )

    }
}


fun NavGraphBuilder.scheduleRoute(
    navController: NavController
){

    composable(route = Screen.Schedule.route){
        ScheduleScreen(navController = navController)


    }
}


fun NavGraphBuilder.interestedPersonRoute(
    navController: NavController
){

    composable(route = Screen.InterestedPersons.route){
        InterestedOnesScreen(navController = navController)
    }
}

fun NavGraphBuilder.serviceReportItemRoute(
    navController: NavController,
    navigateToAddEditReportScreenWithArgs: (String) -> Unit,

    ) {

    composable(route = Screen.Reports.route) {
        ServiceReportItemScreen(
            navController = navController,
            navigateToAddEditReportScreenWithArgs = navigateToAddEditReportScreenWithArgs
        )

    }

}

fun NavGraphBuilder.addEditServiceReportRoute(
    navController: NavController,

    ) {

    composable(
        route = Screen.AddEditReport.route,
        arguments = listOf(navArgument(name = "reportId"){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) { selectedServiceReportId ->
        val  serviceReportViewModel: ServiceReportViewModel = hiltViewModel()
        val reportId = selectedServiceReportId.arguments?.getString("reportId")
        val serviceReports = serviceReportViewModel.serviceReports.collectAsState().value
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

}
fun NavGraphBuilder.addEditStudentRoute(
    navController: NavController,
    studentViewModel:StudentViewModel

    ) {

    composable(
        route = Screen.AddEditStudent.route,
        arguments = listOf(navArgument(name = "studentId"){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val studentId = it.arguments?.getString("studentId")
        val students = studentViewModel.students.collectAsState().value
        val studentToEdit = students.find { it.id.toString() == studentId }

        if(studentToEdit?.id != null){

            AddEditStudentScreen(
                navController = navController,
                studentInputState = StudentInputState(
                    id = studentToEdit.id,
                    name = remember { mutableStateOf(studentToEdit.studentName) },
                    address = remember { mutableStateOf(studentToEdit.address) },
                    phoneNumber = remember { mutableStateOf(studentToEdit.phoneNumber) },
                    email = remember { mutableStateOf(studentToEdit.email) },
                    bookStudying = remember { mutableStateOf(studentToEdit.bookStudying) },
                    lesson = remember { mutableStateOf(studentToEdit.lessonUnderConsideration) },
                    timeOfVisit = remember { mutableStateOf(studentToEdit.timeOfVisit) },
                    questionToConsider = remember { mutableStateOf(studentToEdit.questionToConsider) },
                    note = remember { mutableStateOf(studentToEdit.noteAboutStudent) },

                    ),
                id = studentToEdit.id
            )
        }else{

            AddEditStudentScreen(navController = navController)
        }


    }

}

fun NavGraphBuilder.studentDetailsRoute(
    navController: NavController,
    studentViewModel:StudentViewModel

    ) {

    composable(
        route = Screen.StudentDetails.route,
        arguments = listOf(navArgument(name = "studentId"){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val studentId = it.arguments?.getString("studentId") ?: "student"
        val students = studentViewModel.students.collectAsState().value
        val studentDetails = students.find { it.id.toString() == studentId }
        StudentDetailsScreen(
            navController = navController,
            studentDetails = studentDetails
        )


    }

}



