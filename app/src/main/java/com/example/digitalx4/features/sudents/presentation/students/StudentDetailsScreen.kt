package com.example.digitalx4.features.sudents.presentation.students

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import com.example.digitalx4.features.sudents.presentation.components.StudentInfoRow
import com.example.digitalx4.ui.components.AppNavigationType
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.Screen


@Composable
fun StudentDetailsScreen(
    navController: NavController,
    homeScreenState: MutableState<AppNavigationType>,
    studentDetails: StudentModel?,
) {


    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.student_screen_title,
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
            ServiceReportFAB(icon = Icons.Default.Edit){
                navController.navigate(Screen.AddEditStudent.passStudentId(studentId = studentDetails?.id.toString()))
            }
        },

    ){ contentPadding->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Surface(
                    modifier = Modifier
                        .size(100.dp),
                    shape = RoundedCornerShape(50)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.student_photo_placeholder),
                        contentDescription = "Image place holder",
                        contentScale = ContentScale.Crop
                    )
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    if(studentDetails != null){
                        item {
                            StudentInfoRow(label = "Name : ", text = studentDetails.studentName)
                            StudentInfoRow(label = "Address : ", text = studentDetails.address)
                            StudentInfoRow(label = "Phone Number : ", text = studentDetails.phoneNumber)
                            StudentInfoRow(label = "Email : ", text = studentDetails.email)
                            StudentInfoRow(label = "Book Studying : ", text = studentDetails.bookStudying)
                            StudentInfoRow(label = "Lesson Under Consideration : ", text = studentDetails.lessonUnderConsideration)
                            StudentInfoRow(label = "Time Of Visit : ", text = studentDetails.timeOfVisit)
                            StudentInfoRow(label = "Question To Consider : ", text = studentDetails.questionToConsider)


                        }
                    }

                }
            }

    }

}


