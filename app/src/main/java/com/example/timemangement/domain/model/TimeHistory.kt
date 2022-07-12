package com.example.timemangement.domain.model

data class TimeHistory(
    val id: Long? = null,
    val taskId: Long,
    val second: String? = null,
    val minute: String? = null,
    val hour: String? = null,
    val description: String? = null,
    val createdAt: Long?,
)