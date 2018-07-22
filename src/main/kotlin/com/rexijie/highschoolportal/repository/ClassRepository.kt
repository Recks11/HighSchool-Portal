package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.HighSchoolClass
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ClassRepository: ReactiveMongoRepository<HighSchoolClass, String> {
}