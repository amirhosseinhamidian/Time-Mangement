package com.example.timemangement.presenter.add_task

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timemangement.domain.model.Task
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun AddTaskScreen(
    navigator: DestinationsNavigator,
    viewModel: AddTaskViewModel = hiltViewModel()
) {

    val title by viewModel.title.observeAsState()
    val color by viewModel.color.observeAsState()
    var selectedColorIndex by remember { mutableStateOf(-1) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Add New Task",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = title ?: "",
            onValueChange = viewModel::onTitleChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        ColorSelectionGrid(
            colorSelectionList = listOf(
                Color(0xFFD97FF0),
                Color(0xFF7F94F0),
                Color(0xFF837FF0),
                Color(0xFF7FD2F0),
                Color(0xFF7FF0D2),
                Color(0xFF8EF07F),
                Color(0xFFE4F07F),
                Color(0xFFF0BB7F),
                Color(0xFFF08E7F),
                Color(0xFFF07F7F),
            ),
            selected = { index -> selectedColorIndex == index},
            tint = { Color.Unspecified },
        ) { index: Int , item: Color ->
            selectedColorIndex = index
            viewModel.colorSelection(item.hashCode())
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = MaterialTheme.shapes.large,
                onClick = {
                    viewModel.addTask()
                }
            ) {
                Text(
                    text = "Save",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.primary
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                onClick = {  }
            ) {
                Text(
                    text = "Start",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Composable
fun ColorSelectionGrid(
    modifier: Modifier = Modifier,
    columns: GridCells = GridCells.Fixed(8),
    contentPadding: PaddingValues = PaddingValues(8.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(4.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(4.dp),
    colorSelectionList: List<Color>,
    selected: (Int) -> Boolean,
    tint: (Int) -> Color,
    onClick: (Int, Color) -> Unit,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = columns,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
        horizontalArrangement = horizontalArrangement,
    ) {
        itemsIndexed(colorSelectionList) { index: Int, item: Color ->

            ColorDisplay(
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f)
                    .clickable {
                        onClick(index, item)
                    },
                backgroundColor = item,
                selected = selected(index),
                tint = tint(index),
            )
        }
    }
}

@Composable
fun ColorDisplay(
    modifier: Modifier,
    selected: Boolean,
    tint: Color = Color.Unspecified,
    backgroundColor: Color
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
        )

        if (selected) {
            Icon(
                modifier = modifier
                    .background(tint.copy(alpha = .5f))
                    .padding(4.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "check",
                tint = Color.Green
            )
        }
    }
}