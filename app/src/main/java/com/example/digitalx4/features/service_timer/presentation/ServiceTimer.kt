package com.example.digitalx4.features.service_timer.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalx4.R
import com.example.digitalx4.ui.theme.md_theme_light_background

@Composable
fun ServiceTimer(
    modifier: Modifier = Modifier,



    ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(6.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )


    ) {

        Column(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(text = stringResource(id = R.string.service_timer),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )


            Row(modifier = Modifier,

                ) {
                Text(
                    text = "00:",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "00:",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "00",
                    style = MaterialTheme.typography.displaySmall
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp),

                ) {
                    Text(text = stringResource(id = R.string.button_stop))

                }
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp)

                ) {
                    Text(text = stringResource(id = R.string.button_pause))
                }

                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = stringResource(id = R.string.button_play))
                }
            }

        }

    }
}