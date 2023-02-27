package com.example.digitalx4.features.service_report.presentation.add_edit_report.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ServiceReportActionButton(
    modifier: Modifier = Modifier,
    text:String,
    onClick: ()-> Unit,
    enabled: Boolean = true,
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier,
        shape = RoundedCornerShape(4.dp),

        ) {
        Text(text)
    }
}