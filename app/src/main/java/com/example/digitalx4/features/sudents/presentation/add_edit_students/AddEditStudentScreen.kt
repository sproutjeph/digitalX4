package com.example.digitalx4.features.sudents.presentation.add_edit_students


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.add_edit_report.components.ServiceReportInputField
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import com.example.digitalx4.features.sudents.presentation.components.StudentInputState
import com.example.digitalx4.features.sudents.presentation.students.StudentViewModel
import com.example.digitalx4.ui.components.BottomNavType
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.Screen
import java.util.*

//@Preview()
@Composable
fun AddEditStudentScreen(
    studentViewModel: StudentViewModel = hiltViewModel(),
    homeScreenState: MutableState<BottomNavType>,
    navController: NavController = rememberNavController(),
    studentInputState: StudentInputState = StudentInputState(
        name = remember { mutableStateOf("") },
        address = remember { mutableStateOf("") },
        phoneNumber = remember { mutableStateOf("") },
        email = remember { mutableStateOf("") },
        bookStudying = remember { mutableStateOf("") },
        lesson = remember { mutableStateOf("") },
        timeOfVisit = remember { mutableStateOf("") },
        questionToConsider = remember { mutableStateOf("") },
        note = remember { mutableStateOf("") },
    ),
    id: UUID? = null,
) {


    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.add_student,
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
            ServiceReportFAB(icon = Icons.Default.Done){
                if(id != null){
                    studentViewModel.updateStudent(
                        StudentModel(
                            id = id,
                            studentName = studentInputState.name.value,
                            address = studentInputState.address.value,
                            phoneNumber = studentInputState.phoneNumber.value,
                            email = studentInputState.email.value,
                            bookStudying = studentInputState.bookStudying.value,
                            lessonUnderConsideration = studentInputState.lesson.value,
                            timeOfVisit = studentInputState.timeOfVisit.value,
                            questionToConsider = studentInputState.questionToConsider.value,
                            noteAboutStudent = studentInputState.note.value
                        )
                    )
                }else{
                    studentViewModel.addStudent(
                        StudentModel(
                            studentName = studentInputState.name.value,
                            address = studentInputState.address.value,
                            phoneNumber = studentInputState.phoneNumber.value,
                            email = studentInputState.email.value,
                            bookStudying = studentInputState.bookStudying.value,
                            lessonUnderConsideration = studentInputState.lesson.value,
                            timeOfVisit = studentInputState.timeOfVisit.value,
                            questionToConsider = studentInputState.questionToConsider.value,
                            noteAboutStudent = studentInputState.note.value
                        )
                    )
                }

                studentInputState.name.value = ""
                studentInputState.address.value = ""
                studentInputState.phoneNumber.value = ""
                studentInputState.email.value = ""
                studentInputState.bookStudying.value = ""
                studentInputState.lesson.value = ""
                studentInputState.timeOfVisit.value = ""
                studentInputState.questionToConsider.value = ""
                studentInputState.note.value = ""

                navController.navigate(Screen.Students.route)

            }



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
                    value = studentInputState.name.value,
                    onValueChange = { if(it.all {
                                char -> char.isDefined() || char.isWhitespace()
                        }) studentInputState.name.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.address,
                    value = studentInputState.address.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.address.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Ascii

                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.phone_number,
                    value = studentInputState.phoneNumber.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.phoneNumber.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Phone


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.students_email,
                    value = studentInputState.email.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.email.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Email,


                    )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.students_book,
                    value = studentInputState.bookStudying.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.bookStudying.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.lesson,
                    value = studentInputState.lesson.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.lesson.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text


                )
                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.time_of_visit,
                    value = studentInputState.timeOfVisit.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.timeOfVisit.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.question,
                    value = studentInputState.questionToConsider.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.questionToConsider.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )

                ServiceReportInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    label = R.string.notes,
                    value = studentInputState.note.value,
                    onValueChange = {
                        if(it.all {
                                    char -> char.isDefined() || char.isWhitespace()
                            }) studentInputState.note.value = it

                    },
                    maxLine = 10,
                    keyboardType = KeyboardType.Text

                )

                // give space because of phone buttons
                Spacer(modifier = Modifier.height(250.dp))
            }



        }





    }
    
}






