package com.example.digitalx4.ui.navigation

sealed class Screen(val route:String){
    object Home: Screen("home_screen")
    object Students: Screen("students_screen")
    object Reports: Screen("reports_screen")
    object AddEditReport: Screen("add_edit_report_screen?reportId={reportId}"){
        fun passReportId(reportId: String): String{
            return "add_edit_report_screen?reportId=$reportId"
        }
    }
    object InterestedPersons: Screen("interested_person_screen")
    object Schedule: Screen("schedule_screen")
    object AddEditStudent: Screen("add_edit_student_screen?studentId={studentId}") {
        fun passStudentId(studentId: String): String {
            return "add_edit_student_screen?studentId=$studentId"
        }
    }

    object StudentDetails: Screen("student_screen?studentId={studentId}"){
        fun passStudentId(studentId: String): String{
            return "student_screen?studentId=$studentId"
        }
    }






}
