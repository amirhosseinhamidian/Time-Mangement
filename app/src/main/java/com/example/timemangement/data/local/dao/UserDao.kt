package com.example.timemangement.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.timemangement.data.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insert(userEntity: UserEntity): Long

    @Update
    suspend fun update(userEntity: UserEntity)

    @Query("UPDATE user SET remainingFreeTimeInWeek = :remainingTime")
    suspend fun updateUserRemainingTimeInWeek(remainingTime: Float)

    @Query("SELECT * FROM user")
    fun getUser(): Flow<UserEntity>
}