package com.example.digitalx4.features.service_report.presentation.service_reports.component

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalx4.R
import com.example.digitalx4.features.service_report.domain.model.ServiceReport

@Composable
fun ServiceReportItem(
    serviceReport: ServiceReport,
    navigateToAddEditReportScreenWithArgs: () -> Unit,
    onDeleteClicked: () -> Unit

){

    val subject = stringResource(id = R.string.send_report_subject)

    val serviceReportSummary = stringResource(
        R.string.report_details,
        serviceReport.name,
        serviceReport.month,
        serviceReport.placement,
        serviceReport.videoShowing,
        serviceReport.hours,
        serviceReport.returnVisits,
        serviceReport.bibleStudies,
        serviceReport.comments

    )

    Surface(
        modifier = Modifier
            .padding(12.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(4),
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)

            ) {
            Text(
                text = stringResource(id = R.string.report_title),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 50.dp),
            )
            Spacer(modifier = Modifier.height(3.dp))

            Column (
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.name_input_label),
                        fontSize = 18.sp
                    )

                    Text(
                        text = " : ${serviceReport.name}",
                        fontSize = 18.sp
                    )
                }

                Divider(modifier=Modifier.border(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.month_input_label),
                        fontSize = 18.sp
                    )
                    Text(
                        text = " : ${serviceReport.month}",
                        fontSize = 18.sp
                    )

                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            Column (
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))

            ) {

                ReportRow(
                    text = stringResource(id = R.string.placement_input_label),
                    value = serviceReport.placement

                    )
                Divider(modifier=Modifier.border(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))


                ReportRow(
                    text = stringResource(id = R.string.video_input_label),
                    value = serviceReport.videoShowing
                )
                Divider(modifier=Modifier.border(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))


                ReportRow(
                    text = stringResource(id = R.string.hours_input_label),
                    value = serviceReport.hours
                )
                Divider(modifier=Modifier.border(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))


                ReportRow(
                    text = stringResource(id = R.string.return_visits_input_label),
                    value = serviceReport.returnVisits
                )
                Divider(modifier=Modifier.border(1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer))


                ReportRow(
                    text = stringResource(id = R.string.bible_studies_input_label),
                    value = serviceReport.bibleStudies
                )

            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer)
                    .padding(12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.comments_input_label_label),
                    fontSize = 18.sp,
                    )

                Text(
                    text = " : ${serviceReport.comments}",
                    fontSize = 18.sp,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                val context = LocalContext.current
                ReportActionButton(
                    text = "Delete",
                    onClick = onDeleteClicked
                )


                ReportActionButton(
                    text = "Edit",
                    onClick = { navigateToAddEditReportScreenWithArgs() }

                )

                ReportActionButton(
                    text = "Send",
                    onClick = {
                        sendServiceReport(context, subject, serviceReportSummary)
                    }
                )
            }
        }

    }

}

private fun sendServiceReport(
    context:Context,
    subject:String,
    serviceReportSummary: String
){



    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, serviceReportSummary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.send_report_subject)
        )
    )

}