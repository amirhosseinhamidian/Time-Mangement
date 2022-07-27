package com.example.timemangement.domain.repository

import com.example.timemangement.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User): Long
    suspend fun updateUser(user: User)
    suspend fun updateUserRemainingTimeInWeek(remainingTime: Float)
    fun getUser(): Flow<User>
}