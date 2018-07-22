package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentRepository: ReactiveMongoRepository<Student, String> {
}