package com.example.digitalx4.features.service_timer.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.Duration
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

@HiltViewModel
class ServiceTimerViewModel  @Inject constructor ():ViewModel() {

    private var time:Duration = Duration.ZERO

    private lateinit var timer: Timer

    var seconds by mutableStateOf("00")
    var minutes by mutableStateOf("00")
    var hours by mutableStateOf("00")

    var isTimerRunning by mutableStateOf(false)



    fun start() = viewModelScope.launch {
        timer = fixedRateTimer(initialDelay = 1000L, period = 1000L){
            time = time.plus(Duration.ofSeconds(1))
            updateTimeStates()
        }

        isTimerRunning = true
    }



    private fun updateTimeStates()  {
        val seconds = time.seconds % 60
        val minutes = time.toMinutes() % 60
        val hours = time.toHours()

        this.seconds = seconds.toString().padStart(2,'0')
        this.minutes = minutes.toString().padStart(2,'0')
        this.hours = hours.toString().padStart(2,'0')
    }

    fun pause() = viewModelScope.launch{
        timer.cancel()
        isTimerRunning = false
    }

    fun stop() = viewModelScope.launch{
        pause()
        time = Duration.ZERO
        updateTimeStates()
    }

}

//fun addStudent(studentModel: StudentModel) = viewModelScope.launch {
//    studentUseCases.addStudent(studentModel)
//}