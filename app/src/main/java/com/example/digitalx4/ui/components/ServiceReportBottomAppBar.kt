package com.example.digitalx4.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.digitalx4.ui.navigation.Screen

@Composable
fun ServiceReportBottomAppBar(
    navController: NavController
){
    val navItems = listOf("Home","Students", "Reports", "Interests","Schedule")


    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier
    ) {

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,

            ) {
            navItems.forEach {navItem->
            NavigationBarItem(selected = false,
                onClick = {
                          navController.navigate(route = when(navItem){
                              "Home" -> Screen.Home.route
                              "Reports" -> Screen.Reports.route
                              "Students" -> Screen.Students.route
                              "Interests" -> Screen.InterestedPersons.route
                              "Schedule" -> Screen.Schedule.route
                              else -> Screen.Home.route
                          })


                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurface

                    ),
                icon = {
                    when(navItem) {
                        "Home"->Icon(imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier)
                        "Students" ->Icon(imageVector = Icons.Default.AccountBox,
                            contentDescription = null,
                            modifier = Modifier)
                        "Reports" -> Icon(imageVector = Icons.Default.MailOutline,
                            contentDescription = null,
                            modifier = Modifier)
                        "Interests" -> Icon(imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier)
                        "Schedule" -> Icon(imageVector = Icons.Filled.List,
                            contentDescription = null,
                            modifier = Modifier)
                    }
                },
                modifier = Modifier,
                label = { Text(text =navItem)}
            )



            }

        }

    }
}