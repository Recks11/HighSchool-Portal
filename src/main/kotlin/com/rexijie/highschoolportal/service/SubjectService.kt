package com.rexijie.highschoolportal.service

import com.rexijie.highschoolportal.model.Subject
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface SubjectService {
    fun findSubjectById(id: String): Mono<Subject>
    fun findSeniorSubjects(): Flux<Subject>
    fun findJuniorSubjects(): Flux<Subject>
}