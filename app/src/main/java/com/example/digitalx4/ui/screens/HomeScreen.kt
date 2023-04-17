package com.example.digitalx4.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.MutableState
import com.example.digitalx4.features.service_report.presentation.service_reports.component.ServiceReportPreviewItem
import com.example.digitalx4.features.service_timer.presentation.ServiceTimerViewModel
import com.example.digitalx4.ui.components.BottomNavType
import com.example.digitalx4.ui.navigation.Screen
const val twitterUrl = "https://www.twitter.com/JephthahMbah"
const val linkedInUrl = "https://www.linkedin.com/in/jephthah-mbah-jw-71244263/"

fun launchSocialActivity(context: Context, socialType: String) {
    val intent = when (socialType) {
        "linkedin" -> Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
        else -> Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl))
    }
    context.startActivity(intent)
}

@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>,
    serviceReportViewModel: ServiceReportViewModel = hiltViewModel(),
    serviceTimerViewModel: ServiceTimerViewModel = hiltViewModel(),
    drawerState: DrawerState,
    onMenuClicked: () -> Unit = {},
    navigateToAddEditReportScreen: () -> Unit,
    ){
    val serviceReports = serviceReportViewModel.serviceReports.collectAsState().value

    HomeNavigationDrawer(
        drawerState = drawerState,
        navigateToAddEditReportScreen = navigateToAddEditReportScreen
    ) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                ServiceReportTopAppBar(
                    title = R.string.home,
                    isMainScreen = true,
                    navController = navController,
                    onMenuClicked = onMenuClicked
                )
            },
            bottomBar = { ServiceReportBottomAppBar(
                navController = navController,
                homeScreenState = homeScreenState
            ) },
            floatingActionButton = {
                ServiceReportFAB(
                    onClicked = { navigateToAddEditReportScreen.invoke() }
                )
            }

        ) {
                contentPadding -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(contentPadding)
        ) {

            ServiceTimer(
                isTimerRunning = serviceTimerViewModel.isTimerRunning,
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
                        navController.navigate(Screen.Reports.route)
                    }
                }
            }


        }
        }
    }



}









