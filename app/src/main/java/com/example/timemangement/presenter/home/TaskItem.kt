package com.example.timemangement.presenter.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timemangement.domain.model.Task

@Composable
fun TaskItem(
    task: Task,
    modifier: Modifier = Modifier,
    taskProgressPerWeek: Int = 0,
    spendTimeInWeek: Int = 0,
    targetTimeInWeek: Int = 0,
) {
    Surface(
        elevation = 6.dp,
        shape = MaterialTheme.shapes.medium,
        color = Color(task.taskColor)
    ) {
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )

            Text(
                text = "$taskProgressPerWeek%",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(vertical = 16.dp),
                style = MaterialTheme.typography.h4
            )

            Text(
                text = "time spent: $spendTimeInWeek",
                style = MaterialTheme.typography.subtitle2
            )

            Text(
                text = "target in week: $targetTimeInWeek",
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}