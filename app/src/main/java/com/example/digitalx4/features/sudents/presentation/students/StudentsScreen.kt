package com.example.digitalx4.features.sudents.presentation.students

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.features.sudents.presentation.components.StudentInfoRow
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar
import com.example.digitalx4.ui.navigation.ServiceReportScreens
import com.example.digitalx4.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentsScreen(
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
            ServiceReportFAB(
                icon = Icons.Default.Add,
                onClicked = {
                    navController.navigate(ServiceReportScreens.AddEditStudentScreen.name)

                }
            )
        }
            ){ contentPadding->

               Column(
                   modifier = Modifier.padding(contentPadding)
               ) {

                   StudentsDisplay(navController = navController)


               }


    }

    }



@Composable
fun StudentsDisplay(
    modifier: Modifier =Modifier
        .height(150.dp),
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    navController: NavController
) {

    val reportColors = listOf(
        RedOrange,
        LightGreen,
        Violet,
        BabyBlue,
        RedPink

    )

    val randomColor = reportColors.random()
    Box(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                       navController.navigate(ServiceReportScreens.StudentDetailsScreen.name)
            },

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
                    color = Color(randomColor.value),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )

                drawRoundRect(
                    color = Color(
                        ColorUtils.blendARGB(randomColor.toArgb(), 0x000000, 0.2f)
                    ),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), 0f),
                    size = Size(cutCornerSize.toPx(), cutCornerSize.toPx()),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }



            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .size(100.dp),
                    shape = RoundedCornerShape(50),
                    color = MaterialTheme.colorScheme.surface

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.student_photo_placeholder),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Column() {
                    Text(
                        text = "Jephthah Mbah",
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
                            text = "07065406165",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,

                            )

                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Click for Details",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black,
                    )
                }
            }







    }

}