package com.example.digitalx4.features.sudents.presentation.add_edit_students


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.add_edit_report.ServiceReportInputTextFieldState
import com.example.digitalx4.features.service_report.presentation.add_edit_report.components.ServiceReportInputField
import com.example.digitalx4.features.sudents.presentation.components.StudentInputState
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar

//@Preview()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditStudentScreen(
    navController: NavController  = rememberNavController(),
    studentInputState: StudentInputState? = null
) {
    var nameState = remember {
        mutableStateOf("")
    }

    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.add_student,
                navController = navController,
                isMainScreen = false
            )
        },
        bottomBar = {
            ServiceReportBottomAppBar(navController = navController)
        },
        floatingActionButton = {
            ServiceReportFAB(icon = Icons.Default.Done)
        }

        ){ contentPadding->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.students_name,
                    value = nameState.value,
                    onValueChange = { nameState.value = it


                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.address,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.phone_number,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.students_email,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text,


                    )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.students_book,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.lesson,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.time_of_visit,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.question,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.notes,
                    value = "",
                    onValueChange = {},
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )
            }



        }





    }
    
}





