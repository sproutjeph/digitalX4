package com.example.digitalx4.features.sudents.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun StudentInfoRow(
    label: String = "Name : ",
    text: String = "Jephthah Mbah",
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
//            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surfaceTint

            )
            Surface(modifier = Modifier.width(15.dp)) {

            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.surfaceTint
            )
        }
    }

}
