package com.example.timemangement.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val totalTime: Int,
    val totalTimeInWeek: Int,
    val taskColor: Int,
)