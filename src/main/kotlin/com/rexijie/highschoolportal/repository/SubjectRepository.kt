package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.Subject
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface SubjectRepository: ReactiveMongoRepository<Subject, String> {
}