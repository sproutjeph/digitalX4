package com.example.digitalx4.features.sudents.domain.use_case

import com.example.digitalx4.features.service_report.domain.model.InvalidReportException
import com.example.digitalx4.features.sudents.data.repository.StudentRepository
import com.example.digitalx4.features.sudents.domain.model.StudentModel


class AddStudent(
    private val studentRepository: StudentRepository
) {
    @Throws(Exception::class, InvalidReportException::class)
    suspend operator fun invoke(studentModel: StudentModel) {
        if(studentModel.studentName.isBlank()){
            throw InvalidReportException("The name of Student can't be empty")
        }
        studentRepository.addStudent(studentModel)
    }
}