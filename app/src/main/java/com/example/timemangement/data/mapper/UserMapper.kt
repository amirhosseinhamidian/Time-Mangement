package com.example.timemangement.data.mapper

import com.example.timemangement.data.local.entities.UserEntity
import com.example.timemangement.domain.model.User

fun UserEntity.toUser(): User {
    return User(
        id = id,
        freeTimeInWeek = freeTimeInWeek,
        remainingFreeTimeInWeek = remainingFreeTimeInWeek,
        personalTimeInWeek = personalTimeInWeek,
        sleepTimeInWeek = sleepTimeInWeek
    )
}

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = id,
        freeTimeInWeek = freeTimeInWeek,
        remainingFreeTimeInWeek = remainingFreeTimeInWeek,
        personalTimeInWeek = personalTimeInWeek,
        sleepTimeInWeek = sleepTimeInWeek
    )
}