package com.example.digitalx4.ui.navigation


enum class ServiceReportScreens {
    HomeScreen,
    StudentsScreen,
    ReportsScreen,
    UpDateReportScreen,
    AddEditReportScreen,
    InterestedPersonsScreen,
    ScheduleScreen;
    companion object{
        fun fromRoute(route:String?): ServiceReportScreens
                = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            StudentsScreen.name -> StudentsScreen
            ReportsScreen.name -> ReportsScreen
            UpDateReportScreen.name -> UpDateReportScreen
            AddEditReportScreen.name -> AddEditReportScreen
            InterestedPersonsScreen.name -> InterestedPersonsScreen
            ScheduleScreen.name -> ScheduleScreen
            null -> HomeScreen
            else -> throw IllegalAccessException("Route $route not found" )
        }
    }
}