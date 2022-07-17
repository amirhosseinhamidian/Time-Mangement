package com.example.timemangement.presenter.timer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.timemangement.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor(
    repository: TaskRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    fun getRunningTime(): String {
        return "12"
    }

}