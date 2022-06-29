package com.example.timemangement.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val totalTime: Int,
    val totalTimeInWeek: Int,
    val taskColor: Int,
)