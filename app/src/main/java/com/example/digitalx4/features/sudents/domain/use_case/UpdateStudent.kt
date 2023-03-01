package com.example.digitalx4.features.sudents.domain.use_case

import com.example.digitalx4.features.sudents.data.repository.StudentRepository
import com.example.digitalx4.features.sudents.domain.model.StudentModel



class UpdateStudent(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(studentModel: StudentModel) {
        studentRepository.updateStudent(studentModel)
    }
}