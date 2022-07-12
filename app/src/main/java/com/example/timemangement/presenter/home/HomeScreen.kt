package com.example.timemangement.presenter.home

import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timemangement.presenter.destinations.AddTaskScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    FloatingActionButton(
        onClick = {
            navigator.navigate(AddTaskScreenDestination)
        }) {
        
    }
}