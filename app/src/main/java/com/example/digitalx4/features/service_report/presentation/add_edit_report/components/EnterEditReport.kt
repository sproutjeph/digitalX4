package com.example.digitalx4.features.service_report.presentation.add_edit_report.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.add_edit_report.ServiceReportInputTextFieldState
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterEditReport(
    modifier: Modifier = Modifier,
    serviceReportInputTextFieldStateState: ServiceReportInputTextFieldState,
){
    val currentYear = LocalDate.now().year
    val options = mutableListOf<String>()
    for (month in 1..12) {
        val monthName = LocalDate.of(currentYear, month, 1)
            .month
            .getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH)
        options.add("${monthName.substring(0, 3)} $currentYear")
    }


    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { serviceReportInputTextFieldStateState.month }


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 16.dp)

    ){
        ServiceReportInputField(
            value = serviceReportInputTextFieldStateState.name.value,
            label = R.string.name_input_label,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardType = KeyboardType.Text,
            onValueChange = {
                if(it.all {
                            char -> char.isLetter() || char.isWhitespace()
                    }) serviceReportInputTextFieldStateState.name.value = it

            }


        )



        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {


            ExposedDropdownMenuBox(
                expanded = expanded,
                modifier = Modifier
                    .weight(1f),
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {

                ServiceReportInputField(
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = {
                         serviceReportInputTextFieldStateState.month.value = it
                    },
                    modifier = Modifier.menuAnchor(),

                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )

                    },
                    label = R.string.month_input_label
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    options.forEach { selectionOption ->

                        DropdownMenuItem(
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            },
                            text = { Text(selectionOption) }
                        )
                    }
                }
            }






            Spacer(modifier = Modifier.width(8.dp))

            ServiceReportInputField(
                value = serviceReportInputTextFieldStateState.placement.value,
                label = R.string.placement_input_label,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {

                    if(it.all {
                                char -> char.isDigit() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.placement.value = it

                }
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ServiceReportInputField(
                value = serviceReportInputTextFieldStateState.videoShowing.value,
                label = R.string.video_input_label,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {
                    if(it.all {
                                char -> char.isDigit() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.videoShowing.value = it


                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            ServiceReportInputField(
                value = serviceReportInputTextFieldStateState.hours.value,
                label = R.string.hours_input_label,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {
                    if(it.all {
                                char -> char.isDigit() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.hours.value = it

                }
            )

        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        ) {
            ServiceReportInputField(
                value = serviceReportInputTextFieldStateState.returnVisits.value,
                label = R.string.return_visits_input_label,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {
                    if(it.all {
                                char -> char.isDigit() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.returnVisits.value = it

                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            ServiceReportInputField(
                value= serviceReportInputTextFieldStateState.bibleStudies.value,
                label = R.string.bible_studies_input_label,
                modifier = Modifier
                    .weight(1f),
                onValueChange = {
                    if(it.all {
                                char -> char.isDigit() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.bibleStudies.value = it

                }
            )
        }

        ServiceReportInputField(
            value = serviceReportInputTextFieldStateState.comments.value,
            label = R.string.comments_input_label_label,
            modifier = Modifier
                .fillMaxWidth(),
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text,
            onValueChange = {
                if(it.all {
                            char -> char.isLetter() || char.isWhitespace()
                    }) serviceReportInputTextFieldStateState.comments.value = it

            }

        )


    }
}



