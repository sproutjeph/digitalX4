package com.example.digitalx4.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.digitalx4.R

@Composable
fun ServiceReportFAB(
    icon: ImageVector  = Icons.Default.Add,
    onClicked:()-> Unit = {}
){
    FloatingActionButton(
        onClick = { onClicked.invoke() },
        modifier= Modifier,
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {

        /* FAB content */
        Icon(
            imageVector = icon,
            contentDescription = null
        )



    }
}