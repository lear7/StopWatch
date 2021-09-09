package com.lear7.stopwatch.viewmodel

import android.app.AlarmManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class TimeViewModel : ViewModel() {

    private val timeString = MutableLiveData<String>()

    fun getTime(): LiveData<String> = timeString

    init {
        val mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        mScheduledExecutorService.scheduleAtFixedRate({
            // setValue要在主线程中执行
            // setValue() cannot be called from a background thread so post to main thread.
            timeString.postValue(getCurrentTime())
        }, 1, 10, TimeUnit.MILLISECONDS)
    }

    fun getCurrentTime(): String {
        var calendar = Calendar.getInstance()
        calendar.timeZone = TimeZone.getTimeZone("GMT+08")
        calendar.setTimeInMillis(System.currentTimeMillis())
        var template = SimpleDateFormat("mm:ss:SSS") // SimpleDateFormat
        var timeStr = template.format(calendar.time) // String
        return timeStr
    }
}