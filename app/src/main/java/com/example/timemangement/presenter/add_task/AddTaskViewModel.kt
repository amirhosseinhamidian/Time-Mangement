package com.example.timemangement.presenter.add_task

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
}