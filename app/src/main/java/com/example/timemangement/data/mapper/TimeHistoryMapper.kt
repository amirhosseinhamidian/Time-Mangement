package com.example.timemangement.data.mapper

import com.example.timemangement.data.local.entities.TaskEntity
import com.example.timemangement.data.local.entities.TimeHistoryEntity
import com.example.timemangement.domain.model.TimeHistory

fun TimeHistoryEntity.toTimeHistory() : TimeHistory {
    return TimeHistory(
        id = id,
        taskId = taskId,
        second = second,
        minute = minute,
        hour = hour,
        description = description,
        createdAt = createdAt
    )
}

fun TimeHistory.toTimeHistoryEntity(): TimeHistoryEntity {
    return TimeHistoryEntity(
        id = id,
        taskId = taskId,
        second = second,
        minute = minute,
        hour = hour,
        description = description,
        createdAt = createdAt
    )
}