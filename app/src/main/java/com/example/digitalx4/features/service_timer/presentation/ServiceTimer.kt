package com.example.digitalx4.features.service_timer.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digitalx4.R
import com.example.digitalx4.ui.theme.md_theme_light_background
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ServiceTimer(
    modifier: Modifier = Modifier,
    isTimerRuning:Boolean,
    seconds:String,
    minutes:String,
    hours:String,
    onStart:()-> Unit = {},
    onPause: ()-> Unit = {},
    onStop: ()-> Unit = {}



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
                AnimatedContent(targetState =hours, transitionSpec = { addAnimation() }) {
                    Text(
                        text = "$hours : ",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
                AnimatedContent(targetState =minutes, transitionSpec = { addAnimation() }) {
                    Text(
                        text = "$minutes : ",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
                AnimatedContent(targetState =seconds, transitionSpec = { addAnimation() }) {
                    Text(
                        text = seconds,
                        style = MaterialTheme.typography.displaySmall,
                        color = if(seconds == "00") MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.primary
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly

            ){
                Button(
                    onClick = { onStop.invoke() },
                    shape = RoundedCornerShape(5.dp),
                    enabled = isTimerRuning


                ) {
                    Text(text = stringResource(id = R.string.button_stop))

                }
                Button(
                    onClick = { onPause.invoke() },
                    shape = RoundedCornerShape(5.dp),
                    enabled = isTimerRuning


                ) {
                    Text(text = stringResource(id = R.string.button_pause))
                }

                Button(
                    onClick = { onStart.invoke()},
                    shape = RoundedCornerShape(5.dp),
                    enabled = !isTimerRuning
                ) {
                    Text(text = stringResource(id = R.string.button_play))
                }
            }

        }

    }
}


@ExperimentalAnimationApi
fun addAnimation(duration: Int = 600): ContentTransform {
    return slideInVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeIn(
        animationSpec = tween(durationMillis = duration)
    ) with slideOutVertically(animationSpec = tween(durationMillis = duration)) { height -> height } + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
}