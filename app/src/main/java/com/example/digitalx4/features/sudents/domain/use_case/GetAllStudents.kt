package com.example.digitalx4.features.sudents.domain.use_case

import com.example.digitalx4.features.sudents.data.repository.StudentRepository
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import kotlinx.coroutines.flow.Flow




class GetAllStudents(
    private val studentRepository: StudentRepository
) {
    operator fun invoke(): Flow<List<StudentModel>> {
        return studentRepository.getAllStudents()
    }
}
