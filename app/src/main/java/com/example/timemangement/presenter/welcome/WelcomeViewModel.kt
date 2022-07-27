package com.example.timemangement.presenter.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemangement.data.datastore.DataStoreRepository
import com.example.timemangement.domain.model.User
import com.example.timemangement.domain.repository.UserRepository
import com.example.timemangement.util.ConvertMinute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: UserRepository,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {

    fun registerUser(hourSleep: Int, minuteSleep: Int, hourPersonal: Int, minutePersonal: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val personalTime = hourPersonal + ConvertMinute.minuteToFloat(minutePersonal)
            val sleepTime = hourSleep + ConvertMinute.minuteToFloat(minuteSleep)
            val freeTimeInWeek = 24*7 - (personalTime + sleepTime)
            val user = User(
                freeTimeInWeek = freeTimeInWeek,
                personalTimeInWeek = personalTime,
                sleepTimeInWeek = sleepTime
            )
            repository.insertUser(user)
        }
    }

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.saveOnBoardingState(completed = completed)
        }
    }
}