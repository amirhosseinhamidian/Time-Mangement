package com.example.timemangement.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.timemangement.data.local.dao.TaskDao
import com.example.timemangement.data.local.dao.UserDao
import com.example.timemangement.data.local.entities.TaskEntity
import com.example.timemangement.data.local.entities.UserEntity

@Database(
    entities = [TaskEntity::class,UserEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class TaskDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao
    abstract val userDao: UserDao
}