package com.example.timemangement.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.timemangement.data.entities.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM task")
    suspend fun getAllTask()

    @Query("SELECT * FROM task WHERE id=:id")
    suspend fun getTaskById(id: Long)
}