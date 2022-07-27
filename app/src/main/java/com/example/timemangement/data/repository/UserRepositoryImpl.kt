package com.example.timemangement.data.repository

import com.example.timemangement.data.local.TaskDatabase
import com.example.timemangement.domain.model.User
import com.example.timemangement.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    db: TaskDatabase
): UserRepository {
    val userDao = db.userDao
    override suspend fun insertUser(user: User): Long {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserRemainingTimeInWeek(remainingTime: Float) {
        TODO("Not yet implemented")
    }

    override fun getUser(): Flow<User> {
        TODO("Not yet implemented")
    }
}