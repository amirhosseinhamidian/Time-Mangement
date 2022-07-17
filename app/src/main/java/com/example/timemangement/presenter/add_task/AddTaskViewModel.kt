package com.example.timemangement.presenter.add_task

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemangement.domain.model.Task
import com.example.timemangement.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val repository: TaskRepository
): ViewModel(){

    private val _title : MutableLiveData<String>  = MutableLiveData("")
    val title: LiveData<String> = _title

    private val _color : MutableLiveData<Int>  = MutableLiveData(0)
    val color: LiveData<Int> = _color

    fun addTask() {
        viewModelScope.launch {
            val id = repository.insertTask(
                Task(
                    title = _title.value!!,
                    taskColor = _color.value!!
                )
            )
        }
    }

    fun onTitleChange(title: String) {
        _title.value = title
    }

    fun colorSelection(color: Int) {
        _color.value = color
    }

    fun progressWeeklyTime(hour: Int, minute: Int): Float {
        //todo: get free time from user
        val freeTime = 60.0f
        val taskTime = when(minute) {
            15 -> hour + 0.25f
            30 -> hour + 0.5f
            45 -> hour + 0.75f
            else -> hour
        }
        return try {
            taskTime.toFloat()/freeTime
        }catch (e: Exception){
            1.0f
        }
    }

    fun chooseColorBaseOnUserTimeComplexity(hour: Int, minute: Int): Color {
        return when(progressWeeklyTime(hour,minute)) {
            in 0.0f .. 0.6f -> Color.Blue
            in 0.6f .. 0.75f -> Color(0xFF03C03C)
            in 0.75f .. 0.85f -> Color(0xFFFFDF00)
            in 0.85f .. 0.95f -> Color(0xFFFF8C00)
            else -> Color(0xFFCE1620)
        }
    }
}