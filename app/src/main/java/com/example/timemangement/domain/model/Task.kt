package com.example.timemangement.domain.model

data class Task(
    val id: Long? = null,
    val title: String,
    val totalTime: Int? = null,
    val totalTimeInWeek: Int? = null,
    val taskColor: Int,
)
