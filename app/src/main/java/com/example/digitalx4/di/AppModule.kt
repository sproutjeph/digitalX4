package com.example.digitalx4.di

import android.content.Context
import androidx.room.Room
import com.example.digitalx4.features.service_report.data.data_source.ServiceReportDatabase
import com.example.digitalx4.features.service_report.data.repository.ServiceReportRepository
import com.example.digitalx4.features.service_report.domain.repository.ServiceReportRepositoryImpl
import com.example.digitalx4.features.service_report.domain.use_case.*
import com.example.digitalx4.features.sudents.data.repository.StudentRepository
import com.example.digitalx4.features.sudents.domain.repository.StudentRepositoryImpl
import com.example.digitalx4.features.sudents.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesServiceReportDatabase(@ApplicationContext context: Context): ServiceReportDatabase =
        Room.databaseBuilder(
            context,
          klass =   ServiceReportDatabase::class.java,
            name = ServiceReportDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun providesServiceReportRepository(db: ServiceReportDatabase): ServiceReportRepository {
        return ServiceReportRepositoryImpl(db.serviceReportDao)
    }

    @Provides
    @Singleton
    fun providesServiceReportUseCases(repository: ServiceReportRepository): ServiceReportUseCases {
        return ServiceReportUseCases(
            getAllServiceReports = GetAllServiceReports(repository),
            deleteServiceReport = DeleteServiceReport(repository),
            addServiceReport = AddServiceReport(repository),
            getServiceReport = GetServiceReport(repository),
            upDateServiceReport = UpdateServiceReport(repository),
        )
    }

    @Provides
    @Singleton
    fun providesStudentRepository(db: ServiceReportDatabase):StudentRepository{
        return  StudentRepositoryImpl(db.studentDao)
    }

    @Provides
    @Singleton
    fun providesStudentUseCases(repository: StudentRepository): StudentUseCases{
        return StudentUseCases(
            getAllStudents = GetAllStudents(repository),
            deleteStudent = DeleteStudent(repository),
            addStudent = AddStudent(repository),
            updateStudent = UpdateStudent(repository),
            getStudent = GetStudent(repository)
        )
    }

}