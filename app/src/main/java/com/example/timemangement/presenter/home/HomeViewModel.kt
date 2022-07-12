package com.example.timemangement.presenter.home

import androidx.lifecycle.ViewModel
import com.example.timemangement.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
   private val repository: TaskRepository
): ViewModel() {


}