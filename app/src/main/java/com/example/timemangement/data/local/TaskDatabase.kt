package com.example.timemangement.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.timemangement.data.local.dao.TaskDao
import com.example.timemangement.data.local.entities.TaskEntity
import com.example.timemangement.data.local.entities.TimeHistoryEntity

@Database(
    entities = [TaskEntity::class,TimeHistoryEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
}