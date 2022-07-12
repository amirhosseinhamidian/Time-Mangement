package com.example.timemangement.presenter.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timemangement.domain.model.Task

@Composable
fun TaskItem(
    task: Task,
    modifier: Modifier = Modifier
) {
    Surface(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                
            }
            Spacer(modifier = modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

            }
            Spacer(modifier = modifier.height(16.dp) )

        }
    }
}