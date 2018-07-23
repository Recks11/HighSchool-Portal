package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.Teacher
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface TeacherRepository: ReactiveMongoRepository<Teacher, String>