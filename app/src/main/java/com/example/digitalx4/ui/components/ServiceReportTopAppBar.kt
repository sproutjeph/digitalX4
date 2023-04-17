package com.example.digitalx4.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceReportTopAppBar(
    title: Int,
    isMainScreen: Boolean = true,
    navController: NavController,
    onMenuClicked: () -> Unit = {},
) {

    val showDropDownMenu = remember { mutableStateOf(false) }







    if (showDropDownMenu.value) {
        SettingsDropDownMenu(
            showDropDownMenu = showDropDownMenu,
        )

    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = Modifier
            .background(color = Color.LightGray),
        navigationIcon = {
            if (isMainScreen) {
                IconButton(onClick = {
                    onMenuClicked.invoke()
                }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")

                }
            } else {

                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back Icon")

                }
            }

        },

        actions = {
            IconButton(onClick = { showDropDownMenu.value = !showDropDownMenu.value }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Settings Icon")

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
            titleContentColor = MaterialTheme.colorScheme.primary

        )
    )

}