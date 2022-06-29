package com.example.timemangement.domain.model

data class Task(
    val id: Long,
    val title: String,
    val totalTime: Int,
    val totalTimeInWeek: Int,
    val taskColor: Int,
)
