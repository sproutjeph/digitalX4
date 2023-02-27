package com.example.digitalx4.features.service_report.presentation.service_reports.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.digitalx4.features.service_report.domain.model.ServiceReport
import com.example.digitalx4.ui.theme.*

@Composable
fun ServiceReportPreviewItem(
    serviceReport: ServiceReport,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onReportClick: () -> Unit
) {
    val reportColors = listOf(
        RedOrange,
        LightGreen,
        Violet,
        BabyBlue,
        RedPink

    )

    val randomColor = reportColors.random()


    Box(
        modifier = modifier
            .padding(16.dp)
            .clickable { onReportClick.invoke() },

    ){
        Canvas(modifier = Modifier.matchParentSize()  ){
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(clipPath){
                drawRoundRect(
                    color = Color(randomColor.value),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )

                drawRoundRect(
                    color = Color(
                        ColorUtils.blendARGB(randomColor.toArgb(), 0x000000, 0.2f)
                    ),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), 0f),
                    size = Size(cutCornerSize.toPx(), cutCornerSize.toPx()),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = serviceReport.name,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis

            )
            Spacer(modifier = Modifier.height(8.dp))


             Row {
                 Text(
                     text = "Date Entered",
                     style = MaterialTheme.typography.titleMedium,
                     color = Color.Black,
                 )
                 Spacer(modifier = Modifier.width(8.dp))
                 Text(
                     text = serviceReport.entryDate.toString().split(" ")
                         .slice(0 until 3)
                         .joinToString(" "),
                     style = MaterialTheme.typography.titleMedium,
                     color = Color.Black,

                 )

             }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Click for Details",
                style = MaterialTheme.typography.titleSmall,
                color = Color.Black,
            )

        }


    }
}