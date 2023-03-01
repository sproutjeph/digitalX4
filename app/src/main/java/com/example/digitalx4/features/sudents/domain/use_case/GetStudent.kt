package com.example.digitalx4.features.sudents.domain.use_case

import com.example.digitalx4.features.sudents.data.repository.StudentRepository
import com.example.digitalx4.features.sudents.domain.model.StudentModel




class GetStudent(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(studentId: String) {
        studentRepository.getStudentById(studentId)
    }
}