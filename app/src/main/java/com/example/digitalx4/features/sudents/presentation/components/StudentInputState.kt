package com.example.digitalx4.features.sudents.presentation.components

import androidx.compose.runtime.MutableState
import java.util.*

data class StudentInputState(
    val id: UUID? = null,
    val name: MutableState<String>,
    val address: MutableState<String>,
    val phoneNumber: MutableState<String>,
    val email: MutableState<String>,
    val bookStudying: MutableState<String>,
    val lesson: MutableState<String>,
    val timeOfVisit: MutableState<String>,
    val questionToConsider: MutableState<String>,
    val note: MutableState<String>,

    )

