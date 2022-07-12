package com.example.timemangement.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time")
data class TimeHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val taskId: Long,
    val second: String? = null,
    val minute: String? = null,
    val hour: String? = null,
    val description: String? = null,
    val createdAt: Long?,
)