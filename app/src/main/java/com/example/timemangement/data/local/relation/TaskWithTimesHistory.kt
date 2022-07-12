package com.example.timemangement.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.timemangement.data.local.entities.TimeHistoryEntity
import com.example.timemangement.domain.model.Task

data class TaskWithTimesHistory(
    @Embedded val task: Task,
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val times: List<TimeHistoryEntity>
)