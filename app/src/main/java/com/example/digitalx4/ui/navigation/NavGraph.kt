package com.example.digitalx4.ui.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.digitalx4.ui.components.BottomNavType
import com.example.digitalx4.ui.screens.HomeScreen
import kotlinx.coroutines.launch

@Composable
fun SetupNavigation(
    startDestination: String,
    navController: NavHostController,
    widthSizeClass: WindowWidthSizeClass,
    ){
    val studentViewModel:StudentViewModel = hiltViewModel()
    val homeScreenState = rememberSaveable { mutableStateOf(BottomNavType.Home) }



    NavHost(
        startDestination = startDestination,
        navController = navController,
    ){
        homeRoute(
            navController = navController,
            homeScreenState = homeScreenState,
            navigateToAddEditReportScreen = {
                navController.navigate(Screen.AddEditReport.route)
            },

        )


        studentsRoute(
            homeScreenState = homeScreenState,
            navController = navController
        )

        scheduleRoute(
            homeScreenState = homeScreenState,
            navController = navController
        )

        interestedPersonRoute(
            homeScreenState = homeScreenState,
            navController = navController
        )

        serviceReportItemRoute(
            navController = navController,
            homeScreenState = homeScreenState,
            navigateToAddEditReportScreenWithArgs = {
                navController.navigate(Screen.AddEditReport.passReportId(reportId = it))
            }
        )

        addEditServiceReportRoute(
            homeScreenState = homeScreenState,
            navController = navController,
        )

        addEditStudentRoute(
            homeScreenState = homeScreenState,
            navController = navController,
            studentViewModel = studentViewModel
        )

        studentDetailsRoute(
            homeScreenState = homeScreenState,
            navController = navController,
            studentViewModel = studentViewModel
        )
    }

}




fun NavGraphBuilder.homeRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>,
    navigateToAddEditReportScreen: () -> Unit
    ){

    composable(route = Screen.Home.route){
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        HomeScreen(
            navController = navController,
            homeScreenState = homeScreenState,
            drawerState = drawerState,
            onMenuClicked = {
                scope.launch { drawerState.open() }
            },
            navigateToAddEditReportScreen = navigateToAddEditReportScreen,
        )

    }
}


fun NavGraphBuilder.studentsRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>
){

    composable(route = Screen.Students.route){
        StudentsScreen(
            navController = navController,
            homeScreenState = homeScreenState
        )

    }
}


fun NavGraphBuilder.scheduleRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>
){

    composable(route = Screen.Schedule.route){
        ScheduleScreen(
            navController = navController,
            homeScreenState = homeScreenState
        )


    }
}


fun NavGraphBuilder.interestedPersonRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>
){

    composable(route = Screen.InterestedPersons.route){
        InterestedOnesScreen(
            navController = navController,
            homeScreenState = homeScreenState
        )
    }
}

fun NavGraphBuilder.serviceReportItemRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>,
    navigateToAddEditReportScreenWithArgs: (String) -> Unit,

    ) {

    composable(route = Screen.Reports.route) {
        ServiceReportItemScreen(
            navController = navController,
            homeScreenState = homeScreenState,
            navigateToAddEditReportScreenWithArgs = navigateToAddEditReportScreenWithArgs
        )

    }

}

fun NavGraphBuilder.addEditServiceReportRoute(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>,

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
                id = reportToEdit.id,
                homeScreenState = homeScreenState
            )

        } else {
            AddEditServiceReportScreen(
                homeScreenState = homeScreenState,
                navController = navController,
            )
        }


    }

}
fun NavGraphBuilder.addEditStudentRoute(
    navController: NavController,
    studentViewModel: StudentViewModel,
    homeScreenState: MutableState<BottomNavType>

) {

    composable(
        route = Screen.AddEditStudent.route,
        arguments = listOf(navArgument(name = "studentId"){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) { it ->
        val studentId = it.arguments?.getString("studentId")
        val students = studentViewModel.students.collectAsState().value
        val studentToEdit = students.find { it.id.toString() == studentId }

        if(studentToEdit?.id != null){

            AddEditStudentScreen(
                navController = navController,
                homeScreenState = homeScreenState,
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

            AddEditStudentScreen(
                homeScreenState = homeScreenState,
                navController = navController
            )
        }


    }

}

fun NavGraphBuilder.studentDetailsRoute(
    navController: NavController,
    studentViewModel: StudentViewModel,
    homeScreenState: MutableState<BottomNavType>

) {

    composable(
        route = Screen.StudentDetails.route,
        arguments = listOf(navArgument(name = "studentId"){
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) { it ->
        val studentId = it.arguments?.getString("studentId") ?: "student"
        val students = studentViewModel.students.collectAsState().value
        val studentDetails = students.find { it.id.toString() == studentId }
        StudentDetailsScreen(
            navController = navController,
            homeScreenState = homeScreenState,
            studentDetails = studentDetails
        )


    }

}



