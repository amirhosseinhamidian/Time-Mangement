package com.example.timemangement.data.mapper

import com.example.timemangement.data.local.entities.TaskEntity
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
        title = title ,
        totalTime = totalTime ?: -1,
        totalTimeInWeek = totalTimeInWeek ?: -1,
        taskColor = taskColor
    )
}

fun List<TaskEntity>.toTaskList() : List<Task> {
    return map {
        it.toTask()
    }
}

fun List<Task>.toTaskEntityList() : List<TaskEntity> {
    return map {
        it.toTaskEntity()
    }
}