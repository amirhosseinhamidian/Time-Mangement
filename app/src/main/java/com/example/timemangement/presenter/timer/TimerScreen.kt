package com.example.timemangement.presenter.timer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.min

@Composable
@Destination
fun TimerScreen(
    viewModel: TimerViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    id: Int
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)) {
            Text(
                text = "Programming",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Task running for",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = viewModel.getRunningTime(),
                style = MaterialTheme.typography.h4
            )

        }
        AnalogClockProgress(
            startAngle = 0f,
            sweepAngle = 65f,
            colorProgress = Color.Blue,
            colorOutline = MaterialTheme.colors.surface,
            outlineWidthProgress = 12.dp,
            outlineWidthHourMark = 4.dp,
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.Center)
        )
        
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .align(Alignment.BottomCenter)
                .height(48.dp)
                .background(color = Color.Transparent),
            border = BorderStroke(2.dp,MaterialTheme.colors.primary),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "End Task",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun AnalogClockProgress(
    startAngle: Float,
    sweepAngle: Float,
    colorProgress: Color,
    colorOutline: Color,
    outlineWidthProgress: Dp,
    outlineWidthHourMark: Dp,
    modifier: Modifier
) {
    with(LocalDensity.current) {
        val outlineWidthProgressPx = remember {
            outlineWidthProgress.toPx()
        }
        val outlineWidthHourMarkPx = remember {
            outlineWidthHourMark.toPx()
        }

        Canvas(modifier = modifier) {
            val diameter = min(size.width,size.height)
            val radius = diameter/2
            val hourMarkerLength = radius/ 12f
            val hourMarkerLength2 = radius/ 8f

            repeat(12) {
                val degreesMarker = it/12f*360
                rotate(degreesMarker) {
                    val start = center - Offset(0f , radius)
                    val end = if (degreesMarker % 90 == 0f) {
                        start + Offset(0f,hourMarkerLength2)
                    }else {
                        start + Offset(0f,hourMarkerLength)
                    }
                    drawLine(
                        color = colorOutline,
                        start = start,
                        end = end,
                        strokeWidth = outlineWidthHourMarkPx
                    )
                }
            }

            drawArc(
                color = colorOutline,
                useCenter = false,
                startAngle = 0f,
                sweepAngle = 360f,
                size = Size(size.width,size.height),
                style = Stroke(outlineWidthProgressPx),
            )

            drawArc(
                color = colorProgress,
                useCenter = false,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                size = Size(size.width,size.height),
                style = Stroke(outlineWidthProgressPx, cap = StrokeCap.Round)
            )
        }
    }
}