package com.example.timemangement.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.timemangement.presenter.add_task.AddTaskScreen
import com.example.timemangement.presenter.home.HomeScreen
import com.example.timemangement.presenter.timer.TimerScreen
import com.example.timemangement.presenter.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route){
            HomeScreen(navHostController = navController)
        }
        composable(route = Screen.AddTask.route){
            AddTaskScreen(navHostController = navController)
        }
        composable(
            route = Screen.Timer.route,
            arguments = listOf(navArgument(ID_ARGUMENT){
                type = NavType.LongType
            })
        ){
            it.arguments?.let { it1 ->
                TimerScreen(
                    navHostController = navController,
                    id = it1.getLong(ID_ARGUMENT)
                )
            }
        }
    }
}