package com.example.digitalx4.features.sudents.domain.use_case

data class StudentUseCases(
    val addStudent: AddStudent,
    val deleteStudent: DeleteStudent,
    val getAllStudents: GetAllStudents,
    val getStudent: GetStudent,
    val updateStudent: UpdateStudent
)
