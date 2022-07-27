package com.example.timemangement.presenter.home

import com.example.timemangement.domain.model.Task

data class HomeState(
    val tasks: List<Task> = emptyList()
)
