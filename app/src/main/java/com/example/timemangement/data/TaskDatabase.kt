package com.example.timemangement.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timemangement.data.dao.TaskDao
import com.example.timemangement.data.entities.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
}