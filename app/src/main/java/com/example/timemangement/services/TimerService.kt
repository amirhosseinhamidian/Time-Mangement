package com.example.timemangement.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import com.example.timemangement.MainActivity
import com.example.timemangement.util.Constants.ACTION_PAUSE_SERVICE
import com.example.timemangement.util.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.timemangement.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.timemangement.util.Constants.NOTIFICATION_CHANNEL_ID
import com.example.timemangement.util.Constants.NOTIFICATION_CHANNEL_NAME
import com.example.timemangement.util.Constants.NOTIFICATION_ID
import com.example.timemangement.util.Constants.TIMER_UPDATE_INTERVAL
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService: LifecycleService() {
    var isFirstRun = true
    private val timeInSeconds = MutableLiveData<Long>()

    companion object {
        val timeInMillis = MutableLiveData<Long>()
    }

    private fun postInitialValues() {
        timeInSeconds.postValue(0L)
        timeInMillis.postValue(0L)
    }

    override fun onCreate() {
        super.onCreate()
        postInitialValues()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun) {
                        startForegroundService()
                        isFirstRun = false
                    } else {
                        startTimer()
                    }
                }
                ACTION_PAUSE_SERVICE -> {
                    pauseService()
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private var isTimerEnabled = MutableLiveData(false)
    private var lapTime = 0L
    private var timeRun = 0L
    private var timeStarted = 0L
    private var lastSecondTimestamp = 0L

    private fun startTimer() {
        timeStarted = System.currentTimeMillis()
        isTimerEnabled.postValue(true)
        CoroutineScope(Dispatchers.Main).launch {
            while (isTimerEnabled.value!!) {
                // time difference between now and timeStarted
                lapTime = System.currentTimeMillis() - timeStarted
                // post the new lapTime
                timeInMillis.postValue(timeRun + lapTime)
                if (timeInMillis.value!! >= lastSecondTimestamp + 1000L) {
                    timeInSeconds.postValue(timeInSeconds.value!! + 1)
                    lastSecondTimestamp += 1000L
                }
                delay(TIMER_UPDATE_INTERVAL)
            }
            timeRun += lapTime
        }
    }

    private fun pauseService() {
        isTimerEnabled.postValue(false)
    }


    private fun startForegroundService() {
        startTimer()

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
//            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Time Management")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }

    @OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}