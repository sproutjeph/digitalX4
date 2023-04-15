package com.example.digitalx4.features.sudents.domain.model

import androidx.compose.ui.graphics.toArgb
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.digitalx4.ui.theme.*
import java.time.Instant
import java.util.*

@Entity(tableName = "student_tbl")
data class StudentModel(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "student_name")
    val studentName: String,

    @ColumnInfo(name = "address")
    val address: String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "book_studying")
    val bookStudying: String,

    @ColumnInfo(name = "lesson")
    val lessonUnderConsideration: String,

    @ColumnInfo(name = "time_of_visit")
    val timeOfVisit: String,

    @ColumnInfo(name = "question")
    val questionToConsider: String,

    @ColumnInfo(name = "note")
    val noteAboutStudent: String,

    val studentColor: Int = studentColors.random().toArgb(),



    @ColumnInfo(name = "student_entry_date")
    val entryDate: Date = Date.from(Instant.now())
){
    companion object{
        val studentColors = listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink

        )
    }
}

