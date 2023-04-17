package com.example.digitalx4.features.schedule.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.add_edit_report.components.ServiceReportInputField

@Composable
fun EnterScheduleDialog(
     openDialog: MutableState<Boolean>

) {
    var dayOfMonthInput by remember {
        mutableStateOf("")
    }

    var scheduleDetailsInput by remember {
        mutableStateOf("")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {

                openDialog.value = false
            },

            title = { Text("Enter Your Schedule") },
            text = {
                Column {
                    ServiceReportInputField(
                        value = dayOfMonthInput,
                        onValueChange = {dayOfMonthInput = it },
                        label = R.string.day_of_month
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ServiceReportInputField(
                        value = scheduleDetailsInput,
                        onValueChange = {scheduleDetailsInput = it},
                        label = R.string.schedule_details,
                        keyboardType = KeyboardType.Text,
                        maxLine = 5
                    )
                }
                   },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("Save")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            },

        )
    }
}