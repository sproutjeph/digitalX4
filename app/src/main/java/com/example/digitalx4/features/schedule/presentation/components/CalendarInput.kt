package com.example.digitalx4.features.schedule.presentation.components

data class CalendarInput(
    val day: Int,
    var toDos: List<String> = emptyList(),
)
