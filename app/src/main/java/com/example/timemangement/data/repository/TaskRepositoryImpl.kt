package com.example.timemangement.data.repository

import com.example.timemangement.data.TaskDatabase
import com.example.timemangement.data.mapper.toTaskEntity
import com.example.timemangement.domain.model.Task
import com.example.timemangement.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    db: TaskDatabase
): TaskRepository {
    private val dao = db.taskDao
    override suspend fun insertTask(task: Task) {
        dao.insertTask(task.toTaskEntity())
    }

    override suspend fun getAllTask(): Flow<List<Task>> {
        return flow {
            dao.getAllTask()
        }
    }
}