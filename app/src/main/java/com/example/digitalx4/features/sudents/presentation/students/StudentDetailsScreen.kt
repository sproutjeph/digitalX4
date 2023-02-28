package com.example.digitalx4.features.sudents.presentation.students

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.sudents.presentation.components.StudentInfoRow
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.ServiceReportScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {


    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.student_screen_title,
                navController = navController,
                isMainScreen = false
            )
        },
        bottomBar = {
            ServiceReportBottomAppBar(navController = navController)
        },
        floatingActionButton = {
            ServiceReportFAB(icon = Icons.Default.Edit){
                navController.navigate(ServiceReportScreens.AddEditStudentScreen.name)
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

                    item {
                        StudentInfoRow(label = "Name : ", text = "Jephthah Mbah")
                        StudentInfoRow(label = "Address : ", text = "No 1, Main Street, Lagos")
                        StudentInfoRow(label = "Phone Number : ", text = "07065406165")
                        StudentInfoRow(label = "Email : ", text = "jephthah.mbah@outlook.com")
                        StudentInfoRow(label = "Book Studying : ", text = "Enjoy Life Forever")
                        StudentInfoRow(label = "Lesson Under Consideration : ", text = "Lesson 6")
                        StudentInfoRow(label = "Time Of Visit : ", text = "Sundays By 3:00 PM")
                        StudentInfoRow(label = "Question To Consider : ", text = "Why Do we Suffer")


                    }
                }
            }

    }

}


