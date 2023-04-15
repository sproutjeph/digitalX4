package com.example.digitalx4.features.service_report.presentation.service_reports.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun OrderBySection(
    modifier: Modifier = Modifier,



    ) {
    val options = listOf("Date", "Last Added", "Year")
    var selectedOption by remember { mutableStateOf(options[0]) }


    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding( vertical = 4.dp),
    ){
        Text(
            text = "SORT BY",
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            options.forEach { option ->
                Row(
                    Modifier
                        .selectable(
                            onClick = { selectedOption = option },
                            selected = (option == selectedOption)
                        )
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = when(option){
                            "Date" -> null
                            "Year" -> null
                            else -> null
                        },

                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
            }
        }
    }

}

