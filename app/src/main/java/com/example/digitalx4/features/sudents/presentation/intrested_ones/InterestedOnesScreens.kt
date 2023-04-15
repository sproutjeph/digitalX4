package com.example.digitalx4.features.sudents.presentation.intrested_ones

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.digitalx4.R
import com.example.digitalx4.ui.components.ServiceReportBottomAppBar
import com.example.digitalx4.ui.components.ServiceReportFAB
import com.example.digitalx4.ui.components.ServiceReportTopAppBar

@Composable
fun InterestedOnesScreen(
    navController: NavController
) {

    Scaffold (
        topBar = {
            ServiceReportTopAppBar(
                title =  R.string.interested_screen_title,
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

                }
            )
        }
    ){ contentPadding->
        Box(modifier = Modifier.padding(contentPadding)){
            Text(text = "Interested Persons Screen")
        }

    }

}