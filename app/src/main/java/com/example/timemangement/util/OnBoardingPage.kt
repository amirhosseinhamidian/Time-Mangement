package com.example.timemangement.util

import androidx.annotation.DrawableRes
import com.example.timemangement.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
    val page: Int
) {
    object SleepTime : OnBoardingPage(
        image = R.drawable.sleep_time,
        title = "SLEEP TIME",
        description = "How many hours do you sleep daily?",
        page = 1
    )

    object FreeTime : OnBoardingPage(
        image = R.drawable.free_time,
        title = "Personal TIME",
        description = "How many hours of personal time do you need per day?",
        page = 2
    )
}
