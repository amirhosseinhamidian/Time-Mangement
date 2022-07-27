package com.example.timemangement.data.repository

import com.example.timemangement.data.local.TaskDatabase
import com.example.timemangement.data.mapper.toTask
import com.example.timemangement.data.mapper.toTaskEntity
import com.example.timemangement.data.mapper.toTaskList
import com.example.timemangement.domain.model.Task
import com.example.timemangement.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    db: TaskDatabase
): TaskRepository {
    private val dao = db.taskDao
    override suspend fun insertTask(task: Task): Long {
        return dao.insertTask(task.toTaskEntity())
    }

    override suspend fun getAllTask(): List<Task> {
        return dao.getAllTask().toTaskList()
    }

    override suspend fun getTaskById(id: Long): Task {
        return dao.getTaskById(id).toTask()
    }
}