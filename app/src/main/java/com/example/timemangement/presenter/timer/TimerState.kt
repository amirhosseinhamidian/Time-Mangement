package com.example.timemangement.presenter.timer

import com.example.timemangement.domain.model.Task

data class TimerState(
    val task: Task? = null,
    val loading: Boolean = false
)
