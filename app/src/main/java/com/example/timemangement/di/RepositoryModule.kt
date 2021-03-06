package com.example.timemangement.di

import com.example.timemangement.data.repository.TaskRepositoryImpl
import com.example.timemangement.data.repository.UserRepositoryImpl
import com.example.timemangement.domain.repository.TaskRepository
import com.example.timemangement.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTaskRepository(taskRepositoryImpl: TaskRepositoryImpl) : TaskRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}