package com.example.timemangement.domain.repository

import com.example.timemangement.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(task: Task): Long
    suspend fun getAllTask(): List<Task>
    suspend fun getTaskById(id:Long): Task
}