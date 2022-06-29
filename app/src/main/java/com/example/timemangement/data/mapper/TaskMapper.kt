package com.example.timemangement.data.mapper

import com.example.timemangement.data.entities.TaskEntity
import com.example.timemangement.domain.model.Task

fun TaskEntity.toTask() : Task {
    return Task(
        id = id,
        title = title,
        totalTime = totalTime,
        totalTimeInWeek = totalTimeInWeek,
        taskColor = taskColor
    )
}

fun Task.toTaskEntity() : TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        totalTime = totalTime,
        totalTimeInWeek = totalTimeInWeek,
        taskColor = taskColor
    )
}