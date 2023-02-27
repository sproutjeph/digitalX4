package com.example.digitalx4.features.service_report.presentation.add_edit_report.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.presentation.add_edit_report.ServiceReportInputTextFieldState

@Composable
fun EnterEditReport(
    modifier: Modifier = Modifier,
    serviceReportInputTextFieldStateState: ServiceReportInputTextFieldState,
){





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
            ServiceReportInputField(
                value = serviceReportInputTextFieldStateState.month.value,
                label = R.string.month_input_label,
                modifier = Modifier
                    .weight(1f),
                keyboardType = KeyboardType.Text,
                onValueChange = {
                    if(it.all {
                                char -> char.isLetter() || char.isWhitespace()
                        }) serviceReportInputTextFieldStateState.month.value = it

                }

            )

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