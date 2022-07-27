package com.example.timemangement.navigation

const val ID_ARGUMENT = "id"

sealed class Screen(val route: String) {
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object AddTask: Screen(route = "add_task_screen")
    object Timer: Screen(route = "timer_screen/{$ID_ARGUMENT}"){
        fun passId(id: Long): String {
            return "timer_screen/$id"
        }
    }
}