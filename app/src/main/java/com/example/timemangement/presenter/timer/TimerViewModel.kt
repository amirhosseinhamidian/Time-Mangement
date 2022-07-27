package com.example.timemangement.presenter.timer

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemangement.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TimerViewModel @Inject constructor(
    repository: TaskRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(TimerState())
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Long>("id") ?: return@launch
            val result = repository.getTaskById(id)
            Log.e("amir",result.toString())
            withContext(Dispatchers.Main){
                state = state.copy(
                    task = result
                )
            }
        }
    }

    fun getRunningTime(): String {
        val cal = Calendar.getInstance()
        val i = cal[Calendar.DAY_OF_WEEK] - cal.firstDayOfWeek
        cal.add(Calendar.DATE, -i - 7)
        cal[Calendar.DAY_OF_WEEK] = Calendar.SATURDAY
        cal.firstDayOfWeek = Calendar.SATURDAY
        return cal.get(Calendar.DAY_OF_WEEK).toString()
    }

}