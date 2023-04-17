package com.example.digitalx4.features.schedule.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.schedule.presentation.components.CalendarInput
import com.example.digitalx4.features.schedule.presentation.components.Calendar
import com.example.digitalx4.ui.components.BottomNavType
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import java.time.LocalDate


@Composable
fun ScheduleScreen(
    navController: NavController,
    homeScreenState: MutableState<BottomNavType>
) {
    val openDialog = remember { mutableStateOf(false) }


    val calendarInputList   by remember {
        mutableStateOf(createCalendarList())
    }

    var clickedCalendarElem by remember {
        mutableStateOf<CalendarInput?>(null)
    }
    val months = listOf(
        "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"
    )

    val currentMonth = LocalDate.now().monthValue
    val currentMonthName = months[currentMonth - 1]


    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.schedule_screen_title,
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
        floatingActionButton = {
            ServiceReportFAB(
                icon = Icons.Default.Add,
                onClicked = {
                    openDialog.value = true

                }
            )
        }
    ){ contentPadding->
        Box(
            modifier = Modifier
                .padding(vertical = contentPadding.calculateTopPadding(), horizontal = 16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            Calendar(
                calendarInput = calendarInputList,
                onDayClick = { day->
                    clickedCalendarElem = calendarInputList.first{
                        it.day == day
                }
                },
                month = currentMonthName,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.3f)

            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .align(Alignment.Center),

            ) {
                clickedCalendarElem?.toDos?.forEach {
                    Text(
                       text =  if(it.contains("Day")) it else "- $it",
                        color = MaterialTheme.colorScheme.primary,
//                        fontWeight = MaterialTheme.typography.bodyLarge,
//                        fontSize = if(it.contains("Day")) 25.sp else 18.sp

                    )
                }
            }
            EnterScheduleDialog(openDialog = openDialog)

        }

    }
}




private fun createCalendarList(): List<CalendarInput> {
    val calendarInputs = mutableListOf<CalendarInput>()

    for (i in 1..31) {
        calendarInputs.add(
            CalendarInput(
                i,
                toDos = listOf(
                    "Day $i:",
                    "2 p.m. Buying groceries",
                    "4 p.m. Meeting with Larissa"
                )
            )
        )
    }
    return calendarInputs
}









