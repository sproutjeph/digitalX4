package com.example.digitalx4.ui.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ServiceReportNavRail(
    navigationItemContentList: List<AppNavigationType>,
) {
    NavigationRail(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        for(navItem in navigationItemContentList){
            NavigationRailItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = when(navItem.name) {
                            "Home" -> Icons.Filled.Home
                            "Students" -> Icons.Default.AccountBox
                            "Reports" -> Icons.Default.Book
                            "Interests" -> Icons.Default.Person
                            "Schedule" -> Icons.Filled.Schedule
                            else -> Icons.Filled.Home
                        },


                        contentDescription = navItem.name
                    )
                },
                label = {
                    Text(text = navItem.name)
                }
            )
        }

    }
}