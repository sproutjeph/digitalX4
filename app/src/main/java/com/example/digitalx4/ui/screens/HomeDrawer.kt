package com.example.digitalx4.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material.icons.outlined.ContactMail
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalx4.R

@Composable
fun HomeNavigationDrawer(
    drawerState: DrawerState,
    navigateToAddEditReportScreen: () -> Unit,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                content = {
                    Text(
                        text = "Service Report",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
                    )
                    LazyColumn{
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Filled.Help, title = "Help") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.Favorite, title = "Support Development") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.Email, title = "Send Feedback") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.Security, title = "Privacy Policy") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item { Divider(thickness = 0.3.dp) }
                        item { Spacer( modifier= Modifier.padding(top = 8.dp)) }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.CloudUpload, title = "Backup") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.Settings, title = "Settings") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item { Spacer( modifier= Modifier.padding(top = 8.dp)) }
                        item { Divider(thickness = 0.3.dp) }
                        item { Divider(thickness = 0.3.dp) }
                        item { Spacer( modifier= Modifier.padding(top = 8.dp)) }
                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.ContactMail, title = "jephthah.mbah@outlook.com") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }

                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(icon = Icons.Outlined.Phone, title = "+2347065406165") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }

                        item {
                            NavigationDrawerItem(
                                label = {
                                    DrawerItemSocial(
                                        icon = painterResource(id = R.drawable.ic_twitter),
                                        title = "Reach Me On Twitter"
                                    )
                                },
                                selected = false,
                                onClick = {
                                    launchSocialActivity(context, "twitter")
                                }
                            )
                        }

                        item {
                            NavigationDrawerItem(
                                label = {
                                    DrawerItemSocial(
                                        icon = painterResource(id = R.drawable.ic_linkedin_brands),
                                        title = "Reach Me On Linkedin"
                                    )
                                },
                                selected = false,
                                onClick = {
                                    launchSocialActivity(context, "linkedin")

                                }
                            )
                        }

                        item {
                            NavigationDrawerItem(
                                label = { DrawerItem(
                                    icon = Icons.Outlined.Copyright,
                                    title = "Copyright 2023 Jephthah Mbah")
                                },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )
                        }
                        item { Spacer( modifier= Modifier.padding(top = 8.dp)) }
                        item { Divider(thickness = 0.3.dp) }
                        item { Spacer( modifier= Modifier.padding(top = 24.dp)) }
                        item {
                            NavigationDrawerItem(
                                label = {
                                    Button(
                                        onClick = {navigateToAddEditReportScreen.invoke() },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(text = "Add Report")

                                    }
                                },
                                selected = false,
                                onClick = {  }
                            )
                        }
                        item { Spacer( modifier= Modifier.padding(vertical = 8.dp)) }


                    }

                }
            )
        },
        content = content
    )



}


@Composable
fun DrawerItem(
    icon: ImageVector,
    title: String,
    msgCount: String = ""
) {

    Row {
        Icon(
            imageVector = icon,
            modifier = Modifier.padding(16.dp),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp),
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )

        if (msgCount.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp),
                text = msgCount,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
        }

    }

}

@Composable
fun DrawerItemSocial(
    icon: Painter,
    title: String,
    msgCount: String = ""
) {

    Row {
        Icon(
            painter = icon,
            modifier = Modifier.padding(16.dp),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp),
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            textAlign = TextAlign.Start
        )

        if (msgCount.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp),
                text = msgCount,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )
        }

    }

}