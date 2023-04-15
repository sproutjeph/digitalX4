package com.example.digitalx4.features.schedule.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import android.graphics.Paint
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.launch

private const val CALENDAR_ROWS = 5
private const val CALENDAR_COLUMNS = 7


@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    calendarInputs: List<CalendarInput>,
    onDayClicked: (Int) -> Unit,
    strokeWidth: Float = 15f,
    month: String,

) {

    var canvasSize by remember {
        mutableStateOf(Size.Zero)
    }


    var clickAnimationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var animationRadius by remember {
        mutableStateOf(0f)
    }

    val scope = rememberCoroutineScope()

  Column(
       modifier = modifier,
       verticalArrangement = Arrangement.spacedBy(10.dp),
   ) {
      Text(
         text = month,
         fontWeight = FontWeight.SemiBold,
         color = MaterialTheme.colorScheme.primary,
         fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      )
      Canvas(
          modifier = Modifier
              .fillMaxSize()
              .pointerInput(true) {
                  detectTapGestures(
                      onTap = {offset ->
                          val column =
                              (offset.x / canvasSize.width * CALENDAR_COLUMNS).toInt() + 1
                          val row = (offset.y / canvasSize.height * CALENDAR_ROWS).toInt() + 1
                          val day = column + (row - 1) * CALENDAR_COLUMNS

                          if(  day <= calendarInputs.size){
                              onDayClicked(day)
                                clickAnimationOffset = offset
                              scope.launch {
                                  animate(
                                      0f,
                                      225f,
                                      animationSpec = tween(300)
                                  ){ value, _ ->
                                        animationRadius = value
                                  }
                              }
                          }



                      }
                  )
              }

      ){
          val canvasHeight = size.height
          val canvasWidth = size.width
          canvasSize = Size(canvasWidth, canvasHeight)
            val ySteps = canvasHeight / CALENDAR_ROWS
            val xSteps = canvasWidth / CALENDAR_COLUMNS

          val column = (clickAnimationOffset.x / (canvasSize.width * CALENDAR_COLUMNS)).toInt() + 1
          val row = (clickAnimationOffset.y / canvasSize.height * CALENDAR_ROWS).toInt() + 1

          val path = Path().apply{
              moveTo((column-1)*xSteps,(row-1)*ySteps)
              lineTo(column*xSteps,(row-1)*ySteps)
              lineTo(column*xSteps,row*ySteps)
              lineTo((column-1)*xSteps,row*ySteps)
              close()
          }

          clipPath(path){
              drawCircle(
                  brush = Brush.radialGradient(
                      listOf(Color.Red.copy(0.8f), Color.Red.copy(0.2f)),
                      center = clickAnimationOffset,
                      radius = animationRadius + 0.1f
                  ),
                  radius = animationRadius + 0.1f,
                  center = clickAnimationOffset
              )
          }

          drawRoundRect(
                color = Color.Red.copy(0.2f),
//                topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
//                size = androidx.compose.ui.geometry.Size(canvasWidth, canvasHeight),
                cornerRadius = CornerRadius(25f, 25f),
              style = Stroke(
                 width =  strokeWidth
              )

            )

          for (i in 1 until  CALENDAR_ROWS) {
              drawLine(
                  color = Color.Red.copy(0.2f),
                  start = Offset(0f, ySteps * i),
                  end = Offset(canvasWidth, ySteps * i),
                  strokeWidth = strokeWidth
              )
          }

            for (i in 1 until  CALENDAR_COLUMNS) {
                drawLine(
                    color = Color.Red.copy(0.2f),
                    start = Offset(xSteps * i, 0f),
                    end = Offset(xSteps * i, canvasHeight),
                    strokeWidth = strokeWidth
                )
            }

          val textHeight = 17.dp.toPx()

          for(  i in calendarInputs.indices){
              val textPositionX = xSteps * (i % CALENDAR_COLUMNS) + strokeWidth
              val textPositionY = (i / CALENDAR_COLUMNS) * ySteps + textHeight + strokeWidth/2
              drawContext.canvas.nativeCanvas.apply {
                  drawText(
                      "${i+1}",
                      textPositionX,
                      textPositionY,
                        Paint().apply {
                            textSize = textHeight
                            color = Color.Black.toArgb()
                            isFakeBoldText = true
                        }


                  )
              }

          }


}



}

}


