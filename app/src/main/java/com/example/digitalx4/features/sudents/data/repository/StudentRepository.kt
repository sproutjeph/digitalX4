package com.example.digitalx4.features.sudents.data.repository

import com.example.digitalx4.features.sudents.domain.model.StudentModel
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getAllStudents(): Flow<List<StudentModel>>

    suspend fun addStudent(studentModel: StudentModel)

    suspend fun deleteAllStudents()

    suspend fun deleteStudent(studentModel: StudentModel)

    suspend fun getStudentById(studentId:String): StudentModel?

    suspend fun updateStudent(studentModel: StudentModel)
}