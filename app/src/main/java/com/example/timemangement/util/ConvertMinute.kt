package com.example.timemangement.util

object ConvertMinute{

    fun minuteToFloat(minute: Int): Float{
        return when(minute) {
            15 -> 0.25f
            30 -> 0.5f
            45 -> 0.75f
            else -> 0f
        }
    }
}
