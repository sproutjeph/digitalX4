package com.example.digitalx4.features.sudents.data.data_source

import androidx.room.*
import com.example.digitalx4.features.sudents.domain.model.StudentModel
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query("SELECT * from student_tbl")
    fun getAllStudents(): Flow<List<StudentModel>>

    @Query("SELECT * from student_tbl where id =:id")
    suspend fun getStudentById(id:String): StudentModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStudent(studentModel: StudentModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStudent(studentModel: StudentModel)

    @Query("DELETE from student_tbl")
    suspend  fun deleteAllStudents()

    @Delete
    suspend fun deleteStudent(studentModel: StudentModel)
}