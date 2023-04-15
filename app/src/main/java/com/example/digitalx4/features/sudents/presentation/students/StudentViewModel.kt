package com.example.digitalx4.features.sudents.presentation.students

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import com.example.digitalx4.features.sudents.domain.use_case.StudentUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor (
    private  val studentUseCases: StudentUseCases
        ):ViewModel(){

    private val _students = MutableStateFlow<List<StudentModel>>(emptyList())

    val students = _students.asStateFlow()

    init {
        viewModelScope.launch (Dispatchers.IO){
            studentUseCases.getAllStudents().distinctUntilChanged()
                .collect{
                        listOfStudents ->
                    if(listOfStudents.isEmpty()){
                        Log.d("Empty", "Empty List ")
                    }else{
                        _students.value = listOfStudents
                    }
                }
        }

        studentUseCases.getAllStudents().distinctUntilChanged()

    }

    fun addStudent(studentModel: StudentModel) = viewModelScope.launch {
            studentUseCases.addStudent(studentModel)
        }

    fun updateStudent(studentModel: StudentModel) = viewModelScope.launch {
        studentUseCases.updateStudent(studentModel)
    }

    fun deleteStudent(studentModel: StudentModel) = viewModelScope.launch {
        studentUseCases.deleteStudent(studentModel)
    }


}