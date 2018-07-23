package com.rexijie.highschoolportal.repository

import com.rexijie.highschoolportal.model.Subject
import com.rexijie.highschoolportal.model.enums.Level
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface SubjectRepository: ReactiveMongoRepository<Subject, String> {
    fun findSubjectsByLevelEquals(level: Level): Flux<Subject>
}