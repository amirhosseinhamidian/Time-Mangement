package com.example.timemangement.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.timemangement.data.local.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(taskEntity: TaskEntity): Long

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM task")
    suspend fun getAllTask(): List<TaskEntity>

    @Query("SELECT * FROM task WHERE id=:id")
    fun getTaskById(id: Long): TaskEntity

}