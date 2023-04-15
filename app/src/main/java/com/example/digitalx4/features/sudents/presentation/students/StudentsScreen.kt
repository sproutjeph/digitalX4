package com.example.digitalx4.features.sudents.presentation.students

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.Screen

@Composable
fun StudentsScreen(
    navController: NavController,
    studentViewModel: StudentViewModel = hiltViewModel()
) {
    val students = studentViewModel.students.collectAsState().value

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
            ServiceReportFAB{
                navController.navigate(Screen.AddEditStudent.route)

            }
        }
            ){ contentPadding->
                   LazyColumn(modifier = Modifier.padding(contentPadding)){
                       if(students.isEmpty()){
                           item {
                               Text(text = "No Student Added")
                           }
                       }else{
                           items(students){ student ->
                               StudentsDisplay(
                                   navController = navController,
                                   student = student,
                                   onDeleteClicked = {
                                       studentViewModel.deleteStudent(student)
                                   }
                               )
                           }
                       }
                   }
    }

    }



@Composable
fun StudentsDisplay(
    modifier: Modifier = Modifier
        .height(200.dp),
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    navController: NavController,
    student: StudentModel,
    onDeleteClicked:(student:StudentModel)-> Unit
) {



    val studentColor = student.studentColor
    Box(
        modifier = modifier
            .padding(16.dp)
        ){
        Canvas(modifier = Modifier.matchParentSize()  ){
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(clipPath){
                drawRoundRect(
                    color = Color(studentColor),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )

                drawRoundRect(
                    color = Color(
                        ColorUtils.blendARGB(studentColor, 0x000000, 0.2f)
                    ),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), 0f),
                    size = Size(cutCornerSize.toPx(), cutCornerSize.toPx()),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }

              Column(
                  horizontalAlignment = Alignment.CenterHorizontally
              ) {
                  Row(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(10.dp),
//                      horizontalArrangement = Arrangement.SpaceEvenly,
//                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      Surface(
                          modifier = Modifier
                              .size(80.dp),
                          shape = RoundedCornerShape(50),
                          color = MaterialTheme.colorScheme.surface

                      ) {
                          Image(
                              painter = painterResource(id = R.drawable.student_photo_placeholder),
                              contentDescription = null,
                              contentScale = ContentScale.Crop
                          )
                      }
                      
                      Spacer(modifier = Modifier.width(30.dp))

                      Column {
                          Text(
                              text = student.studentName,
                              style = MaterialTheme.typography.titleMedium,
                              color = Color.Black,
                              maxLines = 1,
                              overflow = TextOverflow.Ellipsis

                          )
                          Spacer(modifier = Modifier.height(8.dp))


                          Row {
                              Text(
                                  text = "Phone:",
                                  style = MaterialTheme.typography.titleMedium,
                                  color = Color.Black,
                              )
                              Spacer(modifier = Modifier.width(8.dp))
                              Text(
                                  text = student.phoneNumber,
                                  style = MaterialTheme.typography.titleMedium,
                                  color = Color.Black,

                                  )

                          }


                      }
                  }
                  Divider(modifier=Modifier.padding(top = 10.dp, bottom = 6.dp))
                  Row(
                      modifier=Modifier,
                      
                  ) {
                      Button(
                          onClick = {
                                    onDeleteClicked.invoke(student)
                          },
                          colors = ButtonDefaults.buttonColors(containerColor = Color.Red.copy(0.2f))
                      ) {
                          Text(text = "Delete")
                      }
                      
                      Spacer(modifier = Modifier.width(50.dp))

                      Button(
                          onClick = {
                              navController.navigate(Screen.StudentDetails.passStudentId(studentId = student.id.toString()))

                          },
                          colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                      ) {
                          Text(text = "Details")
                      }

                  }

              }




    }


}