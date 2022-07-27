package com.example.timemangement.domain.model

data class User(
    val id: Long? = null,
    val freeTimeInWeek: Float? = null,
    val remainingFreeTimeInWeek: Float? = null,
    val personalTimeInWeek: Float? = null,
    val sleepTimeInWeek: Float? = null
)
