package com.example.timemangement.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val freeTimeInWeek: Float? = null,
    val remainingFreeTimeInWeek: Float? = null,
    val personalTimeInWeek: Float? = null,
    val sleepTimeInWeek: Float? = null
)