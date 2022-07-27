package com.example.timemangement.presenter.welcome

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.timemangement.navigation.Screen
import com.example.timemangement.presenter.components.ListItemPicker
import com.example.timemangement.presenter.components.NumberPicker
import com.example.timemangement.util.OnBoardingPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages = listOf(
        OnBoardingPage.SleepTime,
        OnBoardingPage.FreeTime
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier,
            count = 2,
            state = pagerState
        ) {
            PagerScreen(
                onBoardingPage = pages[it]
            ) { hourSleep: Int, minuteSleep: Int, hourPersonal: Int, minutePersonal: Int ->
                viewModel.registerUser(hourSleep,minuteSleep,hourPersonal,minutePersonal)
                viewModel.saveOnBoardingState(completed = true)
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            }
        }
    }
}

@Composable
fun PagerScreen(
    onBoardingPage: OnBoardingPage,
    onClick: (Int, Int, Int, Int) -> Unit
) {
    var hourSleep by remember { mutableStateOf(0) }
    var minuteSleep by remember { mutableStateOf(0) }
    var hourPersonal by remember { mutableStateOf(0) }
    var minutePersonal by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(0.5f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "pager image"
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = onBoardingPage.title,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = onBoardingPage.title,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            NumberPicker(
                value = if (onBoardingPage.page == 1) hourSleep else hourPersonal,
                onValueChange = {
                    if (onBoardingPage.page == 1) hourSleep = it else hourPersonal = it
                },
                range = 0..12,
                textStyle = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = ":",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            ListItemPicker(
                value = if (onBoardingPage.page == 1) minuteSleep else minutePersonal,
                onValueChange = {
                    if (onBoardingPage.page == 1) minuteSleep = it else minutePersonal = it
                },
                list = listOf(0, 15, 30, 45),
                textStyle = MaterialTheme.typography.h6
            )
        }
        Button(
            onClick = {
                onClick(hourSleep, minuteSleep, hourPersonal, minutePersonal)
            }) {
            Text(
                text = "Submit"
            )
        }
    }
}
