package com.example.digitalx4.ui.components

import     androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceReportTopAppBar(
    title: Int,
    isMainScreen: Boolean = true,
    navController: NavController,
    onButtonClicked: () -> Unit = {},
){

    val showDropDownMenu = remember { mutableStateOf(false) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch {
            drawerState.close()
        }
    }





    if(showDropDownMenu.value){
        SettingsDropDownMenu(
            showDropDownMenu = showDropDownMenu,
            navController = navController
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
            if(isMainScreen){
                IconButton(onClick = {
                    scope.launch { drawerState.open() }
                }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")

                }
            }else{

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



//    NavigationDrawer
    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(320.dp)
            ) {

                Spacer(modifier = Modifier.height(12.dp))
                Box(modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        scope.launch { drawerState.close() }

                    }
                ){
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
                items.forEach {item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                }

                Divider()
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "About", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Version")
                    Text(text = "1.0")

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Support", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "Copyright 2023 Jephthah Mbah")
                    Text(text = "Contact: jephthah.mbah@outlook.com")
                    Text(text = "Phone +2347065406165")


                }



            }
        },
        content = {}

    )

}